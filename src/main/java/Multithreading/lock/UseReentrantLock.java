package Multithreading.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class UseReentrantLock {
    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread A = new Thread(UseReentrantLock::print, "A");
        Thread B = new Thread(UseReentrantLock::print, "B");
        A.start();
        B.start();
    }

    public static void print() {
        lock.lock();
        try {
            Thread.sleep(200000);
            System.out.println("线程执行完成！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
