package JavaBase.Other.测试空实现Exception;

/**
 * @author: wsy
 * @date: 2023/9/28 13:45
 * @description:
 */
public class B extends A {

    @Override
    public void print() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        A b = new A();
        b.print();
    }
}
