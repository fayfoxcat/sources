package JavaBase.Genericity;

import java.util.Collection;
import java.util.List;

/**
 * 测试泛型的上界和下界
 */
public class Border {
    public static void main(String[] args) {
        MyGeneric<? extends Collection> a = new MyGeneric<>();

        MyGeneric<? super List> b = new MyGeneric<>();


    }
}
