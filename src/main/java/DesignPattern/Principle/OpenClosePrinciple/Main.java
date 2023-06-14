package DesignPattern.Principle.OpenClosePrinciple;

/**
 * 开闭原则：对扩展开放，对修改关闭
 */
public class Main {
    public static void main(String[] args) {
        SougouInput input = new SougouInput();

        /* 热插拔效果，声明不同皮肤，设置到input中使用 */
        ASkin aSkin = new ASkin();
        BSkin bSkin = new BSkin();

//        input.setSkin(aSkin);
        input.setSkin(bSkin);

        input.display();
    }
}
