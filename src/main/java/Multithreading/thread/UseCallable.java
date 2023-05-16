package Multithreading.thread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.FutureTask;

/**
 * 实现Callable，保证线程在执行完之前是阻塞的
 */
public class UseCallable {

    public static void main(String[] args) throws Exception {
        System.out.println(1 + ":主线程");
        FutureTask<String> task = new FutureTask<>(() -> {
            ThreadUtil.sleep(2000);
            System.out.println(2 + ":任务线程执行中");
            return 6 + ":任务线程返回结果";
        });
        System.out.println(3 + ":创建打印线程");
        Thread printThread = new Thread(() -> {
            try {
                System.out.println(task.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        /* printThread线程等待task线程返回结果才执行 */
        System.out.println(4 + ":启动打印线程");
        printThread.start();
        System.out.println(5 + ":启动任务线程");
        new Thread(task).start();

        Thread daemon = new Thread(() -> {
        });
        daemon.setDaemon(true);
        daemon.start();

    }
}
