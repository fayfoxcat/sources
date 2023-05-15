package Multithreading.atom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类使用
 */
public class UseAtomic {

    private static int num = 0;
    private static final AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(20);

        Runnable task = ()->{
            for (int i = 0; i < 5000; i++) {
                num++;
                value.getAndIncrement();
            }
        };

        for (int i = 0; i < 10; i++) {
            pool.submit(task);
        }

        Thread.sleep(1000);
        pool.shutdown();
        System.out.println("不安全操作：num = "+num);
        System.out.println("原子操作：value = "+value.getAndIncrement());
    }
}
