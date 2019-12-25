package agent.Aggregation;

/**
 * @program: Java-learn
 * @description: 打印时间的鸟
 * @author: anthony1314
 * @create: 2019-12-25 16:47
 **/

public class BirdTimeProxy implements Flyable {
    private Flyable flyable;
    public BirdTimeProxy(Flyable flyable){
        this.flyable = flyable;
    }
    @Override
    public void fly(){
        long start = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        System.out.println("Fly time = " + (end - start));
    }

}
