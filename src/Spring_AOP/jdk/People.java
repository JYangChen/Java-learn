package Spring_AOP.jdk;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-10 23:44
 **/

public class People implements IPeople{

    @Override
    public void fun() {
        System.out.println("这是fun方法");

    }

    @Override
    public void func() {
        System.out.println("这是func方法");

    }

}