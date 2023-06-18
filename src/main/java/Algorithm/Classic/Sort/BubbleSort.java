package Algorithm.Classic.Sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 参考：https://www.cnblogs.com/flyingdreams/p/11161157.html
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{90, 67, 89, 3, 56, 23, 77, 45, 20, 2};
        System.out.println(Arrays.toString(bubble(array)));
    }

    private static int[] bubble(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
