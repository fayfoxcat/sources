package Multithreading.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 可重入读写锁
 */
public class UseReadWriteLock{
    /*读写锁*/
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        /*线程池*/
        ExecutorService service = Executors.newCachedThreadPool();
        /*同时读写*/
        service.execute(new Runnable() {
            @Override
            public void run() {
                readFile(Thread.currentThread());
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                writeFile(Thread.currentThread());
            }
        });
    }

    /*读操作*/
    public static void readFile(Thread thread) {
        lock.readLock().lock();
        boolean readLock = lock.isWriteLocked();
        if (!readLock) {
            System.out.println("当前为读锁！");
        }
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + ":正在进行读操作……");
            }
            System.out.println(thread.getName() + ":读操作完毕！");
        } finally {
            System.out.println("释放读锁！");
            lock.readLock().unlock();
        }
    }

    /*写操作*/
    public static void writeFile(Thread thread) {
        lock.writeLock().lock();
        boolean writeLock = lock.isWriteLocked();
        if (writeLock) {
            System.out.println("当前为写锁！");
        }
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + ":正在进行写操作……");
            }
        }catch (Exception e){
            System.out.println(thread.getName() + ":写操作完毕！");
        } finally {
            System.out.println("释放写锁！");
            lock.writeLock().unlock();
        }
    }
}