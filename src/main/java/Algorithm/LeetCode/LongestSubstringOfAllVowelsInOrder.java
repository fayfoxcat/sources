package Algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringOfAllVowelsInOrder {
    public static int longestBeautifulSubstring(String word) {
        char[] array = word.toCharArray();
        char pre = 'a';
        StringBuilder builder = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        for (char c : array) {
            if (pre == 'a' && c == 'a') {
                builder.append(c);
            } else if ((pre == 'a' || pre == 'e') && c == 'e') {
                builder.append(c);
                pre = c;
            } else if ((pre == 'e' || pre == 'i') && c == 'i') {
                builder.append(c);
                pre = c;
            } else if ((pre == 'i' || pre == 'o') && c == 'o') {
                builder.append(c);
                pre = c;
            } else if ((pre == 'o' || pre == 'u') && c == 'u') {
                builder.append(c);
                pre = c;
            } else {
                String s = builder.toString();
                if (s.contains("a") && s.contains("e") && s.contains("i") && s.contains("o") && s.contains("u")) {
                    result.add(builder.length());
                }
                builder.setLength(0);
                if(c=='a'){
                    builder.append(c);
                }
                pre = 'a';
            }
        }
        String s = builder.toString();
        if (s.contains("a") && s.contains("e") && s.contains("i") && s.contains("o") && s.contains("u")) {
            result.add(builder.length());
        }
        return result.stream().max(Integer::compareTo).orElse(0);
    }

    public static void main(String[] args) {
        int i = longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu");
        System.out.println(i);
    }
}
