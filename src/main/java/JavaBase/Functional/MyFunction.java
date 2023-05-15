package JavaBase.Functional;

import java.util.function.Function;

/**
 * 关于Function接口
 */
public class MyFunction {
    public static void main(String[] args) {

        class innerIncrease implements Function<Integer, Integer> {
            @Override
            public Integer apply(Integer o) {
                return o + 1;
            }
        }
        innerIncrease increase2 = new innerIncrease();
        System.out.println(increase2.apply(3));


        Function<Integer, Integer> increase = x -> x + 1;
        Function<Integer, Integer> multiply = x -> x * 2;
        int x = 2;

        System.out.println(increase.apply(x));
        System.out.println(increase.compose(multiply).apply(x));
        System.out.println(increase.andThen(multiply).apply(x));

    }
}
