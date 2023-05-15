package JavaBase.Sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 参考：https://www.cnblogs.com/flyingdreams/p/11161157.html
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{90,67,89,3,56,23,77,45,20,2};
        System.out.println(Arrays.toString(bubble(array)));
    }

    private static int[] bubble(int[] array){
        for (int y = array.length - 1; y > 0 ; y--) {
            for (int x = 0; x < y; x++) {
                if (array[x]>array[x+1]){
                    int t = array[x + 1];
                    array[x+1] = array[x];
                    array[x] = t;
                }
            }
        }

        return array;
    }
}
