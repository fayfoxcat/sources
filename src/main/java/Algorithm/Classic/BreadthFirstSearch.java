package Algorithm.Classic;

import java.util.LinkedList;

/**
 * 广度优先搜索（Breadth-First-Search）
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0}
        };

        /* 从顶点5开始搜索图 */
        bfs(maze, 5);

        int start = 5;
        int[] result = minPath(maze, start);
        for (int i = 1; i < result.length; i++) {
            if (result[i] != 5) {
                System.out.println("从顶点" + start + "到顶点" + i + "的最短距离为：" + result[i]);
            } else {
                System.out.println("从顶点" + start + "到顶点" + i + "不可达");
            }
        }
    }

    /**
     * 函数求出从某顶点出发的搜索结果
     */
    public static void bfs(int[][] adjacentArr, int start) {
        int nodeNum = adjacentArr.length;
        if (start <= 0 || start > nodeNum) {
            System.out.println("错误输入！");
            return;
        } else if (nodeNum == 1) {
            System.out.println(adjacentArr[0][0]);
            return;
        }
        /*0表示顶点尚未入队，也未访问，注意这里位置0空出来了*/
        int[] visited = new int[nodeNum + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);

        /* 1表示入队 */
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int nodeIndex = queue.poll();
            System.out.println(nodeIndex);
            /* 2表示顶点被访问 */
            visited[nodeIndex] = 2;

            for (int i = 0; i < nodeNum; i++) {
                if (adjacentArr[nodeIndex - 1][i] == 1 && visited[i + 1] == 0) {
                    queue.offer(i + 1);
                    visited[i + 1] = 1;
                }
            }
        }
    }

    /**
     * 从start顶点出发，到图里各个顶点的最短路径
     */
    public static int[] minPath(int[][] adjacentArr, int start) {
        int nodeNum = adjacentArr.length;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int path = 0;
        int[] nodePath = new int[nodeNum + 1];
        for (int i = 0; i < nodePath.length; i++) {
            nodePath[i] = nodeNum;
        }
        nodePath[start] = 0;

        int inCount = 1;
        int outCount = 0;
        int tempCount = 0;

        while (path < nodeNum) {
            path++;
            while (inCount > outCount) {
                int nodeIndex = queue.poll();
                outCount++;

                for (int i = 0; i < nodeNum; i++) {
                    if (adjacentArr[nodeIndex - 1][i] == 1 && nodePath[i + 1] == nodeNum) {
                        queue.offer(i + 1);
                        tempCount++;
                        nodePath[i + 1] = path;
                    }
                }
            }

            inCount = tempCount;
            tempCount = 0;
            outCount = 0;
        }
        return nodePath;
    }

}