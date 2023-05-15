package Multithreading.thread;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class HundredFlag implements Runnable{

    private static Integer value = 0;

    @Override
    public void run() {
        value += 1;
        System.out.println(Thread.currentThread().getName() + "执行，"+ DateUtil.formatDateTime(new Date())+" 值为：" + value);
    }

    public static void main(String[] args) {
        HundredFlag thread = new HundredFlag();
        for (int i= 0;value<9;i++){
            Thread A = new Thread(thread,"线程"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("休眠被终止");
            }
            A.start();
        }
    }
}
