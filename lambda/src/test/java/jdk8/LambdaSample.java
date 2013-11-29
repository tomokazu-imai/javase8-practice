package jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
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

}