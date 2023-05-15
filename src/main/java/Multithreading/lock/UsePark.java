package Multithreading.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport的park()方法
 */
public class UsePark{
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(UsePark::print);
        Thread.sleep(2000);
        thread.start();
        /*唤醒子线程*/
        LockSupport.unpark(thread);

        System.out.println("主线程执行完成！");
    }

    public static void print() {
        System.out.println("print方法开始执行");
        /*阻塞当前线程*/
        LockSupport.park();
        System.out.println("print方法执行结束");
    }
}
