package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя, состояющую из ФИО и номера паспорта
 * @author Anton
 * @version 1.0
 */
public class User {
    /**
     * Хранение номера паспорта в переменной типа String
     */
    private String passport;

    /**
     * Хранение ФИО в переменной типа String
     */
    private String username;

    /**
     * Констуктор для класса User, при создании должны быть заданы номер паспорта и ФИО
     * @param passport номер паспорта пользователя
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     *
     * @return возвращает номер паспорта пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     *
     * @param passport устанавливает номер паспорта для пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     *
     * @return возвращает ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username устанавливает ФИО для пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение методп equals для поиска одинаковых пользователей по номеру паспорта
     * @param o - объект (пользователь) для сравнения
     * @return true - если номер паспорта пользователя совпадает с искомым, иначе - false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     *
     * @return - возвращает hash сумму для номера паспорта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}