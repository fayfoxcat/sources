package DesignPattern.Strategy;

import java.util.Date;

public class Cat {

    int weight;

    Date age;

    public Cat(int weight, Date age) {
        this.weight = weight;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", age=" + age +
                '}';
    }
}
