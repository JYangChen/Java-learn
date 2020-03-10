package Spring_AOP.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-11 00:01
 **/

public class MyApiInterceptorForPlay implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("出去玩我会先带好玩具"); // 此处可以做一些操作
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("玩一个小时我就回家了" );  // 方法调用之后也可以进行一些操作
        return result;
    }
}
