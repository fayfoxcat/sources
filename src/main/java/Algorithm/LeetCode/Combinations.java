package Algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    /**
     * @param result 所有组合的结果
     * @param path   本次
     * @param n      总计元素个数
     * @param k      每次组合包含元素个数
     * @param start  起始遍历位置
     */
    private static void dfs(List<List<Integer>> result, List<Integer> path, int n, int k, int start) {
        /* 判读当前组合是否已满足k个元素 */
        if (path.size() == k) {
            /* 本次递归完成，存入数据到result */
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            /* 当前元素加入组合 */
            path.add(i);
            /* 遍历下个元素，起始位置+1 */
            dfs(result, path, n, k, i + 1);
            /*移除上次递归添加的元素，进入下次循环*/
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        System.out.println(result);
    }
}
