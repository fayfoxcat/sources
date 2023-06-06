package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HJ6 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(reader.readLine());
        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                value = value / i;
                System.out.print(i + " ");
                i--;
            }
        }
        if (value > 1) {
            System.out.print(value);
        }
    }
}
