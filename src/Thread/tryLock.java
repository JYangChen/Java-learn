package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-07 15:21
 **/

public class tryLock {
    public static void main(String[] args) {

        System.out.println("开始");
        final Lock lock = new ReentrantLock();
        new Thread(() -> {
            String tName = Thread.currentThread().getName();
            if (lock.tryLock()) {
                System.out.println(tName + "获取到锁！");
            } else {
                System.out.println(tName + "获取不到锁！");
                return;
            }
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(tName + ":" + i);
                }
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println(tName + "出错了！！！");
            } finally {
                System.out.println(tName + "释放锁！！");
                lock.unlock();
            }

        }).start();

        new Thread(() -> {
            String tName = Thread.currentThread().getName();

            if (lock.tryLock()) {
                System.out.println(tName + "获取到锁！");
            } else {
                System.out.println(tName + "获取不到锁！");
                return;
            }

            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(tName + ":" + i);
                }

            } catch (Exception e) {
                System.out.println(tName + "出错了！！！");
            } finally {
                System.out.println(tName + "释放锁！！");
                lock.unlock();
            }
        }).start();

        System.out.println("结束");
    }
}
