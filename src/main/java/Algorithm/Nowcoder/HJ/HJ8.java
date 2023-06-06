package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HJ8 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] record = reader.readLine().split(" ");
            int a = Integer.parseInt(record[0]);
            int b = Integer.parseInt(record[1]);
            if (!map.containsKey(a)) {
                map.put(a, b);
            } else {
                map.put(a, map.get(a) + b);
            }
        }
        map.keySet().stream().sorted(Integer::compareTo).forEach(key -> {
            System.out.println(key + " " + map.get(key));
        });
    }
}
