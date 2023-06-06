package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ4 {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String str = scanner.readLine();
        int len = str.length();
        int index = 0;
        while (len >= 8) {
            System.out.println(str.substring(index, index + 8));
            len = len - 8;
            index = index + 8;
        }
        if (len > 0) {
            char[] tmp = new char[8];
            for (int i = 0; i < 8; i++) {
                tmp[i] = '0';
            }
            for (int i = 0; index < str.length(); i++) {
                tmp[i] = str.charAt(index++);
            }
            System.out.println(String.valueOf(tmp));
        }
    }
}
