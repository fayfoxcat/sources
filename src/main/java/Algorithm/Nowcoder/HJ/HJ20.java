package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HJ20 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder result = new StringBuilder();
        while ((str = reader.readLine()) != null) {
            if (str.length() <= 8) {
                result.append("NG").append("\n");
            } else {
                int upper = 0, lower = 0, number = 0, other = 0;
                char[] chars = str.toCharArray();
                for (char c : chars) {
                    if (c >= 'a' && c <= 'z') {
                        lower = 1;
                    } else if (c >= 'A' && c <= 'Z') {
                        upper = 1;
                    } else if (c >= '0' && c <= '9') {
                        number = 1;
                    } else {
                        other = 1;
                    }
                }
                if (lower + upper + number + other < 3) {
                    result.append("NG").append("\n");
                    continue;
                }
                boolean flag = false;
                for (int i = 0; i < 2; i++) {
                    if (flag) {
                        break;
                    }
                    int j = i;
                    while (j + 3 < chars.length) {
                        String p = str.substring(j, j + 3);
                        String first = str.substring(0, j);
                        String second = str.substring(j+3);
                        if (first.contains(p) || second.contains(p)) {
                            flag = true;
                            break;
                        }
                        j += 3;
                    }
                }
                if (flag) {
                    result.append("NG").append("\n");
                } else {
                    result.append("OK").append("\n");
                }
            }
        }
        System.out.println(result);
    }
}