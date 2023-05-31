package Multithreading.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 使用场景：以生活中的情景为例，比如去医院体检，通常人们会提前去医院排队，
 * 但只有等到医生开始上班，才能正式开始体检，医生也要给所有人体检完才能下班，这种情况就要使用 CountDownLatch，
 * 流程为：患者排队 → 医生上班 → 体检完成 → 医生下班
 */
public class ExampleCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // 医院闭锁
        CountDownLatch hospitalLatch = new CountDownLatch(1);
        // 患者闭锁
        CountDownLatch patientLatch = new CountDownLatch(5);
        System.out.println("患者排队");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.execute(() -> {
//                try {
//                    hospitalLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("体检：" + j);
                patientLatch.countDown();
            });
        }
        System.out.println("医生上班");
        hospitalLatch.countDown();
        patientLatch.await();
        System.out.println("医生下班");
        executorService.shutdown();

    }
}
