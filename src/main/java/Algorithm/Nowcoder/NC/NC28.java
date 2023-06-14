package Algorithm.Nowcoder.NC;

import java.util.*;
import java.util.stream.Collectors;

public class NC28 {

    private static String[] t;

    private static boolean contains(String s) {
        List<String> collect = Arrays.stream(s.split("")).collect(Collectors.toList());
        for (String c : t) {
            if (!collect.contains(c)) {
                return false;
            }
            collect.remove(c);
        }
        return true;
    }

    public static String minWindow(String S, String T) {
        StringBuilder builder = new StringBuilder(S);
        String min = S;
        boolean flag = false;
        t = T.split("");
        int i = T.length();
        while (i <= S.length()) {
            for (int j = 0; j <= S.length() - i; j++) {
                String substring = builder.substring(j, j + i);
                if (contains(substring)) {
                    min = substring;
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
            i++;
        }
        return flag ? min : "";
    }


    public static void main(String[] args) {
        System.out.println(minWindow("XDOYEZODEYXNZ", "XYZ"));
    }
}
