package Algorithm.Nowcoder.NC;

import java.util.Arrays;

public class NC61 {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target) {
                continue;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{20, 70, 110, 150};
        int target = 90;
        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
}
