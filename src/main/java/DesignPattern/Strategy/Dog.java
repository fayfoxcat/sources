package DesignPattern.Strategy;

public class Dog{

    Double fod;

    public Dog(Double fod) {
        this.fod = fod;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "fod=" + fod +
                '}';
    }
}
