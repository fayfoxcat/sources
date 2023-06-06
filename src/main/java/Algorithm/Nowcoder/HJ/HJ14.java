package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HJ14 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            list[i] = reader.readLine();
        }
        Arrays.sort(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
