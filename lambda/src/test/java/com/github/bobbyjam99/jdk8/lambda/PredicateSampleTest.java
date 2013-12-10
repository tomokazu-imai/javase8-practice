package com.github.bobbyjam99.jdk8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

public class PredicateSampleTest {

    /**
     * java.util.function.Predicate#testを利用して抽出
     */
    @Test
    public void 奇数のみ抽出1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> onlyOdds = PredicateSample.filter(n -> n % 2 != 0, numbers);
        assertThat(onlyOdds, contains(1, 3, 5, 7, 9));
    }

    /**
     * filterを利用して抽出
     */
    @Test
    public void 奇数のみ抽出2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> onlyOdds = numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        assertThat(onlyOdds, contains(1, 3, 5, 7, 9));
    }
}
