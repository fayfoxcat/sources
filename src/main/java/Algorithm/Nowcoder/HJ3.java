package Algorithm.Nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ3 {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        int[] list = new int[501];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(scanner.readLine());
            list[value] = value;
        }
        for (int i = 1; i < 501; i++) {
            if (list[i] != 0) {
                System.out.println(list[i]);
            }
        }
    }
}
