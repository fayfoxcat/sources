package Multithreading.thread;

/**
 * 通过interrupt()方法中断其运行状态
 */
public class MyInterrupt implements Runnable {
    public void run() {
        System.out.println("1.进入run()方法");
        try {
            /*线程休眠10秒*/
            Thread.sleep(10000);
            System.out.println("2.已经完成了休眠");
        } catch (InterruptedException e) {
            System.out.println("3.休眠被终止");
            return; // 返回调用处
        }
        System.out.println("4.run()方法正常结束");
    }

    public static void main(String[] args) {
        MyInterrupt mt = new MyInterrupt();
        Thread t = new Thread(mt, "线程");
        /*启动线程*/
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("5.休眠被终止");
        }
        System.out.println("6.执行中断");
        /*中断线程执行*/
        t.interrupt();
    }
}
