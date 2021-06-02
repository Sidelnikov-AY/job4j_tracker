package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private final List<Integer> source;

    public EasyStream(List<Integer> source) {
        this.source = source;
    }

    public static EasyStream of(List<Integer> source) {
        //throw new UnsupportedOperationException();
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        //throw new UnsupportedOperationException();
        List<Integer> list = new ArrayList<>();
        for (Integer el : source) {
            list.add(fun.apply(el));
        }
        return new EasyStream(list);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        //throw new UnsupportedOperationException();
        List<Integer> list = new ArrayList<>();
        for (Integer el : source) {
            if (fun.test(el)) {
                list.add(el);
            }
        }
        return new EasyStream(list);
    }

    public List<Integer> collect() {
        //throw new UnsupportedOperationException();
        return new ArrayList<>(source);
    }
}