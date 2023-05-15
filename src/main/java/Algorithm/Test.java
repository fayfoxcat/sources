package Algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String str = "Bob hit a ball the hit BALL flew far after it was hit";
        Map<String, Long> collect = Stream.of(str.toLowerCase(Locale.ROOT).split(" "))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(collect);

        Map<List<String>,String> a = new HashMap<>();
    }
}
