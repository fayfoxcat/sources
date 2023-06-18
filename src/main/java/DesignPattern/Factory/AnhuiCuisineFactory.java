package DesignPattern.Factory;

/**
 * 徽菜系列工厂方法
 */
public class AnhuiCuisineFactory extends LunchAbstractFactory {

    @Override
    public StapleFood createStapleFood() {
        return new Rice();
    }

    @Override
    public Taste createTaste() {
        return new Salty();
    }

}
