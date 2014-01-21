package com.github.bobbyjam99.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateSample {

    public static <T> List<T> filter(Predicate<T> predicate, List<T> items) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
