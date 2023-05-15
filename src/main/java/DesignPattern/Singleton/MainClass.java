package DesignPattern.Singleton;

public class MainClass {
    public static void main(String[] args) {
        /*饿汉单例模式*/
        HungrySingleton singleton = HungrySingleton.getInstance();
        System.out.println(singleton.getName());

        /*懒汉单例模式*/
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton.getName());
    }
}
