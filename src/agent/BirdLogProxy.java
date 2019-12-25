package agent;

/**
 * @program: Java-learn
 * @description: 打印日志的鸟
 * @author: anthony1314
 * @create: 2019-12-25 16:44
 **/

public class BirdLogProxy implements Flyable  {
    private Flyable flyable;
    public BirdLogProxy(Flyable flyable){
        this.flyable = flyable;
    }

    @Override
    public void fly(){
        System.out.println("Bird fly start...");

        flyable.fly();

        System.out.println("Bird fly end...");
    }
}
