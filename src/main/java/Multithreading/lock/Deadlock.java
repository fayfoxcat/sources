package Multithreading.lock;

class A {
    public void say() {
        System.out.println("张三对李四说：“你给我画，我就把书给你。”");
    }

    public void get() {
        System.out.println("张三得到画了。");
    }
}

class B {
    public void say() {
        System.out.println("李四对张三说：“你给我书，我就把画给你”");
    }

    public void get() {
        System.out.println("李四得到书了。");
    }
}

public class Deadlock implements Runnable {
    /*实例化static型对象*/
    private static final A zs = new A();
    private static final B ls = new B();
    /*声明标志位，判断那个先说话*/
    private boolean flag = false;

    public void run() {
        if (flag) {
            synchronized (zs) {
                zs.say();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ls) {
                    zs.get();
                }
            }
        } else {
            synchronized (ls) {
                ls.say();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (zs) {
                    ls.get();
                }
            }
        }
    }

    public static void main(String[] args) {
        Deadlock t1 = new Deadlock();
        Deadlock t2 = new Deadlock();
        t1.flag = true;
        t2.flag = false;
        Thread thA = new Thread(t1);
        Thread thB = new Thread(t2);
        thA.start();
        thB.start();
    }
};