package DesignPattern.Strategy;

public class DogFodComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.fod < o2.fod) {
            return -1;
        } else if (o1.fod > o2.fod) {
            return 1;
        }
        return 0;
    }
}
