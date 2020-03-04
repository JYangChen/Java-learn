package JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 16:26
 **/

public class CyclicBarrierDemo {
    public static void main(String[] args) throws
            InterruptedException {
        new CyclicBarrierDemo().go();
    }
    private void go() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(new Task(cyclicBarrier),
                "Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier),
                "Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(cyclicBarrier),
                "Thread3").start();
    }
    class Task implements Runnable {
        private CyclicBarrier cyclicBarrier;
        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run(){
            System.out.println("线程" +
                    Thread.currentThread().getName() + "已经到达" +
                    Thread.currentThread());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程" +
                            Thread.currentThread().getName() + "开始处理" +
                    Thread.currentThread());
        }
    }
}
