package Algorithm.Nowcoder.NC;

import com.sun.deploy.util.StringUtils;

public class NC100 {

    public static int StrToInt(String s) {
        char[] array = s.trim().toCharArray();
        int sign = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0 && array[i] == '+') {
                sign = 1;
            } else if (i == 0 && array[i] == '-') {
                sign = -1;
            } else if (array[i] >= '0' && array[i] <= '9') {
                builder.append(array[i]);
            } else {
                break;
            }
        }
        StringBuilder tmp = new StringBuilder();
        String[] split = builder.toString().split("");
        boolean b = false;
        for (String str : split) {
            if (b) {
                tmp.append(str);
            } else if (!str.equals("0")) {
                b = true;
                tmp.append(str);
            }
        }

        if(tmp.toString().isEmpty()){
        return 0;
        }

    boolean flag = tmp.length() > String.valueOf(Integer.MIN_VALUE).length() || Long.parseLong(tmp.toString()) > Integer.MAX_VALUE;
        if(sign >0&&flag)

    {
        return Integer.MAX_VALUE;
    } else if(sign< 0&&flag)

    {
        return Integer.MIN_VALUE;
    }
        return(int)Long.parseLong(tmp.toString())*sign;
}

    public static void main(String[] args) {
        int i = StrToInt("9843131 ");
        System.out.println(i);
    }
}
