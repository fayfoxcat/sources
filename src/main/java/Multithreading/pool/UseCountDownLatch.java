package Multithreading.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch（倒计时器）:
 */
public class UseCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch count = new CountDownLatch(20);
        for(int i=1;i<=30;i++){
            final int value = i;
            pool.submit(new Thread(()->{
                print(value);
                count.countDown();
            }));
        }
        /*await之后的都要等待，等countDownLatch减到0，await之后的才能执行*/
        count.await();
        System.out.println("前20项线程已执行完成，开始执行新计划");

        /*使用完成后关闭线程池*/
        pool.shutdown();
    }

    private static void print(Integer i){
        try {
            Thread.sleep(1000);
            System.out.println("线程：" + i);
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.err.println(e.getMessage());
        }
    }
}
