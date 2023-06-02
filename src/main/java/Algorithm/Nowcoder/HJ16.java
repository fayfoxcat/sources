package Algorithm.Nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HJ16 {

    static class VPQ {
        private int no;
        private int v;
        private int p;
        private int q;

        public VPQ(int no, int v, int p, int q) {
            this.no = no;
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public int getQ() {
            return q;
        }

        public void setQ(int q) {
            this.q = q;
        }

    }

    static int n, m;
    static List<VPQ> list = new ArrayList<>();
    static List<Integer> values = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        for (int i = 1; i <= m; i++) {
            String[] str = reader.readLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int p = Integer.parseInt(str[1]);
            int q = Integer.parseInt(str[2]);
            list.add(new VPQ(i, v, p, q));
        }
        for (int i = 0; i < m; i++) {
            total(i, n, 0, new HashSet<>());
        }
        System.out.println(values.stream().max(Integer::compareTo).orElse(0));
    }

    private static void total(int index, int balance, int sum, Set<Integer> pre) {
        for (int i = index; i < list.size(); ) {
            VPQ vpq = list.get(i);
            i++;
            if (vpq.getQ() == 0 || pre.contains(vpq.getQ())) {
                pre.add(vpq.getNo());
            } else {
                continue;
            }
            if (balance >= vpq.getV()) {
                total(i, balance -= vpq.getV(), sum += vpq.getV() * vpq.getP(), pre);
            } else {
                continue;
            }
            values.add(sum);
        }
    }
}