package Interview.Ohter;

import java.util.*;

/**
 * 给定⼀个 ⽆向图 包含 N 个节点和 M 条边, 每条边 Mi 的代价为 Ci 。图中⼀条
 * 路径的惩罚是指对该路径上所有边的代价 Ci 执⾏位运算或（bitwise OR）操
 * 作得到的。假如⼀条路径上包含了边 M1，M2，M3 … … ，Mk，那么对应的惩
 * 罚就是 C1 OR C2 OR C3 OR ... OR Ck。（OR代表位运算或，即 “|” ）
 * 问题：给定图上两个节点 start 和 end，找到从 start 到 end 的所有路径中惩罚
 * 值最⼩的路径，对应的最⼩惩罚值作为结果返回。如果路径不存在就返回 -1。
 * 注意：任意两个节点之间最多存在⼀条边，图中可能存在有环路。
 * 需要实现的⽅法原型:
 * int minPath(int n, int[][] edges, int start, int end)
 * 参数含义：
 * n：节点总数；节点编号从 1 开始，⼀直到 n，共有 n 个；
 * edges：⽆向图的边；edges[i] 表示边Mi，其中 edges[i][0] 和
 * edges[i][1] 是Mi的两个节点的编号，edges[i][2] 是Mi对应的代价 Ci；
 * start 和 end：路径的开始和结束节点编号
 * 限制条件: 1 <= n <=1000
 * 1 <= edges.length <= 10000
 * 1 <= Ci <=1024
 * 例：edges = [ [1，2，1]，[2，3，3]，[1，3，100] ]，对应的图如下：
 * 当 start = 1，end = 3 时，其最⼩惩罚路径是 1->2->3, C(1,2)=1并且C(2,3)=3,
 * 对应的惩罚值为 1 | 3 = 3
 */
public class WeightedShortestPath {
    /*全局变量*/
    public static Set<List<Map<Integer, Integer>>> paths = new HashSet<>();

    public static void main(String[] args) {
        int n = 3;
        int start = 1;
        int end = 3;
        int[][] edges = {{1, 2, 1}, {2, 3, 3}, {1, 3, 100}};
        int path = minPath(n, edges, start, end);
        System.out.println(path);
    }

    private static int minPath(int n, int[][] edges, int start, int end) {
        List<Integer> valueList = new ArrayList<>();
        /*设置初始值*/
        List<Map<Integer, Integer>> path = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(start,1);
        path.add(map);
        /*递归调用*/
        abc(start, end, Arrays.asList(edges), path);
        /*获取每条路径值*/
        for (List<Map<Integer, Integer>> list:paths){
            int value = 1;
            for(Map<Integer, Integer> pMap:list){
                for(Integer key:pMap.keySet()){
                   value = pMap.get(key) | value;
                }
            }
            valueList.add(value);
        }
        return Collections.min(valueList);
    }

    /*递归算法，遍历链接节点*/
    public static void abc(int start, int end, List<int[]> data, List<Map<Integer, Integer>> path) {
        for (int[] node : data) {
            Map<Integer, Integer> map = new HashMap<>();
            /*查询是否存在节点且不在已走路径中*/
            boolean a = start == node[0] && path.stream().allMatch(o -> o.get(node[1]) == null);
            boolean b = start == node[1] && path.stream().allMatch(o -> o.get(node[0]) == null);
            if (a) {
                /*避免引用传递*/
                List<Map<Integer, Integer>> list = new ArrayList<>(path);
                map.put(node[1], node[2]);
                list.add(map);
                /*判断是否到达结束节点*/
                if (node[1] != end) {
                    abc(node[1], end, data, list);
                }else {
                    paths.add(list);
                }
            }
            if (b) {
                List<Map<Integer, Integer>> list = new ArrayList<>(path);
                map.put(node[0], node[2]);
                list.add(map);
                if (node[0] != end) {
                    abc(node[0], end, data, list);
                }else {
                    paths.add(list);
                }
            }
            if (!a && !b && start == end){
                List<Map<Integer, Integer>> list = new ArrayList<>(path);
                paths.add(list);
            }
        }
    }
}
