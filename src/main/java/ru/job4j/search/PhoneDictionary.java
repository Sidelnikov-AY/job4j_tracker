package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> fName = f -> f.getName().contains(key);
        Predicate<Person> fSurname = f -> f.getSurname().contains(key);
        Predicate<Person> fAddress = f -> f.getAddress().contains(key);
        Predicate<Person> fPhone = f -> f.getPhone().contains(key);
        Predicate<Person> combine = fName.or(fSurname).or(fAddress).or(fPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}