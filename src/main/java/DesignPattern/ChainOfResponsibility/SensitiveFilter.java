package DesignPattern.ChainOfResponsibility;

public class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Message msg) {
        String result = msg.getContent().replace("小黑子", "");
        msg.setContent(result);
        return true;
    }
}
