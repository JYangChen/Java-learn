package JUC;

import java.util.concurrent.CountDownLatch;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 16:24
 **/

public class Task implements Runnable {
    private CountDownLatch countDownLatch;
    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run(){
        System.out.println("线程" +
                Thread.currentThread().getName() + "已经到达" +
                Thread.currentThread());
        countDownLatch.countDown();
    }

}
