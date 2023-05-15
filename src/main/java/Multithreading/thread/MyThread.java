package Multithreading.thread;

/**
 * 实现Runnable接口
 */
public class MyThread implements Runnable{

    private Integer value = 10;

    public void run(){
        for(int i=0;i<3;i++){
            synchronized(this) {
                /*取得当前线程的名称*/
                System.out.print(Thread.currentThread().getName() + ": " + value);
                value = value + i;
                System.out.println(" + " + i + " = " + value);
            }
        }
    }
    public static void main(String[] args){
        /*定义Runnable子类对象*/
        MyThread my = new MyThread();
        /*设置线程A*/
        new Thread(my,"A").start();
        /*设置线程B*/
        new Thread(my,"B").start();
    }
};
