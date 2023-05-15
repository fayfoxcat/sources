package Multithreading.lock;

import Multithreading.Constant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class UseLock implements Runnable{

    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (Constant.value > 0){
            if(lock.tryLock()){
                try {
                    Constant.value --;
                    System.out.println(Constant.value);
                }catch (Exception e){
                    System.out.println("抛出异常："+e.getMessage());
                }finally {
                    lock.unlock();
                }
            }else {
                System.out.println("尝试加锁失败，等待中");
            }
        }
    }

    public static void main(String[] args) {
        Thread A = new Thread(new UseLock());
        Thread B = new Thread(new UseLock());
        A.start();
        B.start();
    }
}
