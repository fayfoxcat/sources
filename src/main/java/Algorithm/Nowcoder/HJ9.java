package Algorithm.Nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HJ9 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split("");
        StringBuilder buffer = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!buffer.toString().contains(split[i])) {
                buffer.append(split[i]);
            }
        }
        System.out.println(buffer);
    }
}
