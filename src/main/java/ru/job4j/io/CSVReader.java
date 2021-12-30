package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    private static ArgsName argsName = new ArgsName();

    static void handle(ArgsName argsName) throws Exception {
        isValidArgs(argsName);
        String delim = argsName.get("delimiter");
        String[] filters = argsName.get("filter").split(",");
        String path = argsName.get("path");
        String pathOut = argsName.get("stdout");
        try (Scanner scanner = new Scanner(Paths.get(path).toFile());
             PrintWriter writer = new PrintWriter("stdout".equals(pathOut)
                     ? System.out
                     : new FileOutputStream(argsName.get("out")))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] columns = line.split(delim);
                String headline = filter(line, columns, filters);
                if (headline.equals("")) {
                    throw new IllegalArgumentException("Wrong filter values.");
                }
                writer.println(headline);
                while (scanner.hasNext()) {
                    writer.println(filter(scanner.nextLine(), columns, filters));
                }
            }
        }
    }

    private static boolean check(String value, String[] filters) {
        boolean rsl = false;
        for (String filter : filters) {
            if (filter.equals(value)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static String filter(String line, String[] columns, String[] filters) {
        StringJoiner rsl = new StringJoiner(argsName.get("delimiter"));
        Scanner scanner = new Scanner(new ByteArrayInputStream(line.getBytes()))
                .useDelimiter(argsName.get("delimiter"));
        int index = 0;
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (check(columns[index++], filters)) {
                rsl.add(value);
            }
        }
        return rsl.toString();
    }

    public static void isValidArgs(ArgsName argsName) {
        String[] parameters = {"Path", "Delimiter", "Out", "Filter"};
        for (String parameter : parameters) {
            if (argsName.get(parameter.toLowerCase()) == null) {
                throw new IllegalArgumentException(String.format("%s parameter not found.", parameter));
            }
        }
        CSVReader.argsName = argsName;
        if (!Paths.get(argsName.get("path")).toFile().isFile()) {
            throw new IllegalArgumentException("File  not found");
        }
    }
}
