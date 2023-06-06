package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ25 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] split1 = reader.readLine().split(" ");
        String[] I = new String[split1.length - 1];
        System.arraycopy(split1, 1, I, 0, I.length);
        String[] split2 = reader.readLine().split(" ");
        String[] t = new String[split2.length - 1];
        System.arraycopy(split2, 1, t, 0, t.length);
        int[] R = Arrays.stream(t).mapToInt(Integer::parseInt).sorted().toArray();
        Arrays.sort(R);
        StringBuilder builder = new StringBuilder();
        String pre = "";
        int total = 0;
        for (int k : R) {
            if (!pre.equals(String.valueOf(k))) {
                StringBuilder tmp = new StringBuilder();
                int count = 0;
                for (int i = 0; i < I.length; i++) {
                    if (I[i].contains(String.valueOf(k))) {
                        tmp.append(" ").append(i).append(" ").append(I[i]);
                        total += 2;
                        count++;
                    }
                }
                if (count > 0) {
                    total += 2;
                    builder.append(" ").append(k).append(" ").append(count).append(tmp);
                }
            }
            pre = String.valueOf(k);
        }
        builder.insert(0, total);
        System.out.println(builder);
    }
}