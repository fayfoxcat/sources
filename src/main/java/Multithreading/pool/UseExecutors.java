package Multithreading.pool;

import java.util.concurrent.*;

public class UseExecutors {
    public static void main(String[] args) {
        ExecutorService pools = Executors.newScheduledThreadPool(5);
        for (int i = 1;i <= 15;i++){
            pools.submit(new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("启动线程-"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
    }
}
