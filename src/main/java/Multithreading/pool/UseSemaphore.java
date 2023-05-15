package Multithreading.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 使用信号量
 */
public class UseSemaphore {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        /*设置信号量为5*/
        Semaphore semaphore = new Semaphore(5);

        Runnable task = ()->{
            /*尝试获取信号量*/
            if(semaphore.tryAcquire()){
                try{
                    Thread.sleep(2000);
                    System.out.println("执行完成！");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    /*释放信号量*/
                    semaphore.release();
                }
            }else{
                System.err.println("暂无信号量可使用");
            }
        };

        for (int i = 1 ; i <= 20; i++){
            pool.submit(task);
        }


        pool.shutdown();
    }
}
