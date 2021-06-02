package ru.job4j.stream;
/*
Представьте, что разработчики JDK не сделали Stream API.

В этом задании Вам нужно реализовать каркас упрощенного Stream API.

package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    public static EasyStream of(List<Integer> source) {
        throw new UnsupportedOperationException();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> collect() {
        throw new UnsupportedOperationException();
    }
}
EasyStream работает только с типом Integer. В нем есть четыре метода

of - получает исходные данные.

map - преобразует число в другое число.

filter - фильтрует поток элементов.

collect - собирает все элементы из source по заданным условиям map и filter.

package ru.job4j.stream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.List;

public class EasyStreamTest {

    @Test
    public void whenEmptySource() {
        var rsl = EasyStream.of(List.of()).collect();
        assertThat(rsl, is(List.of()));
    }

    @Test
    public void whenFilledSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .collect();
        assertThat(rsl, is(List.of(1, 2, 3)));
    }

    @Test
    public void whenFilteredSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .filter(e -> e == 2)
                .collect();
        assertThat(rsl, is(List.of(2)));
    }

    @Test
    public void whenMappedSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .map(e -> e * 2)
                .collect();
        assertThat(rsl, is(List.of(2, 4, 6)));
    }

    @Test
    public void whenFilteredMappedSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .filter(e -> e == 2)
                .map(e -> e * 2)
                .collect();
        assertThat(rsl, is(List.of(4)));
    }

    @Test
    public void whenMappedFilteredSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3))
                .map(e -> e * 2)
                .filter(e -> e == 2)
                .collect();
        assertThat(rsl, is(List.of(2)));
    }

    @Test
    public void whenMultyFilterSource() {
        var rsl = EasyStream.of(List.of(1, 2, 3, 4, 5))
                .filter(e -> e >= 2)
                .filter(e -> e <= 4)
                .collect();
        assertThat(rsl, is(List.of(2, 3, 4)));
    }
}
В этом задании нужно использовать шаблон Builder.
* */


import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    public static EasyStream of(List<Integer> source) {
        throw new UnsupportedOperationException();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> collect() {
        throw new UnsupportedOperationException();
    }
}