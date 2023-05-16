package Multithreading.lock;

import Multithreading.User;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 依赖：引入jol-core查看对象结构
 * 锁升级过程
 */
public class LockUpgrade {

    /*控制台打印颜色*/
    private static final String color = "\033[%dm%s\033[0m";

    public static void main(String[] args) throws InterruptedException {
        /* 无锁状态 */
        User user1 = new User();
        System.out.println(String.format(color, 36, "无状态（001）：") + ClassLayout.parseInstance(user1).toPrintable());

        /*
           JVM默认延迟4s自动开启偏向锁，可通过 -XX:BiasedLockingStartupDelay=0 取消延迟
           关闭偏向锁，可通过-XX:-UseBiasedLocking=false
         */
        TimeUnit.SECONDS.sleep(5);
        User user2 = new User();
        System.out.println(String.format(color, 34, "启用偏向锁（101）：") + ClassLayout.parseInstance(user2).toPrintable());

        for (int i = 0; i < 2; i++) {
            synchronized (user2) {
                System.out.println(String.format(color, 34, "偏向锁（101），含线程id：") + ClassLayout.parseInstance(user2).toPrintable());
            }
            System.out.println(String.format(color, 34, "释放偏向锁（101），含线程id：") + ClassLayout.parseInstance(user2).toPrintable());
        }

        /* 创建线程抢占锁，迫使锁升级 */
        new Thread(() -> {
            synchronized (user2) {
                System.out.println(String.format(color, 32, "轻量级锁（00）：") + ClassLayout.parseInstance(user2).toPrintable());
                try {
                    /* 睡眠3秒钟 */
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format(color, 33, "轻量->重量级锁（10）：") + ClassLayout.parseInstance(user2).toPrintable());
            }
        }).start();

        /* 轻量级锁睡眠耗时，迫使新线程自旋尝试加锁失败，升级重量级锁 */
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            synchronized (user2) {
                System.out.println(String.format(color, 31, "重量级锁（10）：") + ClassLayout.parseInstance(user2).toPrintable());
            }
        }).start();
    }
}
