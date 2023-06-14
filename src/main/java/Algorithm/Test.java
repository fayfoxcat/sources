package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws IOException {
//        String str = "Bob hit a ball the hit BALL flew far after it was hit";
//        Map<String, Long> collect = Stream.of(str.toLowerCase(Locale.ROOT).split(" "))
//                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
//        System.out.println(collect);
//
//        Map<List<String>,String> a = new HashMap<>();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        char[] chars = reader.readLine().toCharArray();
//        System.out.println(chars);
//        HashSet<Object> objects = new HashSet<>();
//        System.out.println(Math.round(11.5));
        String a = "hello";
        String b = "he" + new String("llo");
        System.out.println(a==b);

    }

}
