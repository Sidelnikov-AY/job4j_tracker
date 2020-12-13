package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User findUser = null;
        for (User user : users.keySet()
             ) {
            if (user.getPassport().equals(passport)) {
                findUser = user;
                break;
           }
        }
        return findUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        User foundUser = findByPassport(passport);
        List<Account> accounts = users.get(foundUser);
        Account needAcc = null;
        if (!foundUser.equals(null)) {
            for (Account acc : accounts
            ) {
                if (acc.getRequisite().contains(requisite)) {
                    needAcc = acc;
                    break;

                }
            }
        }
        return needAcc;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}