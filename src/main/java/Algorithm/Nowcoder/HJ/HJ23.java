package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HJ23 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] cs = str.toCharArray();
        int[] arr = new int[cs.length];
        for (char c : cs) {
            arr[c]++;
        }
        int min = 20;
        for (char c : cs) {
            if (arr[c] != 0 && arr[c] < min) min = arr[c];
        }
        for (char c : cs) {
            if (arr[c] > min) System.out.print(c);
        }

    }
}