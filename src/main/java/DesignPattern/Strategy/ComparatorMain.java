package DesignPattern.Strategy;

import java.util.Arrays;
import java.util.Date;

public class ComparatorMain {
    public static void main(String[] args) {
        Cat[] cats = {new Cat(4, new Date()), new Cat(2, new Date()), new Cat(6, new Date())};
        Dog[] dogs = {new Dog(3d), new Dog(9d), new Dog(6d)};

        Sorter<Dog> dogSorter = new Sorter<>();
        dogSorter.sort(dogs, new DogFodComparator());
        System.out.println(Arrays.toString(dogs));

        Sorter<Cat> catSorter = new Sorter<>();
        catSorter.sort(cats, new CatAgeComparator());
        System.out.println(Arrays.toString(cats));

        catSorter.sort(cats, new CatWeightComparator());
        System.out.println(Arrays.toString(cats));


    }
}
