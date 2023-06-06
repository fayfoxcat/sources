package Algorithm.Nowcoder.HJ;

import java.util.Scanner;

public class HJ33_A {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String a = in.nextLine();
        String b = in.nextLine();
        String[] sp = a.split("\\.");
        long result = 0;
        for (String s : sp) {
            long num = Long.parseLong(s);
            result = (result << 8) | num;
        }
        System.out.println(result);
        long nums = Long.parseLong(b);
        StringBuilder bin = new StringBuilder(Long.toBinaryString(nums));
        while (bin.length() % 8 != 0) {
            bin.insert(0, "0");
        }
        StringBuilder bud = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String sub = bin.substring(i * 8, (i + 1) * 8);
            int i1 = Integer.parseInt(sub, 2);
            bud.append(i1);
            if (i != 3) {
                bud.append(".");
            }
        }
        System.out.println(bud);
    }
}