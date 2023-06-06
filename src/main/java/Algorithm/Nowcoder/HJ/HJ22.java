package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HJ22 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            int n = Integer.parseInt(str);
            if (n != 0) {
                int count = 0;
                while (n > 1) {
                    count++;
                    n -= 2;
                }
                System.out.println(count);
            }
        }
    }
}