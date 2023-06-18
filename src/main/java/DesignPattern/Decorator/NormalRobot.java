package DesignPattern.Decorator;

public class NormalRobot implements Robot{
    @Override
    public void feature() {
        System.out.println("1.唱歌");
        System.out.println("2.讲故事");
    }
}
