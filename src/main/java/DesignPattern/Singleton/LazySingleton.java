package DesignPattern.Singleton;

/*懒汉模式单例模式:*/
/*参考文章: https://blog.csdn.net/qq_22339269/article/details/90176392*/
public class LazySingleton {

    private final String name;

    private volatile static LazySingleton lazySingleton = null;

    private LazySingleton(String name){
        this.name = name;
    }

    public static LazySingleton getInstance(){
        /*双重检查加锁（DCL）:提升加锁导致性能降低，但由于jVM指令优化可能造成失效，建议使用内部类*/
        if (lazySingleton == null){
            /*加锁，防止多线程下导致多次new LazySingleton*/
            synchronized (LazySingleton.class){
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton("李四");
                }
            }
        }
        return lazySingleton;
    }

    public String getName() {
        return name;
    }
}
