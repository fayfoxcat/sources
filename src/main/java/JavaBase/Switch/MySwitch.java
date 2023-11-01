package JavaBase.Switch;

/**
 * {@code @author:} wsy
 * {@code @description:} none
 * {@code @since:} 2023/11/1 14:48
 */
public class MySwitch {

    public static void main(String[] args) {
//        print(Fruit.APPLE);

//        System.out.println(print2(Fruit.UNKNOWN));

        System.out.println("输出：" + print3(Fruit.APPLE));
    }

    /**
     * switch语句
     * 箭头表示，不需要使用break语句，直接跳出switch语句
     *
     * @param fruit 水果
     */
    private static void print(Fruit fruit) {
        switch (fruit) {
            case APPLE, PEAR -> System.out.println("普通水果");
            case MANGO, AVOCADO -> System.out.println("进口水果");
            default -> System.out.println("未知水果");
        }
    }

    /**
     * switch语句
     * 箭头表示，不需要使用break语句，直接跳出switch语句，可以有返回值
     *
     * @param fruit 水果
     */
    private static String print2(Fruit fruit) {
        return switch (fruit) {
            case APPLE, PEAR -> "普通水果";
            case MANGO, AVOCADO -> "进口水果";
            default -> "未知水果";
        };
    }

    /**
     * switch语句
     * case里想做不止一件事，比如在返回之前先进行一些计算或者打印操作，
     * 可以通过大括号来作为case块，最后的返回值使用关键字yield进行返回
     *
     * @param fruit 水果
     */
    private static String print3(Fruit fruit) {
        return switch (fruit) {
            case APPLE, PEAR -> {
                System.out.println("关键词: " + fruit);
                yield "普通水果";
            }
            case MANGO, AVOCADO -> "进口水果";
            default -> "未知水果";
        };
    }

}
