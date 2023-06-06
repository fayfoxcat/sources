package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ33 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = reader.readLine().split("\\.");
        long number = Long.parseLong(reader.readLine());
        StringBuilder resultA = new StringBuilder();
        for (String s : ip) {
            StringBuilder tmp = new StringBuilder(Long.toBinaryString(Long.parseLong(s)));
            while (tmp.length() % 8 != 0) {
                tmp.insert(0, "0");
            }
            resultA.append(tmp);
        }
        String[] split = resultA.toString().split("");
        long result = 0;
        int a = split.length - 1;
        for (String s : split) {
            result += Integer.parseInt(s) * Math.pow(2, a);
            a--;
        }
        System.out.println(result);

        StringBuilder convert = new StringBuilder(Long.toBinaryString(number));
        while (convert.length() % 8 != 0) {
            convert.insert(0, "0");
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < convert.length(); i += 8) {
            int sum = 0;
            String[] split1 = convert.substring(i, i + 8).split("");
            int b = split1.length - 1;
            for (String s : split1) {
                sum += Integer.parseInt(s) * Math.pow(2, b);
                b--;
            }
            builder.append(sum).append(".");
        }
        System.out.println(builder.substring(0, builder.length() - 1));

    }

}