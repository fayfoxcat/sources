package Algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;

        int count = findTargetSumWays(nums, target);
        System.out.println(count);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> expressionMap = new HashMap<>();
        int index = 0;
        for (int item = 0; item < nums.length; item++) {
            index = item;
            for (int element:nums){

            }
        }
        return expressionMap.size();
    }
}
