package Exception;

import JavaBase.Student;

/**
 * @author: wsy
 * @description: 精确异常
 * @since: 2023/11/1 16:49
 */
public class PrecisionException {

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getAge().equals(18));
    }
}
