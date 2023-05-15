package Multithreading.lock;

/**
 * wait和notify使用
 */
public class UseWaitNotify {
    private static int num = 10;

    private static final Object MONITOR = new Object();

    private static void plus(Integer i){
        synchronized (MONITOR){
            if (num>10){
                MONITOR.notify();
                //MONITOR.notifyAll();
            }else {
                num ++;
                System.out.println("线程A执行+"+i+"，num = "+ num);
            }
        }
    }

    private static void minus(Integer i) throws InterruptedException {
        synchronized (MONITOR){
            if (num<=0){
                MONITOR.wait(200);
            }else{
                num --;
                System.out.println("线程B执行-"+i+"，num = "+ num);
            }
        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 1; ; i++) {
                try {
                    Thread.sleep(100);
                    minus(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 1; ; i++) {
                try {
                    Thread.sleep(300);
                    plus(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

    }
}
