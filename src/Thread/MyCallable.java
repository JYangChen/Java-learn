package Thread;

import java.util.concurrent.Callable;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 01:27
 **/

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception{
        String value = "test";
        System.out.println("Ready to Work");
        Thread.currentThread().sleep(5000);
        System.out.println("task done");
        return value;
    }
}
// 通过 FutureTask 获取

// 通过线程池获取

