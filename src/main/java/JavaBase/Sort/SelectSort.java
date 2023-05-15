package JavaBase.Sort;

import java.util.Arrays;

/**
 * 选择排序
 * 参考：https://www.cnblogs.com/flyingdreams/p/11161157.html
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{90,67,89,3,56,23,77,45,20,2};
        System.out.println(Arrays.toString(bubble(array)));
    }

    private static int[] bubble(int[] array){
        int n = array.length;
        for (int x = 0; x < n-1; x++) {
            int min = x;
            for (int y = x+1; y < n; y++) {
                if(array[min]>array[y]){
                    min = y;
                }
            }
            int temp = array[x];
            array[x] = array[min];
            array[min] = temp;
        }

        return array;
    }
}
