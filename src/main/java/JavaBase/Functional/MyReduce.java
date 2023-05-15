package JavaBase.Functional;

import JavaBase.Rectangular;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyReduce {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList());
        List<String> list2 = Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9").collect(Collectors.toList());

        Integer result = list.stream().reduce(Integer::min).orElse(0);


        Integer result2 = list.stream().reduce((a, b) -> a >= b ? a : b).orElse(0);

        String s = list2.stream().reduce("[value]:", String::concat);
        // System.out.println(s);

        List<String> reduce2 = list2.stream().reduce(new ArrayList<>(),
                (u, s1) -> {
                    u.add(s1);
                    return u;
                }, (strings, strings2) -> null);
        // System.out.println(reduce2);

        Integer reduce = Stream.of(1, 2, 3).reduce(4, Integer::sum, (integer, integer2) -> integer * integer2);
        // System.out.println(reduce);

        Integer reduce1 = Stream.of(1, 2, 3).parallel().reduce(4, Integer::sum, (integer, integer2) -> integer * integer2);
        // System.out.println(reduce1);

        Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        Predicate<String> predicate = t -> t.contains("a");
        s1.parallel().reduce(new ArrayList<String>(),
                (strings, s2) -> {
                    if (predicate.test(s2)) {
                        strings.add(s2);
                    }
                    return strings;
                },
                (strings, strings2) -> {
                    System.out.println(strings + "==" + strings2 + ":" + (strings == strings2));
                    return strings;
                }).forEach(System.out::println);

        List<Rectangular> collect = Stream.of(new Rectangular(10, 5), new Rectangular(4, 2),
                new Rectangular(18, 9)).collect(Collectors.toList());
    }
}
