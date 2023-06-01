package Algorithm.Nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split("");
        StringBuilder buffer = new StringBuilder();
        for (String str : split) {
            if (!buffer.toString().contains(str)) {
                buffer.append(str);
            }
        }
        System.out.println(buffer.length());
    }
}
