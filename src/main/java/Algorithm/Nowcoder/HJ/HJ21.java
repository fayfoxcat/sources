package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HJ21 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = reader.readLine().toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');
        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');
        map.put('g', '4');
        map.put('h', '4');
        map.put('i', '4');
        map.put('j', '5');
        map.put('k', '5');
        map.put('l', '5');
        map.put('m', '6');
        map.put('n', '6');
        map.put('o', '6');
        map.put('p', '7');
        map.put('q', '7');
        map.put('r', '7');
        map.put('s', '7');
        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');
        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('z', '9');
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                c = map.getOrDefault(c, c);
            } else if (c >= 'A' && c < 'Z') {
                c = (char) (c + ('a' - 'A') + 1);
            } else if (c == 'Z') {
                c = 'a';
            }
            result.append(c);
        }

        System.out.println(result);
    }
}