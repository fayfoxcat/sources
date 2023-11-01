package JavaBase.Record;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: wsy
 * @description: none
 * @since: 2023/11/1 15:45
 */
@Data
@AllArgsConstructor
public class Person {
    private String name;

    private int age;

    private String address;

}
