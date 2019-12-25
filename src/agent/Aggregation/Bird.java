package agent.Aggregation;

import java.util.Random;

/**
 * @program: Java-learn
 * @description: 鸟
 * @author: anthony1314
 * @create: 2019-12-25 16:41
 **/

public class Bird implements Flyable {
    @Override
    public void fly(){
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
