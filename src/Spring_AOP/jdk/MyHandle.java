package Spring_AOP.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-10 23:44
 **/

public class MyHandle implements InvocationHandler {


    //被代（dai）理的实例
    Object obj=null;

    //我要代（dai）理谁
    public MyHandle(Object obj){
        this.obj=obj;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("执行前");
        Object result=method.invoke(this.obj, args);
        System.out.println("执行后");
        return result;
    }

}
