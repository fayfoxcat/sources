package Algorithm.Nowcoder.NC;

import java.util.ArrayList;
import java.util.List;

public class NC52 {

    public static boolean isValid(String s) {
        String[] split = s.split("");
        List<String> stack = new ArrayList<>();
        for (String str : split) {
            if (stack.size() > 0 && str.equals(")")) {
                String remove = stack.remove(stack.size() - 1);
                if (!remove.equals("(")) {
                    return false;
                }
            } else if (stack.size() > 0 && str.equals("]")) {
                String remove = stack.remove(stack.size() - 1);
                if (!remove.equals("[")) {
                    return false;
                }
            } else if (stack.size() > 0 && str.equals("}")) {
                String remove = stack.remove(stack.size() - 1);
                if (!remove.equals("{")) {
                    return false;
                }
            } else {
                stack.add(str);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("]");
        System.out.println(valid);
    }
}
