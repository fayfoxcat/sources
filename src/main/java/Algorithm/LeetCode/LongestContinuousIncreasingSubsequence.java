package Algorithm.LeetCode;

public class LongestContinuousIncreasingSubsequence {
    public static int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = findLengthOfLCIS(new int[]{1, 3, 5, 7});
        System.out.println(i);
    }
}
