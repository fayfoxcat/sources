package Multithreading.thread;

/*
 * 子线程主线程交替执行
 */
public class UseThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程" + i);
        }
    }

    public static void main(String[] args) {
        new UseThread().start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程" + i);
        }
    }
}
