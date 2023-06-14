package Algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MaximumNestingDepthOfTheParentheses {
    public static int maxDepth(String s) {
        int cnt = 0;
        int max = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt++;
                max = Math.max(cnt, max);
            } else if (ch == ')') {
                cnt--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
