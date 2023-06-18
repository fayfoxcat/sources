package DesignPattern.ChainOfResponsibility;

public class URLFilter implements Filter{
    @Override
    public boolean doFilter(Message msg) {
        String result = msg.getContent().replace("http", "https");
        msg.setContent(result);
        return true;
    }
}
