package DesignPattern.Decorator;

public class DecoratorMain {

    public static void main(String[] args) {

        /* 普通机器人功能实现 */
        Robot normalRobot = new NormalRobot();
        normalRobot.feature();

        /* Pro机器人功能实现 */
        Robot proRobot = new ProRobot(normalRobot);
        proRobot.feature();

    }

}
