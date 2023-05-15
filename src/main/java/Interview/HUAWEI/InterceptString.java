package Interview.HUAWEI;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 */
public class InterceptString {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        String[] array = s.split(" ");
//        System.out.println(array[array.length-1].length());

        /*方法二*/
        int times = 0;
        InputStream in = System.in;
        char c = (char) in.read();
        while(c != '\n'){
            if(c == ' '){
                times = 0;
            } else {
                times += 1;
            }
            c = (char)in.read();
        }
        System.out.println(times);
    }
}
