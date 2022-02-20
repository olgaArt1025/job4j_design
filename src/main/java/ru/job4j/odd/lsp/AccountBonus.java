package ru.job4j.odd.lsp;

/**
 * инвариант класса Account нарушается
 * отсутствует валидация пароля у потомка.
 */

public class AccountBonus extends Account {
    private String login;
    private String password;

    public AccountBonus(String login, String password) {
        super(login, password);
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

}
