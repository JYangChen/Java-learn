package Spring_AOP.cglib;

import net.sf.cglib.proxy.*;


/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-10 23:52
 **/

public class TestCglib {
    public static void main(String[] args) {

        // 定义一个回调接口的数组
        Callback[] callbacks = new Callback[] {
                new MyApiInterceptor(), new MyApiInterceptorForPlay()
        };

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class); // 设置要代（dai）理的父类
        enhancer.setCallbacks(callbacks); // 设置回调的拦(lan)截器数组
        enhancer.setCallbackFilter(new CallbackFilterImpl()); // 设置回调选择器

        Person person = (Person) enhancer.create(); // 创建代（dai）理对象

        person.eat();
        System.out.println("--------------------");
        person.play();
    }
}
