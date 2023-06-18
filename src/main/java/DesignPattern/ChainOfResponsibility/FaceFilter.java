package DesignPattern.ChainOfResponsibility;

public class FaceFilter implements Filter{



    @Override
    public boolean doFilter(Message msg) {
        String result = msg.getContent().replace("😒", "😊");
        msg.setContent(result);
        return false;
    }
}
