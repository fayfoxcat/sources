package DesignPattern.Factory;

/**
 * 午餐抽象工厂方法
 */
public abstract class LunchAbstractFactory {

    /**
     * 创建主食
     */
    public abstract StapleFood createStapleFood();

    /**
     * 创建风格口味
     */
    public abstract Taste createTaste();
}
