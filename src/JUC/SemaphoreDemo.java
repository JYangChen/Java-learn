package JUC;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 16:30
 **/

public class SemaphoreDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(5);
        for (int id = 0; id < 20; id++) {
            final int NO = id;
            Runnable run = new Runnable(){
                public void run() {
                    try {
                        semp.acquire();
                        System.out.println("Accessing " + NO);
                        Thread.sleep((long) (Math.random() *
                                10000));
                        semp.release();
                    } catch (InterruptedException e) {

                    }
                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }
}
