package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HJ70 {

    private static int genNew(int[] a, int[] b) {
        int count = a[0] * a[1] * b[1];
        b[0] = a[0];
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, int[]> data = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split(" ");
            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(split[0]);
            tmp[1] = Integer.parseInt(split[1]);
            data.put(String.valueOf((char) (65 + i)), tmp);
        }
        List<String> stack = new ArrayList<>();
        char[] chars = reader.readLine().toCharArray();
        int count = 0;
        for (char s : chars) {
            if (s == ')') {
                String y = String.valueOf(stack.remove(stack.size() - 1));
                String x = String.valueOf(stack.remove(stack.size() - 1));
                int[] result = data.get(y);
                count += genNew(data.get(x), data.get(y));
                stack.remove(stack.size() - 1);
                stack.add(x + y);
                data.put(x + y, result);
            } else {
                stack.add(String.valueOf(s));
            }
        }
        System.out.println(count);
    }

}