package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HJ43 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = reader.readLine().split(" ");
        int l = Integer.parseInt(first[0]);
        int c = Integer.parseInt(first[1]);
        int[][] labyrinth = new int[l][c];
        for (int i = 0; i < l; i++) {
            String[] split = reader.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                labyrinth[i][j] = Integer.parseInt(split[j]);
            }
        }
        int i = 0, j = 0;
        LinkedList<int[]> path = new LinkedList<>();
        while (i < l && j < c) {
            if (labyrinth[i][j] == 0) {
                int[] current = {i, j};
                if (i == l - 1 && j == c - 1) {
                    path.add(current);
                    break;
                } else if (i < l - 1 && labyrinth[i + 1][j] == 0) {
                    i++;
                    path.add(current);
                } else if (j < c - 1 && labyrinth[i][j + 1] == 0) {
                    j++;
                    path.add(current);
                } else {
                    labyrinth[i][j] = 1;
                    if (i > 0 && labyrinth[i - 1][j] == 0) {
                        i--;
                    } else if (j > 0 && labyrinth[i][j - 1] == 0) {
                        j--;
                    } else {
                        int[] last = path.removeLast();
                        if (last[0] == i) {
                            j--;
                        } else {
                            i--;
                        }
                    }
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        path.forEach(o -> {
            builder.append("(").append(o[0]).append(",").append(o[1]).append(")\n");
        });
        System.out.println(builder);
    }
}