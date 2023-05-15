package JavaBase.Other.Base;

public class Apple {
    private int i = 0;
    private String abc  = "abc";

    public Apple(String abc){
        this("abc",abc);

    }

    public Apple(){

    }

    public Apple(String abc, String abc1) {

    }

    Apple eatApple() {
        i++;
        return this;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.i+"---"+apple.abc);
        apple.eatApple().eatApple();
        System.out.println(apple.i+"---"+apple.abc);
    }
}