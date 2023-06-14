package Algorithm.Nowcoder.NC;

import java.util.LinkedList;

public class NC17 {

    private static boolean isLoop(String a) {
        char[] array = a.toCharArray();
        for (int i = 0, j = array.length - 1; i <= j; i++, j--) {
            if (array[i] != array[j]) {
                return false;
            }
        }
        return true;
    }

    public static int getLongestPalindrome(String A) {
        int max = 0;
        for (int i = A.length(); i > 0; i--) {
            for (int j = 0; j < A.length() && j < i; j++) {
                String substring = A.substring(j, i);
                if (isLoop(substring)) {
                    max = Math.max(substring.length(), max);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("baabccc"));
    }
}
