package Interview.Ohter;

import java.util.Arrays;

/**
 * 达西面试题 1
 * 给定⼀个按开始时间从⼩到⼤排序的时间区间集合，请将重叠的区间合并。时
 * 间区间集合⽤⼀个⼆维数组表示，⼆维数组的每⼀⾏表示⼀个时间区间（闭区
 * 间），其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束。
 * 例 1：输⼊：[ [1, 3], [2, 6], [8, 10], [15, 18] ]
 *  返回： [ [1, 6], [8, 10], [15, 18]]
 *  解释：时间区间 [1, 3] 和 [2, 6] 有部分重叠，合并之后为 [1, 6]
 * 例 2：输⼊：[[1, 4], [4, 5]]
 *  返回：[[1, 5]]
 *  解释：时间区间[1，4] 和 [4，5]重叠了⼀个时间点，合并之后为 [1，5]
 * 需要实现的⽅法原型：int[][] merge(int[][] intervals)
 */
public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{ 1, 3 },{ 2, 6 },{ 8,10 },{ 15,18 }};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private static int[] [] merge(int [] [] intervals){
        int [] [] data = new int[intervals.length][];
        int[] original = intervals[0];
        data[0] = original;
        for (int x = 1; x <intervals.length ; x++) {
            int[] current = intervals[x];
            /*当前区间不包含在上一区间内*/
            if(current[0] > original[1]){
                data[x] = current;
            }else {
                /*合并区间*/
                data[x-1] = new int[]{original[0],Math.max(original[1],current[1])};
            }
            original = current;
        }
        return data;
    }
}
