package JavaBase.Date;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: wsy
 * @description: 在Java 17中添加了一个新的模式B
 * @since: 2023/11/1 16:53
 */
public class TestDate {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("B");
        Set<String> value = new HashSet<>();
        for (int i = 0; i < 23; i++) {
            value.add(dtf.format(LocalTime.of(i, 0)));
        }
        value.forEach(System.out::println);
    }
}
