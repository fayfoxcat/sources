package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HJ48 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> initial = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Integer target = initial.get(initial.size() - 1);
        List<Integer> list = initial.subList(2, initial.size() - 1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i += 2) {
            Integer a = list.get(i + 1);
            int pre = result.indexOf(a);
            if (pre == -1) {
                result.add(a);
                result.add(list.get(i));
            } else {
                result.add(pre + 1, list.get(i));
            }
        }
        result.remove(target);
        StringBuffer print = new StringBuffer();
        result.forEach(o -> print.append(o).append(" "));
        System.out.println(print);
    }
}