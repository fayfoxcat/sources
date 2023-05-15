package Interview.Ohter;

/**
 * 给定⼀个⾮空字符串 s 和⼀个缩写 abbr，请校验它们是否匹配。
 * 假设字符串中只包含⼩写字⺟，缩写中只包含⼩写字⺟和数字。缩写中的数字
 * 表示其缩略的字符数；连续多位数字表示⼀个多位数。
 * 例如，字符串 “word” 的缩写有且仅有以下这些：[“word", "1ord", "w1rd",
 * "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d",
 * "w3", “4"]。
 * 例 1：输⼊：s = “internationalization"，abbr = "i12iz4n"
 *  返回：true
 *  解释：abbr 中的 12 表示有⼗⼆个字符被缩略了。
 * 例 2：输⼊：s = “apple"，abbr = “a2e"
 *  返回：false
 * 需要实现的⽅法原型：boolean valid(String word, String abbr)
 */
public class AbbreviationValid {
    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(valid(word,abbr));
    }

    static boolean valid(String word, String abbr){
        int w = 0, a = 0, n = 0;
        while (w < word.length() && a < abbr.length()) {
            if (abbr.charAt(a) >= 48 && abbr.charAt(a) <= 57) {
                n = n * 10 + (abbr.charAt(a) - 48);
                /*排除以0开头的数字*/
                if (n == 0){
                    return false;
                }
                if (a == abbr.length() - 1){
                    w += n;
                }
            }else {
                w += n;
                n = 0;
                /*字符串长度不匹配或对应字符不匹配*/
                if (w >= word.length() || word.charAt(w) != abbr.charAt(a)) {
                    return false;
                }else {
                    w++;
                }
            }
            a++;
        }
        return w == word.length() && a == abbr.length();
    }
}
