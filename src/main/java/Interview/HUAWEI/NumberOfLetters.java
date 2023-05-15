package Interview.HUAWEI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 */
public class NumberOfLetters {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            char[] array = buf.readLine().toLowerCase().toCharArray();
            char input = buf.readLine().toLowerCase().charAt(0);
            int count = 0;
            for (char c : array) {
                count = c == input ? count+1 : count;
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
