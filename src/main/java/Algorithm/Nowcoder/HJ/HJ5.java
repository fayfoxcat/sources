package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine().substring(2);
        char[] chars = str.toCharArray();
        int result = 0;
        int a = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int value;
            if (chars[i] == 'A') {
                value = 10;
            } else if (chars[i] == 'B') {
                value = 11;
            } else if (chars[i] == 'C') {
                value = 12;
            } else if (chars[i] == 'D') {
                value = 13;
            } else if (chars[i] == 'E') {
                value = 14;
            } else if (chars[i] == 'F') {
                value = 15;
            } else {
                value = Integer.parseInt(String.valueOf(chars[i]));
            }
            result += value * Math.pow(16, a);
            a++;
        }
        System.out.println(result);
    }
}
