package Algorithm.Nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HJ16 {

    static class VPQ {
        private int no;
        private int v;
        private int p;
        private int q;

        private double rat;

        public VPQ(int no, int v, int p, int q, float rat) {
            this.no = no;
            this.v = v;
            this.p = p;
            this.q = q;
            this.rat = rat;
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

        public double getRat() {
            return rat;
        }

        public void setRat(double rat) {
            this.rat = rat;
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

        for (int i = 0; i < m; i++) {
            String[] str = reader.readLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int p = Integer.parseInt(str[1]);
            int q = Integer.parseInt(str[2]);
            list.add(new VPQ(i, v, p, q, p / (v * 1.0f)));
        }
        for (VPQ vpq : list) {
            abc(vpq.getNo(), n);
        }
        System.out.println(values.stream().max(Integer::compareTo).orElse(0));
    }

    private static Integer abc(int index, int cost) {
        int i = index;
        while (i < list.size()) {
            VPQ vpq = list.get(i);
            if (cost - vpq.getV() >= 0) {
                values.add(abc(i, cost - vpq.getV()) + vpq.getV() * vpq.getP());
            } else {
                return 0;
            }
            i++;
        }
        return 0;
    }
}
