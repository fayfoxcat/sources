package Algorithm.Nowcoder;

import java.util.Scanner;

public class HJ1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int result = 0;
        for (char i : input.toCharArray()) {
            if (i == ' ') {
                result = 0;
            }else {
                result++;
            }
        }
        System.out.println(result);
    }
}
