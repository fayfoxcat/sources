package Algorithm.Nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int front = Integer.parseInt(str.substring(0, str.indexOf('.')));
        float back = Float.parseFloat("0" + str.substring(str.indexOf('.')));
        if (back >= 0.5f) {
            System.out.println(front + 1);
        } else {
            System.out.println(front);
        }

    }
}
