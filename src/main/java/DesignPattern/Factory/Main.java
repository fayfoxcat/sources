package DesignPattern.Factory;

public class Main {

    public static void main(String[] args) {

        LunchAbstractFactory cuisineFactory = new GuangdongCuisineFactory();
        StapleFood stapleFood = cuisineFactory.createStapleFood();
        Taste taste = cuisineFactory.createTaste();
        stapleFood.Food();
        taste.print();

    }

}
