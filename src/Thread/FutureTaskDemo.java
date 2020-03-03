package Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: Java-learn
 * @description: 通过 FutureTask 获取
 * @author: anthony1314
 * @create: 2020-03-04 01:27
 **/

public class FutureTaskDemo  {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()) {
            System.out.println("task has not finished");
        }
        try{
            System.out.println("task return: " + task.get());
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }

    }
}

