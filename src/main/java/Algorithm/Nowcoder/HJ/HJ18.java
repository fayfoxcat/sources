package Algorithm.Nowcoder.HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ18 {

    private static boolean abc(String[] str) {
        boolean flag = true;
        for (int i = 1; i < str.length; i++) {
            int value = Integer.parseInt(str[i]);
            if (value < 0 || value > 255) {
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /* A B C D E ERROR PRIVATE */
        int[] total = new int[7];
        String str;
        while ((str = reader.readLine()) != null) {
            boolean flag = true;
            int[] tmp = new int[7];
            System.arraycopy(total, 0, tmp, 0, 7);
            String[] ip = str.split("~")[0].split("\\.");
            long mask = strToInt(str.split("~")[1]);
            if (Arrays.asList(ip).contains("*")) {

            } else if (Arrays.stream(ip).anyMatch(String::isEmpty)) {
                tmp[5]++;
                System.arraycopy(tmp, 0, total, 0, 7);
            } else {
                int first = Integer.parseInt(ip[0]);
                int second = Integer.parseInt(ip[1]);
                if (first > 0 && first <= 126) {
                    if (abc(ip)) {
                        tmp[0]++;
                    } else {
                        tmp[5]++;
                        flag = false;
                    }
                } else if (first == 0 || first == 127) {
                    break;
                } else if (first >= 128 && first <= 191) {
                    if (abc(ip)) {
                        tmp[1]++;
                    } else {
                        tmp[5]++;
                        flag = false;
                    }
                } else if (first >= 192 && first <= 223) {
                    if (abc(ip)) {
                        tmp[2]++;
                    } else {
                        tmp[5]++;
                        flag = false;
                    }
                } else if (first >= 224 && first <= 239) {
                    if (abc(ip)) {
                        tmp[3]++;
                    } else {
                        tmp[5]++;
                        flag = false;
                    }
                } else if (first >= 240 && first <= 255) {
                    if (abc(ip)) {
                        tmp[4]++;
                    } else {
                        tmp[5]++;
                        flag = false;
                    }
                } else {
                    tmp[5]++;
                    flag = false;
                }
                /* 判段私有地址*/
                if (first == 10) {
                    if (abc(ip)) {
                        tmp[6]++;
                    }
                } else if (first == 172) {
                    if (second >= 16 && second <= 31) {
                        if (abc(ip)) {
                            tmp[6]++;
                        }
                    }
                } else if (first == 192 && second == 168) {
                    if (abc(ip)) {
                        tmp[6]++;
                    }
                }
                if (flag) {
                    if (mask <= 0 || mask >= 0XFFFFFFFFL || (((mask ^ 0XFFFFFFFFL) + 1) | mask) != mask) {
                        total[5]++;
                    } else {
                        System.arraycopy(tmp, 0, total, 0, 7);
                    }
                } else {
                    System.arraycopy(tmp, 0, total, 0, 7);
                }
            }
        }
        StringBuilder print = new StringBuilder();
        for (int i : total) {
            print.append(i).append(" ");
        }
        System.out.println(print);
    }
    public static long strToInt(String str){
        char[] cs=str.toCharArray();
        long res=0,tmp=0,flag=0;
        for(char c:cs){
            if(c=='.'){
                res=res<<8|tmp;
                tmp=0;
                flag++;
            }
            else if(c>='0'&&c<='9'){
                tmp=tmp*10+c-'0';
                flag=0;
            }else{
                return -1;
            }
            if(flag>=2) return -1;

        }
        res=res<<8|tmp;
        return res;
    }
}