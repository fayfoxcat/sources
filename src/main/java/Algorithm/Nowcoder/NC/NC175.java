package Algorithm.Nowcoder.NC;

import java.util.LinkedList;

public class NC175 {

    public static boolean isValidString(String s) {
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> star = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //左括号下标和*入栈
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                //匹配括号
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        //检查未匹配的左括号和*号
        while (!left.isEmpty() && !star.isEmpty()) {
            int top1 = left.pop();
            int top2 = star.pop();
            //每一个左括号都必须有一个*号（视为右括号）与之匹配
            if (top1 > top2) {
                return false;
            }
        }
        return left.isEmpty();
    }

    public static void main(String[] args) {
        boolean validString = isValidString("(*(*(*(()");
        System.out.println(validString);
    }
}
