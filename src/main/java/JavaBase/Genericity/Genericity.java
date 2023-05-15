package JavaBase.Genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类型泛型擦除，在编译期间泛型被擦除
 */
public class Genericity {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.getClass().getMethod("add", Object.class).invoke(list, "abc");
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
