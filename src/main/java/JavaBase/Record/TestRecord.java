package JavaBase.Record;

/**
 * @author: wsy
 * @description: none
 * @since: 2023/11/1 15:47
 */
public class TestRecord {
    public static void main(String[] args) {
        Person a = new Person("徐凤年", 18, "北凉");
        Person b = new Person("徐龙象", 16, "北凉");
        record PersonRecord(String name, int age) {
        }

        PersonRecord recordA = new PersonRecord(a.getName(), a.getAge());
        PersonRecord recordB = new PersonRecord(b.getName(), b.getAge());

        System.out.println(recordA.equals(recordB));
    }
}
