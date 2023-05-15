package JavaBase.Functional;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 高阶函数
 */
public class MyHighFunction {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> makeAdder = z -> y -> z + y;

        int x = 2;

        Function<Integer, Integer> addA = makeAdder.apply(1);
        System.out.println(addA.apply(x));

        Function<Integer, Integer> addB = makeAdder.apply(5);
        System.out.println(addB.apply(x));


        BiFunction<Integer, Integer, String> multiply = (a, b) -> String.valueOf(a + b);
        System.out.println(multiply.apply(2, 3));
    }
}
