package Multithreading.pool;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier（循环栅栏）
 */
public class UseCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Runnable master = new Thread(() -> System.out.println("执行主线程"));
        /*设置执行主线程条件*/
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, master);

        Runnable child = new Thread(() -> {
            System.out.println("执行子线程");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                System.err.println("异常："+e.getMessage());
            }
        });

        for (int i = 1;i<=2;i++){
            pool.submit(child);
        }

        Thread.sleep(2);
        pool.submit(child);

        /*重置栅栏*/
        cyclicBarrier.reset();

        for (int i = 1;i<=2;i++){
            pool.submit(child);
        }

        pool.shutdown();
    }
}
