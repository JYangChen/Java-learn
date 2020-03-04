package JUC;

import java.util.concurrent.CountDownLatch;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 16:15
 **/

public class CountDownLatchDemo {
    public static void main(String[] args) throws
            InterruptedException {
        new CountDownLatchDemo().go();
    }
    private void go() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Task(countDownLatch), "Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch), "Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch), "Thread3").start();
        countDownLatch.await();
        System.out.println("所有线程已到达，主线程开始执行" +
                System.currentTimeMillis());
    }
}
