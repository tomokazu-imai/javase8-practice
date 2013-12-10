package jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

public class LambdaSample {

    @Test
    public void 先頭文字がhだった場合に全て大文字にする() {
        List<String> strList = new ArrayList<>();
        strList.add("hello world");
        strList.add("foo");
        strList.add("bar");
        strList.add("hoge");

        List<String> actual = strList.stream()
                .filter(s -> s.startsWith("h"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertThat(actual.get(0), is("HELLO WORLD"));
        assertThat(actual.get(1), is("HOGE"));
    }

    @Test
    public void 先頭文字がhだった場合に全て大文字にして最初の検索だけ返す() {
        List<String> strList = new ArrayList<>();
        strList.add("hello world");
        strList.add("foo");
        strList.add("bar");
        strList.add("hoge");

        Optional<String> actual = strList.stream()
                .filter(s -> s.startsWith("h"))
                .map(String::toUpperCase)
                .findFirst();

        assertThat(actual.get(), is("HELLO WORLD"));
    }

    @Test
    public void forEachはコレクションクラスでも使える() {
        Arrays.asList("foo", "bar", "baz").forEach(System.out::println);
    }

    @Test
    public void リダクション畳み込み() {

        assertThat(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).sum(), is(55));
    }

    @Test
    public void リダクション集計() {
        int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(Arrays.stream(ar).sum(), is(55));
    }

    @Test
    public void リダクションリスト変換() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> pows = list.stream().filter(i -> i < 5).map(i -> i * i).collect(Collectors.toList());
        assertThat(pows, contains(1, 4, 9, 16));
    }
}