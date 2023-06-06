package Algorithm.Classic;

public class BackPack {

    private static int abc(int capacity, int[][] items) {
        int[][] dp = new int[items.length + 1][capacity + 1];
        for (int y = 1; y < items.length + 1; y++) {
            int value = items[y - 1][0];
            int weight = items[y - 1][1];
            for (int x = 0; x < capacity + 1; x++) {
                if (x >= weight) {
                    dp[y][x] = Math.max(dp[y - 1][x], dp[y - 1][x - weight] + value);
                } else {
                    dp[y][x] = dp[y - 1][x];
                }
            }
        }
        return dp[items.length][capacity];
    }

    public static void main(String[] args) {
        int capacity = 10;
        int[][] items = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int result = abc(capacity, items);
        System.out.println(result);
    }
}
