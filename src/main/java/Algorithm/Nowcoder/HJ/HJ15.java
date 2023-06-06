package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ15 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int result = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                result++;
            }
            n /= 2;
        }
        System.out.println(result);
    }
}
