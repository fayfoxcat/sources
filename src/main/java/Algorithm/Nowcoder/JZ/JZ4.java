package Algorithm.Nowcoder.JZ;

public class JZ4 {
    public static boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; ) {
            for (int j = array[0].length - 1; j >= 0 && i < array.length; ) {
                int point = array[i][j];
                if (target > point) {
                    i++;
                } else if (target < point) {
                    j--;
                } else {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int[][] array2 = new int[][]{{1, 1}};
        boolean find = Find(16, array2);
        System.out.println(find);
    }

}
