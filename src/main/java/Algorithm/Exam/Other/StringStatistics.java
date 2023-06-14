package Algorithm.Exam.Other;


import java.util.Scanner;

/**
 * 输入字符串，筛选A-Z的个数统计输出
 */
public class StringStatistics {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] array = s.toCharArray();
        int[] result = new int['Z' + 1];
        for (char c : array) {
            if (c >= 'A' && c <= 'Z') {
                result[c]++;
            }
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            System.out.println((char) (i) + ":" + result[i]);
        }
    }
}
