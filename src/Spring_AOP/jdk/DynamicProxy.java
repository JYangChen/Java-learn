package Spring_AOP.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-10 23:44
 **/

public class DynamicProxy {
    public static void main(String[] args){
        //定义一个people作为被代（dai）理的实例
        IPeople ple=new People();
        //定义一个handler
        InvocationHandler handle=new MyHandle(ple);

        //获得类加载器
        ClassLoader cl=ple.getClass().getClassLoader();

        //动态产生一个代（dai）理，下边两种方法均可
//        IPeople p=(IPeople) Proxy.newProxyInstance(cl, new Class[]{IPeople.class}, handle);
        IPeople p=(IPeople) Proxy.newProxyInstance(cl, ple.getClass().getInterfaces(), handle);

        //执行被代（dai）理者的方法。
        p.func();
        p.fun();
    }

}
