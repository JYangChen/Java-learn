package Spring_AOP.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-10 23:53
 **/

public class CallbackFilterImpl implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (method.getName().equals("play"))
            return 1;
        else
            return 0;
    }
}