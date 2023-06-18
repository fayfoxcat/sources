package DesignPattern.Factory;

/**
 * 粤菜系列工厂方法
 */
public class GuangdongCuisineFactory extends LunchAbstractFactory{
    @Override
    public StapleFood createStapleFood() {
        return new Noodles();
    }

    @Override
    public Taste createTaste() {
        return new Light();
    }
}
