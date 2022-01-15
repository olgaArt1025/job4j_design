package ru.job4j.jdbc;

import java.io.FileReader;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private static Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public static String createTable(String tableName) {
        return String.format("create table %s();", tableName);
    }

    public static String dropTable(String tableName) {
        return String.format("DROP TABLE  %s;", tableName);
    }

    public static String addColumn(String tableName, String columnName, String type) {
        return String.format("ALTER TABLE %s ADD %s %s;", tableName, columnName, type);

    }

    public static String dropColumn(String tableName, String columnName) {
        return String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName);
    }

    public static String renameColumn(String tableName, String columnName, String newColumnName) {
        return String.format("ALTER TABLE %s RENAME %s TO  %s;", tableName, columnName, newColumnName);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public void execute(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }


    public static void main(String[] args) throws Exception {
        properties = new Properties();
        properties.load(new FileReader(String.valueOf(Path.of("./data/editor.properties"))));
        TableEditor tableEditor = new TableEditor(properties);

        tableEditor.execute(createTable("demo_table"));
        System.out.println(getTableScheme(tableEditor.connection, "demo_table"));

        tableEditor.execute(addColumn("demo_table", "columnName", "VARCHAR(20)"));
        System.out.println(getTableScheme(tableEditor.connection, "demo_table"));

        tableEditor.execute(renameColumn("demo_table", "columnName", "newColumnName"));
        System.out.println(getTableScheme(tableEditor.connection, "demo_table"));

        tableEditor.execute(dropColumn("demo_table", "newcolumnName"));
        System.out.println(getTableScheme(tableEditor.connection, "demo_table"));

        tableEditor.execute(dropTable("demo_table"));
    }
}


