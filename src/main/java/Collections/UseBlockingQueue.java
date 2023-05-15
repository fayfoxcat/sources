package Collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞队列
 */
public class UseBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("元素" + i + "入队");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 1; i <= 12; i++) {
                try {
                    Thread.sleep(2000);
                    System.out.println("元素" + queue.take() + "出队");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        /*创建大小为2的线程池*/
        ExecutorService pool = Executors.newFixedThreadPool(2);
        /*线程池执行*/
        pool.submit(threadA);
        pool.submit(threadB);
        /*手动调用*/
        /*threadA.start();
        threadB.start();*/
    }
}
