package DesignPattern.ChainOfResponsibility;

public class ChainMain {
    public static void main(String[] args) {
        Message message = new Message(1,"动态",
                "2023年IT行业太卷了，不信你百度http://baidu.com 😒小黑子");

        ChainFilter filter = new ChainFilter();
        filter.add(new URLFilter()).add(new SensitiveFilter()).add(new FaceFilter());
        filter.doFilter(message);
        System.out.println(message);

    }

}
