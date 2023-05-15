package JavaBase.Other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 线性表,链表
 *
 * @author Wu Zhixuan
 * @date 2:37 下午 2021/5/27
 **/

public class ArrayListAndLinkedList {

    public static void main(String[] args) {
        compareTimeBetweenArrayListAndLinkedList(800000);
//        compareTimeBetweenArrayListAndLinkedList(400000);
    }

    public static void compareTimeBetweenArrayListAndLinkedList(int time) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < time; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime1 = System.currentTimeMillis();
        removeEven(linkedList);
        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        removeEven(arrayList);
        long endTime2 = System.currentTimeMillis();

        System.out.println("Time: " + time + " start...");

        System.out.println("Time: " + time + " LinkedList: " + (endTime1 - startTime1) + "; ArrayList: " + (endTime2 - startTime2));

        System.out.println("Time: " + time + " ...end");
        System.out.println();

    }

    public static void removeEven(List<Integer> targetList) {
        targetList.removeIf(integer -> integer % 2 == 0);

    }
}
