package Interview.HUAWEI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数
 */
public class BitOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.hasNextBigInteger();
        while (scanner.hasNextBigInteger()){
            int i = scanner.nextInt();
            int s = Integer.bitCount(i);
            System.out.println(s);
        }
    }
}
