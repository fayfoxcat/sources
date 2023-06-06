package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HJ24_import_error {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] split = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(split[i]);
            for (int f = i; f > 0; f--) {
                int[] tmp = new int[n - i];
                System.arraycopy(split, i, tmp, 0, n - i);
                Arrays.sort(tmp);
                if (split[f - 1] < split[f]) {
                    list.add(0, split[f - 1]);
                }
            }
            for (int l = i; l < n - 1; l++) {
                if (split[l] > split[l + 1]) {
                    list.add(split[l + 1]);
                }
            }
            max = Math.max(list.size(), max);
        }

        System.out.println(n - max);
    }

    private static void abc(int[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] > tmp[i + 1]) {

            }else {

            }

        }
    }
}