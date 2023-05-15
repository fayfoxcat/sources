package Multithreading.pool;

import java.util.concurrent.*;

/**
 * 测试线程拒绝策略
 */
public class UseThreadRejection {
    public static void main(String[] args) throws Exception{
        /*创建线程等待队列*/
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(10);
        /*创建拒绝策略*/
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        /*创建线程池*/
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 2, 5,
                TimeUnit.SECONDS, workQueue, handler);

        for(int i=1; i<=30; i++) {
            executor.execute(task(i));
        }
    }
    private static Runnable task(Integer name) {
        return new Thread(() -> System.out.println("线程"+name+"正在执行"),"线程"+name);
    }
}
