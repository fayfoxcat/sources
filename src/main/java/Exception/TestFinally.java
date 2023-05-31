package Exception;

public class TestFinally {
    static int a = 0;

    private static int abc() {
        try {
            a++;
            return a;
        } catch (Exception e) {
            a--;
            return a;
        } finally {
            a = 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(abc());
        System.out.println(a);
    }

}
