package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HJ28_import_slow {

    public static Map<List<Integer>, Integer> cache = new HashMap<>();
    public static Map<Integer, Boolean> primeCache = new HashMap<>();

    private static boolean isPrime(int value) {
        Boolean flag = primeCache.get(value);
        if (flag != null) {
            return flag;
        }
        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                primeCache.put(value, false);
                return false;
            }
        }
        primeCache.put(value, true);
        return true;
    }

    private static int abc(List<Integer> array) {
        int max = 0;
        Integer c = cache.get(array);
        if (c != null) {
            return c;
        }
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {
                int count = 0;
                if (isPrime(array.get(i) + array.get(j))) {
                    count++;
                }
                int finalI = i;
                int finalJ = j;
                count += abc(array.stream().filter(o -> !o.equals(array.get(finalI))
                        && !o.equals(array.get(finalJ))).collect(Collectors.toList()));
                max = Math.max(count, max);
            }
        }
        cache.put(array, max);
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> array = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int max = abc(array);
        System.out.println(max);
    }

}