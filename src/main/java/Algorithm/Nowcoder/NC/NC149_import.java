package Algorithm.Nowcoder.NC;

public class NC149_import {

    public static void getNext(String s, int[] next) {
        for (int i = 1, j = 0; i < s.length(); ++i) {
            if (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static int kmp(String S, String T) {
        int count = 0;
        int[] next = new int[S.length()];
        getNext(S, next);

        for (int i = 0, j = 0; i < T.length(); ++i) {
            if (j > 0 && S.charAt(j) != T.charAt(i)) {
                j = next[j - 1];
            }
            if (S.charAt(j) == T.charAt(i)) {
                j++;
            }
            if (j == S.length()) {
                count++;
                j = next[j-1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int kmp = kmp("ababab", "abababab");
        System.out.println(kmp);
    }
}
