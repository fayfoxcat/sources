package DesignPattern.Singleton;

/**
 * 静态内部内实现单例（常用）
 */
public class InnerSingleton {
    private InnerSingleton(){

    }
    public static InnerSingleton getInstance(){
        return Inner.instance;
    }
    private static class Inner{
        private final static InnerSingleton instance =  new InnerSingleton();
    }
}
