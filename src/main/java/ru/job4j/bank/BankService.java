package ru.job4j.bank;

import java.util.*;

/**
 *  * Класс описывает модель работы банковской системы, позвоялет регистрировать,
 *  удалять пользователя из системы,
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
     * Проверка наличия счета у пользователя, если счет отсутствует,
     * то создание нового счета для пользователя,
     * если пользвоатель с таким паспортом уже существует
     * @param passport номер паспорта, по которому проивзоитдся поиск пользователя
     * @param account создаваемый аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport).get();
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Поиск пользваотеля по номеру пасспорта
     * @param passport - искомый паспорт
     * @return user - если пользователь с таким паспортом найден,
     * null - если такого пользователя нет.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
        }

    /**
     * Поиск счета пользователя по реквизитам
     * @param passport номер паспорта пользовател дял которого ищем счет
     * @param requisite реквизиты искомого счета
     * @return acc - если счет с заданными реквизитами у пользователя найден, иначе null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> foundUser = findByPassport(passport);
        return foundUser.flatMap(user -> users.get(user)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Перечисление денег с одного счёта на другой счёт
     * @param srcPassport паспорт пользователя, с чьего счета выполняется перевод
     * @param srcRequisite реквизиты счета пользователя, с которого выполняется перевод
     * @param destPassport паспорт пользователя, на чей счет выполняется перевод
     * @param destRequisite реквизиты счета пользователя, на который выполняется перевод
     * @param amount переводимая сумма денег
     * @return true - если первод выполнен, false - если перевод не удался
     * (отсутствуют необходимые счета либо недостаточная сумма на счете для перевода)
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isEmpty() || destAccount.isEmpty()
                || srcAccount.get().getBalance() - amount < 0) {
            return false;
        }
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
        return true;
    }
}