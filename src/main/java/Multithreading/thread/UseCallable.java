package Multithreading.thread;

import cn.hutool.core.thread.ThreadUtil;
import java.util.concurrent.FutureTask;

public class UseCallable {



    public static void main(String[] args) throws Exception {
        System.out.println(1);
        FutureTask<Integer> task = new FutureTask<>(() -> {
            ThreadUtil.sleep(2000);
            System.out.println(2);
            return 6;
        });
        System.out.println(3);
        new Thread(task).start();
        System.out.println(4);
        Thread thread = new Thread(() -> {
            try {
                System.out.println(task.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        thread.start();
        System.out.println(5);

        Thread daemon = new Thread(() -> {});
        daemon.setDaemon(true);
        daemon.start();


    }
}
