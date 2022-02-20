package ru.job4j.odd.lsp;

public class Account {
    private String login;
    private String password;

    public Account(String login, String password) {
        isValid(password);
        this.login = login;
        this.password = password;
    }

    private void isValid(String password) {
        if (password.length() < 4) {
            throw new IllegalArgumentException("incorrect length");
        }
    }

    public void setPassword(String password) {
        isValid(password);
        this.password = password;
    }
}

