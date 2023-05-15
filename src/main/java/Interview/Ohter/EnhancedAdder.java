package Interview.Ohter;

import java.util.Scanner;

public class EnhancedAdder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String addend = scanner.next();
        String augend = scanner.next();
        String result = addLongInteger(addend, augend);
        System.out.println(result);
    }
    public static String addLongInteger(String addend,String augend){
        StringBuilder a = (new StringBuilder(addend)).reverse();
        StringBuilder b = (new StringBuilder(augend)).reverse();
        StringBuilder result = new StringBuilder();
        int temp = 0;

        for (int i = 0; i < Math.max(a.length(),b.length()); i++) {
            int add = 0;
            if (i<a.length()){
                add = Integer.parseInt(a.substring(i,i+1));
            }
            int aug = 0;
            if (i < b.length()){
                aug = Integer.parseInt(b.substring(i,i+1));
            }
            if( add + aug + temp > 9){
                temp = 1;
                result.append(String.valueOf(add + aug + temp).substring(1));
            }else{
                temp = 0;
                result.append(add+aug+temp);
            }
        }
        if (temp==1){
            result.append(0);
        }
        return result.toString();
    }
}
