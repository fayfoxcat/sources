package Algorithm.Nowcoder.NC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NC37 {


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    public static ArrayList merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            return intervals;
        }
        intervals.sort(Comparator.comparing(o -> o.start));
        Interval pre = intervals.get(0);
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval next = intervals.get(i + 1);
            if (next.start <= pre.end) {
                if (pre.end >= next.end) {
                    pre = new Interval(pre.start, pre.end);
                } else {
                    pre = new Interval(pre.start, next.end);
                }
            } else {
                result.add(pre);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> objects = new ArrayList<>();
        objects.add(new Interval(1, 4));
        objects.add(new Interval(2, 3));
        ArrayList merge = merge(objects);
        System.out.println(merge);
    }
}
