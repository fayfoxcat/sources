package Other;

import JavaBase.Stream.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    /*动态规划：找零算法*/
    static Integer dpMakeChange(List<Integer> coinList, Integer change, Map<Integer, Integer> minCoins) {
        for (int cents = 0; cents <= change + 1; cents++) {
            int coinCount = cents;
            int finalCents = cents;
            List<Integer> coins = coinList.stream().filter(o -> o < finalCents).collect(Collectors.toList());
            for (Integer j : coins) {
                if (minCoins.get(cents - j) + 1 < coinCount) {
                    coinCount = minCoins.get(cents - j) + 1;
                }
            }
            minCoins.put(cents, coinCount);
        }
        return minCoins.get(change);
    }

    public static void main(String[] args) {
//        List<Integer> coinList = new ArrayList<>(Arrays.asList(1, 5, 10, 25));
//        Integer change = 63;
//        Map<Integer, Integer> minCoins = new HashMap<>();
//        int value = dpMakeChange(coinList, change, minCoins);
//        System.out.println(value);
//        int column = 2;
//        Integer[] sumColumns2 = {3, 4, 6, 1};
//        Integer[] subColumns2 = {2, 4, 3, 9};
//        List<Object> collect2 =Stream.of(new Integer[]{column},sumColumns2, subColumns2)
//                .flatMap(Stream::of)
//                .distinct()
//                .collect(Collectors.toList());
//        collect2.forEach(System.out::println);

        List<String> strings = Stream.of("张三", "李四", "王五", "陈六").collect(Collectors.toList());
        long count = strings.stream().count();
        if (count == 3L) {

        }
        Predicate<Student> isMaleStudent = s -> s.getAge() >= 20 && "male".equals(s.getGender());
        Predicate<Student> isFemaleStudent = s -> s.getAge() > 18 && "female".equals(s.getGender());
        Predicate<Student> isStudentPassed = s -> s.getId() >= 20;

        // Testing if male student passed.
        Student student1 = new Student(19, "Mahesh", "male", 20);
        Boolean result = isMaleStudent.and(isStudentPassed).test(student1);
        System.out.println(result); //false

        // Testing if female student passed.
        Student student2 = new Student(22, "Gauri", "female", 40);
        result = isFemaleStudent.and(isStudentPassed).test(student2);
        System.out.println(result); //true

    }
}
