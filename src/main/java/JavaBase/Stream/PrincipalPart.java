package JavaBase.Stream;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrincipalPart {

    public static void main(String[] args) {

        AtomicReference<Integer> id = new AtomicReference<>(1);
        DateTime dateA = DateUtil.parse("1996-01-01");
        DateTime dateB = DateUtil.parse("2020-01-01");
        List<Student> initialStudents = Stream.of("张三", "李四", "王五", "陈六")
                .map(s -> new Student(id.getAndSet(id.get() + 1), s,
                        DateUtil.offsetDay(dateA, id.get()), DateUtil.offsetDay(dateB, id.get())))
                .collect(Collectors.toList());
        List<Student> resultStudents = initialStudents.stream().sorted(Comparator.comparing(Student::getBirthday)
                .thenComparing(Student::getLoginDate,Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(initialStudents);
        System.out.println(resultStudents);
    }
}
