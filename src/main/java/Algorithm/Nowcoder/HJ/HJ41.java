package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HJ41 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] weight = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] number = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        /* 初始化 0 重量组合 */
        Set<Integer> set = new HashSet<>();
        set.add(0);
        /* 遍历砝码种类 */
        for (int i = 0; i < n; i++) {
            /* 已遍历完成的砝码重量组合 */
            HashSet<Integer> already = new HashSet<>(set);
            /* 遍历每种砝码的个数 */
            for (int num = 1; num <= number[i]; num++) {
                /* 新重量组合 = 将已有砝码重量组合 + 本次遍历的砝码种类及数量 */
                for (Integer item : already) {
                    set.add(item + weight[i] * num);
                }
            }
        }
        System.out.println(set.size());
    }
}