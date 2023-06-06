package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HJ27 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        int k = Integer.parseInt(split[split.length - 1]) - 1;
        String target = split[split.length - 2];
        ArrayList<String> t = new ArrayList<>(Arrays.asList(target.split("")));
        Collections.sort(t);
        List<String> result = new ArrayList<>();
        for (int i = 1; i < split.length - 2; i++) {
            if (target.length() == split[i].length() && !target.equals(split[i])) {
                ArrayList<String> current = new ArrayList<>(Arrays.asList(split[i].split("")));
                Collections.sort(current);
                if (t.equals(current)) {
                    result.add(split[i]);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size() + (result.size() > k ? ("\n" + result.get(k)) : ""));
    }
}