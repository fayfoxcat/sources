package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ17 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] orders = reader.readLine().split(";");
        int x = 0, y = 0;
        for (String order : orders) {
            Integer l = abc(order);
            if (l == null) {
                continue;
            }
            switch (order.substring(0, 1)) {
                case "A":
                    x -= l;
                    break;
                case "D":
                    x += l;
                    break;
                case "S":
                    y -= l;
                    break;
                case "W":
                    y += l;
                    break;
            }
        }

        System.out.println(x + "," + y);
    }

    private static Integer abc(String l) {
        try {
            return Integer.parseInt(l.substring(1));
        } catch (Exception e) {
            return null;
        }
    }
}
