package agent;

/**
 * @program: Java-learn
 * @description: 启动函数
 * @author: anthony1314
 * @create: 2019-12-25 16:52
 **/

public class Main {
    public static void main(String[] args){
        Bird bird = new Bird();
        //日志在内 时间在外
//        BirdLogProxy b1 = new BirdLogProxy(bird);
//        BirdTimeProxy b2 = new BirdTimeProxy(b1);
        //日志在外 时间在内
        BirdTimeProxy b1 = new BirdTimeProxy(bird);
        BirdLogProxy b2 = new BirdLogProxy(b1);
        b2.fly();
    }
}
