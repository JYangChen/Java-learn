package reflection;

import reflection.bean.People;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: Java-learn
 * @description: 使用反射创建实例
 * @author: anthony1314
 * @create: 2020-02-18 16:45
 **/

public class NewInstanceDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<People> c = People.class;

        //System.out.println(p.newInstance());
        // 必须保证构造方法不被私有化 且无参

        Constructor<People> con = c.getDeclaredConstructor();//调用默认构造器
        System.out.println(con);

        //私有的成员是受保护的,不能直接访问
        //若要访问私有的成员,得先申请一下
        con.setAccessible(true);//允许访问
        People p = con.newInstance();//成功，通过私有的受保护的构造方法创建了对象
        System.out.println("无参构造方法"+p);

        con = c.getDeclaredConstructor(String.class);//获取指定的构造方法
        System.out.println(con);

        con.setAccessible(true);//允许访问
        p = con.newInstance("codull");//成功，通过私有的受保护的构造方法创建了对象
        System.out.println("String构造方法"+p + " p的name " + p.getName());
    }
}
