package Interview.Ohter;

/**
 * 数组取最空位置（1表示占用，0表示空置）
 */
public class MaiMosEmptyPositionn {
    public static void main(String[] args) {
        int[] array = {0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        System.out.println(Subscript(array));
    }

    private static int Subscript(int[] array) {
        int min = 0;
        int a = 0;
        int b = 0;
        int current = -1;
        int end = array[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 1) {
                current = i;
            } else if (current == -1) {
                min = 0;
                a++;
            }
            b = (i - current) / 2 + 1;
            if (b > a) {
                min = (i + current) % 2 == 0 ? (i + current) / 2 : (i + current) / 2 + 1;
            }
        }
        if (end != 1) {
            if ((array.length - 1 - current) > Math.max(a, b)) {
                min = array.length - 1;
            }
        }
        return min;
    }
}
