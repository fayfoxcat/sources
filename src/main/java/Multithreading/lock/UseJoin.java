package Multithreading.lock;

import cn.hutool.core.thread.ThreadUtil;

/**
 * join使用：thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程
 */
public class UseJoin {
    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(() -> {
            for (int i = 1 ; i<=5 ; i++){
                try {
                    Thread.sleep(100);
                    System.out.println("线程A第"+i+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 1 ; i<=5 ; i++){
                try {
                    Thread.sleep(300);
                    System.out.println("线程B第"+i+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();

        System.out.println("主线程执行");

    }
}
