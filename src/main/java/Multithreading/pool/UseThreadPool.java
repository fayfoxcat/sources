package Multithreading.pool;

import java.util.concurrent.*;

/**
 * 使用Java线程池
 */
public class UseThreadPool {
    public static void main(String[] args) {
        /*创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空 闲线程，若无可回收，则新建线程。*/
        ExecutorService cachedPool = Executors.newCachedThreadPool();

        /*创建一个单线程化的线程池，它只会用唯一的工作线程来执行任 务，保证所有任务按照指定顺序执行。*/
        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();

        /*创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。*/
        ExecutorService fixedPool = Executors.newFixedThreadPool(5);

        /*创建一个定长线程池，支持定时及周期性任务执行。*/
        ExecutorService scheduledPool = Executors.newScheduledThreadPool(5);

        /*
         * 手动创建线程池
         * @param int corePoolSize 核心线程池大小
         * @param int maximumPoolSize 最大线程池大小
         * @param long keepAliveTime 线程最大空闲时间
         * @param TimeUnit unit 时间单位
         * @param BlockingQueue<Runnable> workQueue 线程等待队列
         * @param ThreadFactory threadFactory 线程创建工厂
         * @param RejectedExecutionHandler handler 拒绝策略
         *
         */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                0, 3,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            poolExecutor.submit(()->{
                System.out.println(finalI);
            });
        }
    }
}
