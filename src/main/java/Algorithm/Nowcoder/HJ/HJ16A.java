package Algorithm.Nowcoder.HJ;

import java.util.Scanner;

public class HJ16A {

    static class Goods {  //商品类
        int v;  //商品价格
        int p;  //商品重要度：1-5
        int q;  //主件or附件：0-主件，其他-编号几的附件
        int f1 = 0, f2 = 0;  //最多有两个附件
        int sat = 0;  //物品本身的满意度
        int sat_f1 = sat, sat_f2 = sat, sat_all = sat;  //主件+附件一、主件+附件二、主件+两附件的满意度
        int v_f1 = v, v_f2 = v, v_all = v;  //主件+附件一、主件+附件二、主件+两附件的价格

        public Goods() {
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

        public void setF1(int f1) {
            this.f1 = f1;
        }

        public void setF2(int f2) {
            this.f2 = f2;
        }

        public int getF1() {
            return f1;
        }

        public int getF2() {
            return f2;
        }

        public int getSat() {
            return sat;
        }

        public void setSat(int sat) {
            this.sat = sat;
        }

        public int getSat_f1() {
            return sat_f1;
        }

        public void setSat_f1(int sat_f1) {
            this.sat_f1 = sat_f1;
        }

        public int getSat_f2() {
            return sat_f2;
        }

        public void setSat_f2(int sat_f2) {
            this.sat_f2 = sat_f2;
        }

        public int getSat_all() {
            return sat_all;
        }

        public void setSat_all(int sat_all) {
            this.sat_all = sat_all;
        }

        public int getV_f1() {
            return v_f1;
        }

        public void setV_f1(int v_f1) {
            this.v_f1 = v_f1;
        }

        public int getV_f2() {
            return v_f2;
        }

        public void setV_f2(int v_f2) {
            this.v_f2 = v_f2;
        }

        public int getV_all() {
            return v_all;
        }

        public void setV_all(int v_all) {
            this.v_all = v_all;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();  //总钱数
            int m = sc.nextInt();  //可购买的物品数
            Goods[] tab = new Goods[m + 1];
            for (int i = 1; i < m + 1; i++) {
                Goods gd = new Goods();
                gd.setV(sc.nextInt());
                gd.setP(sc.nextInt());
                gd.setQ(sc.nextInt());
                gd.setSat(gd.getP() * gd.getV());
                tab[i] = gd;
            }
            for (int i = 1; i < m + 1; i++) {
                if (tab[i].getQ() != 0) {
                    if (tab[tab[i].getQ()].getF1() != 0)
                        tab[tab[i].getQ()].setF2(i);
                    else
                        tab[tab[i].getQ()].setF1(i);
                }
            }
            /* 计算每个主件与附件的不同组合之后的价格与满意度 */
            for (int i = 1; i < m + 1; i++) {
                if (tab[i].getF1() != 0) {
                    tab[i].setV_f1(tab[i].getV() + tab[tab[i].getF1()].getV());
                    tab[i].setSat_f1(tab[i].getSat() + tab[tab[i].getF1()].getSat());
                }
                if (tab[i].getF2() != 0) {
                    tab[i].setV_f2(tab[i].getV() + tab[tab[i].getF2()].getV());
                    tab[i].setSat_f2(tab[i].getSat() + tab[tab[i].getF2()].getSat());
                }
                if (tab[i].getF1() != 0 && tab[i].getF2() != 0) {
                    tab[i].setV_all(tab[i].getV() + tab[tab[i].getF1()].getV() + tab[tab[i].getF2()].getV());
                    tab[i].setSat_all(tab[i].getSat() + tab[tab[i].getF1()].getSat() + tab[tab[i].getF2()].getSat());
                }

            }

            int n = N / 10;
            int[][] dp = new int[m + 1][n + 1];  //前i件商品在余额j的情况下的最大满意度
            for (int i = 1; i < m + 1; i++) {
                for (int j = n; j >= 1; j--) {
                    if (tab[i].q != 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        if (tab[i].getF2() != 0 && (j * 10 >= tab[i].getV_all())) {
                            int tmp = Math.max(dp[i][j], dp[i - 1][(j * 10 - tab[i].getV_all()) / 10] + tab[i].getSat_all());
                            dp[i][j] = Math.max(dp[i - 1][j], tmp);
                        }
                        if (tab[i].getF2() != 0 && (j * 10 >= tab[i].getV_f2())) {
                            int tmp = Math.max(dp[i][j], dp[i - 1][(j * 10 - tab[i].getV_f2()) / 10] + tab[i].getSat_f2());
                            dp[i][j] = Math.max(dp[i - 1][j], tmp);
                        }
                        if (tab[i].getF1() != 0 && (j * 10 >= tab[i].getV_f1())) {
                            int tmp = Math.max(dp[i][j], dp[i - 1][(j * 10 - tab[i].getV_f1()) / 10] + tab[i].getSat_f1());
                            dp[i][j] = Math.max(dp[i - 1][j], tmp);
                        }
                        if (j * 10 >= tab[i].getV()) {
                            int tmp = Math.max(dp[i][j], dp[i - 1][(j * 10 - tab[i].getV()) / 10] + tab[i].getSat());
                            dp[i][j] = Math.max(dp[i - 1][j], tmp);
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
            System.out.println(dp[m][n]);
        }
    }
}