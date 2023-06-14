package Algorithm.Exam.Huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Objects;

public class eg1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split(" ");
            String D1 = split[0];
            String D2 = split[1];
            map.put(D1 + D2, D2 + D1);
        }
        String flag = n > 0 ? "True" : "False";
        for (String k : map.keySet()) {
            String d1 = map.get(k);
            String d2 = map.get(d1);
            if (!Objects.equals(k, d2)) {
                flag = "False";
                break;
            }
        }
        System.out.println(flag);
    }
}