package Algorithm.LeetCode;

/**
 * 判定输入字符串是否有效数字
 * 符合要求：["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 不符合要求：["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 */
public class validNumber {

    public static void main(String[] args) {
        String s = "Infinity";
        System.out.println(isNumber(s));
    }

    /**
     * 校验方法
     *
     * @param s 字符串
     * @return 返回值 true/false
     */
    public static boolean isNumber(String s) {
        String trim = s.trim();
        if (trim.contains("f") || trim.contains("F") || trim.contains("d") || trim.contains("D")){
            return false;
        }
        try {
            Double.parseDouble(trim);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
