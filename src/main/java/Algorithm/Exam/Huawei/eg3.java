package Algorithm.Exam.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 未完善
 */
public class eg3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        int tree = Integer.parseInt(reader.readLine());
        int length = array[array.length - 1];
        int[] list = new int[length + 1];
        for (int i : array) {
            list[i - 1] = i;
        }
        if (tree > 1) {
            int max = 1;
            for (int i = length / (tree - 1) + 1; i > 1; i--) {
                for (int j = 0; j < length - ((tree - 1) * i) && max == 1; j++) {
                    int count = tree;
                    for (int k = j; k < length && count > 0; k += i) {
                        if (list[k] > 0) {
                            count--;
                        } else {
                            break;
                        }
                    }
                    if (count == 0) {
                        max = i;
                    }
                }
            }
            System.out.println(max);
        } else {
            System.out.println(array[length]);
        }
    }
}