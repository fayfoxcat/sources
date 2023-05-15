package DesignPattern.Singleton;


/**
 * 模拟饿汉单例模式
 * @author cat
 */
public class HungrySingleton {

    private final String name;

    /**
     * 使用final实例化对象，确保对象实例只有一个
     */
    private static final HungrySingleton SINGLETON = new HungrySingleton("张三");

    /**
     * 私有化构造方法
     * */
    private HungrySingleton(String name) {
        this.name = name;
    }

    /**
     * 以静态方法返回实例
     */
    public static HungrySingleton getInstance() {
        return SINGLETON;
    }

    public String getName() {
        return name;
    }

}
