package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета, состоящую из реквизитов счета и баланса
 * @author Anton
 * @version 1.0
 */
public class Account {

    /**
     * Хранение номера счета в переменной типа String
     */
    private String requisite;

    /**
     * Хранение суммы на счете в переменной типа double
     */
    private double balance;

    /**
     * Констпуктор класса Account, при создании должны быть заданы реквизиты и сумма на счете
     * @param  requisite номер счета
     * @param balance начальная сумма на счете
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     *
     * @return возвращает номер счета для заданного аккаунта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     *
     * @param requisite устанавливает номер счета для заданного аккаунта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     *
     * @return balance возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance устанавливает сумму счета для заданного аккаунта
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }


    /**
     *
     * Переопределение методп equals для поиска одинаковых счетов в аккаунте
     * @param o объект (реквизиты счета) для сравнения
     * @return true  - если реквизиты сравниваемых счетов равны,
     * false - если реквизиты отличаются или счет не существует
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     *
     * @return hash - возвращает hash сумму для реквизитов счета
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}