package Multithreading.lock;

import java.util.concurrent.TimeUnit;

/**
 * join使用：thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程
 * 注意：从源码上看，指定的线程必须是激活状态（isAlive）的，即调用了start方法
 */
public class UseJoin {
    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                    System.out.println("线程A第" + i + "执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("线程B第" + i + "执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        /*线程A被加入线程当前线程（主线程），直到线程A执行完毕后，才会继续执行主线程*/
        threadA.join();

        System.out.println("主线程执行");

    }
}
