package Algorithm.Classic;

/**
 * 构造堆
 */
public class ConstructHeap {

    /**
     * 返回左孩子
     *
     * @param i 当前节点
     * @return 左孩子节点
     */
    public static int left(int i) {
        return (i + 1) * 2 - 1;
    }

    /**
     * 返回右孩子
     *
     * @param i 当前节点
     * @return 右孩子节点
     */
    public static int right(int i) {
        return (i + 1) * 2;
    }

    /**
     * 返回父节点
     *
     * @param i 当前节点
     * @return 父节点
     */
    public static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 构建堆
     *
     * @param array      源数组
     * @param deepLength 堆大小
     * @return 返回堆
     */
    public static int createHeap(int[] array, int deepLength) {
        if (array.length < deepLength) {
            return -1;
        } else {
            int parentNode = parent(deepLength - 1);
            for (int i = parentNode; i >= 0; i--) {
                keepHeap(array, i, deepLength);
            }
            return 0;
        }
    }

    /**
     * 设置堆类型（最大堆）
     *
     * @param array      源数组
     * @param node       堆节点
     * @param heapLength 堆大小
     */
    public static void keepHeap(int[] array, int node, int heapLength) {
        int l = left(node);
        int r = right(node);
        int largest = node;
        if (l < heapLength && array[node] < array[l]) {
            largest = l;
        }
        if (r < heapLength && array[largest] < array[r]) {
            largest = r;
        }
        if (largest != node) {
            int temp = array[largest];
            array[largest] = array[node];
            array[node] = temp;
            keepHeap(array, largest, heapLength);
        }
    }

    /**
     * 打印堆结构
     * @param array 源数组
     */
    public static void print(int[] array) {
        int node = 2;
        int index = 1;
        System.out.println(array[0]);
        while (index < array.length) {
            int count = (int) Math.pow(2, node - 1);
            for (int p = 0; p < count && index + p < array.length; p++) {
                System.out.print(array[index + p] + "  ");
            }
            node++;
            index += count;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        createHeap(array, array.length);
        print(array);
    }
}
