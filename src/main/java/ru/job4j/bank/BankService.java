package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  * Класс описывает модель работы банковской системы, позвоялет регистрирвоать, удалять пользователя из системы,
 *  добавлять пользователя счет, переводить деньги с одного счета на другой
 *  * @author Anton
 *  * @version 1.0
 */
public class BankService {

    /**
     * Хранение данных о пользователях и их счетах осуществляется в структуре Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     *Создание нового пользователя
     * @param user создаваемый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Проверка наличие счета у пользователя, если счет отсутсвует, то создание нового счета для пользователя, если пользвоатель с таким паспортом уже существует
     * @param passport номер паспорта, по которому проивзоитдся поиск пользователя
     * @param account создаваемый аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Поиск пользваотеля по номеру пасспорта
     * @param passport - искомый паспорт
     * @return user - если пользователь с таким паспортом найден, null - если такого пользователя нет.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()
             ) {
            if (user.getPassport().equals(passport)) {
                return user;
                }
        }
        return null;
    }

    /**
     * Поиск счета пользователя по реквизитам
     * @param passport номер паспорта пользовател дял которого ищем счет
     * @param requisite реквизиты искомого счета
     * @return acc - если счет с заданными реквизитами у пользователя найден, иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> accounts = users.get(foundUser);
            for (Account acc : accounts
            ) {
                if (acc.getRequisite().contains(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Перечисление денег с одного счёта на другой счёт
     * @param srcPassport паспорт пользователя, с чьего счета выполняется перевод
     * @param srcRequisite реквизиты счета пользователя, с которого выполняется перевод
     * @param destPassport паспорт пользователя, на чей счет выполняется перевод
     * @param destRequisite реквизиты счета пользователя, на который выполняется перевод
     * @param amount переводимая сумма денег
     * @return true - если первод выполнен, false - если перевод не удался (отсутствуют необъодимые счета либо недостаточная сумма на счете для перевода)
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null || srcAccount.getBalance() - amount < 0) {
            return false;
        }
        destAccount.setBalance(destAccount.getBalance() + amount);
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        return true;
    }
}