package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HJ65 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        if (a.length() > b.length()) {
            String tmp = b;
            b = a;
            a = tmp;
        }
        String max = "";
        for (int i = a.length(); i > 0; i--) {
            for (int x = 0; x < a.length(); x++) {
                String substring = a.substring(x, i);
                if (b.contains(substring)) {
                    max = substring.length() >= max.length() ? substring : max;
                    break;
                }
            }
        }
        System.out.println(max);
    }
}