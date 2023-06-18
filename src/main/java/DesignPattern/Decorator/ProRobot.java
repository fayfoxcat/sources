package DesignPattern.Decorator;

public class ProRobot implements Robot{

    private Robot robot;

    public ProRobot(Robot robot) {
        this.robot = robot;
    }

    public void normalFeature() {
        robot.feature();
    }
    @Override
    public void feature(){
        normalFeature();
        System.out.println("3.跳舞");
        System.out.println("4.Rap");
    }
}
