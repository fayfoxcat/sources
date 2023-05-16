package Multithreading.lock;

import java.util.Objects;
import java.util.Vector;

/**
 * volatile不一定能保证线程安全，如下
 * count操作不是原子性的，所以无法保证线程安全
 * 输出结果：不是50表明线程不安全
 */
public class UseVolatile extends Thread {

    private static volatile int count = 0;

    private final Object abc = new Object();

    public static void main(String[] args) throws Exception {
        Vector<Thread> threads = new Vector<>();
        for (int i = 0; i < 10; i++) {
            UseVolatile thread = new UseVolatile();
            threads.add(thread);
            thread.start();
        }
        //等待子线程全部完成
        for (Thread thread : threads) {
            thread.join();
        }
        //输出结果，正确结果应该是50，实际却不是
        System.out.println(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                //休眠500毫秒
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized ((Object) count) {
                count++;
            }
        }
    }
}
