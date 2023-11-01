package JavaBase.Number;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author: wsy
 * @description: 精简数字格式化支持NumberFormat
 * @since: 2023/11/1 16:59
 */
public class TestNumber {
    public static void main(String[] args) {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
        System.out.println(fmt.format(1000));
        System.out.println(fmt.format(100000));
        System.out.println(fmt.format(1000000));
    }
}
