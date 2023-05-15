package Interview.HUAWEI;

import java.util.Scanner;

public class approximation {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入：");
        float input = scanner.nextFloat();
        String value = String.valueOf(input);
        int i = value.indexOf(".");
        int integer = Integer.parseInt(value.substring(i + 1, i + 2));
        int output = Integer.parseInt(value.substring(0,i)) + (integer >= 5 ? 1 : 0);
        System.out.println(output);
    }*/
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        sc.hasNextDouble();
        while(sc.hasNextDouble()){
            double l = sc.nextDouble();
            int value = (int) l;
            System.out.println( l-value >= 0.5 ? ++value : value );
        }
    }
}
