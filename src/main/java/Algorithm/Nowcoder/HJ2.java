package Algorithm.Nowcoder;

import java.util.Scanner;

public class HJ2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char c = in.next().toCharArray()[0];
        char c2;
        if(c>='A' && c<='Z'){
            c2=(char)(c+('a'-'A'));
        }else if(c>='a' && c<='z'){
            c2=(char)(c-('a'-'A'));
        }else{
            c2=c;
        }
        int result = 0;
        for(char i:str.toCharArray()){
            if(i==c||i==c2){
                result++;
            }
        }
        System.out.println(result);
    }
}
