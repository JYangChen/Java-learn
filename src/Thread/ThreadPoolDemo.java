package Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: Java-learn
 * @description: 通过线程池获取
 * @author: anthony1314
 * @create: 2020-03-04 01:28
 **/

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCacheThreadPool =
        Executors.newCachedThreadPool(); //创建新线程池
        Future<String> future = newCacheThreadPool.submit(new MyCallable());
        if (!future.isDone()) {
            System.out.println("task has not finished");
        }
        try {
            System.out.println("future return: " + future.get());
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }

    }
}