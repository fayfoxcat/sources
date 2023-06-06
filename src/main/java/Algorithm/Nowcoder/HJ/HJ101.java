package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HJ101 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sort = Integer.parseInt(reader.readLine());
        if (sort > 0) {
            list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        } else {
            list = list.stream().sorted().collect(Collectors.toList());
        }
        StringBuilder result = new StringBuilder();
        list.forEach(o -> result.append(o).append(" "));
        System.out.println(result);
    }

}