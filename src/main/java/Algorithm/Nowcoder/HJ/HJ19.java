package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HJ19 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while ((str = reader.readLine()) != null) {
            String path = str.split(" ")[0];
            String no = str.split(" ")[1];
            String[] split = path.split("\\\\");
            String name = split[split.length - 1];
            if (name.length() > 16) {
                name = name.substring(name.length() - 16);
            }
            String key = name + "*" + no;
            Integer point = map.get(key);
            if (map.get(key) != null) {
                map.put(key, ++point);
            } else {
                map.put(key, 1);
            }
        }


        int index = map.size() > 8 ? map.size() - 8 : 0;
        AtomicInteger a = new AtomicInteger();
        map.forEach((k, v) -> {
            if (a.get() >= index) {
                String[] split = k.split("\\*");
                System.out.println(split[0] + " " + split[1] + " " + v);
            }
            a.getAndIncrement();
        });
    }
}