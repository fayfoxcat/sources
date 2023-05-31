package JavaBase.Package;

/**
 * @author cat
 * url https://blog.csdn.net/qq_45737068/article/details/107149922
 */
public class TestString {

    public static void main(String[] args) {
        String s1 = new String("1") + new String("1");
        s1.intern();
        String s2 = "11";
        System.out.println(s1 == s2);
    }
}
