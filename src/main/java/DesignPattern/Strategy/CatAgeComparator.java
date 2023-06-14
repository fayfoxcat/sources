package DesignPattern.Strategy;

public class CatAgeComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.age.equals(o2.age)) {
            return 0;
        } else if (o1.age.before(o2.age)) {
            return -1;
        } else {
            return 1;
        }

    }
}
