package factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: Java-learn
 * @description: 多线程下 运行map
 * @author: anthony1314
 * @create: 2020-04-19 00:45
 **/

public class threadtest extends Thread{
    private String name;
    private static Map<String, String> mp = new ConcurrentHashMap<>();
    public threadtest(String ss){
        name = ss;
    }

    public static void main(String[] args) {
        threadtest t1 = new threadtest("aaa");
        threadtest t2 = new threadtest("bbb");
        threadtest t3 = new threadtest("ccc");
        t1.start();
        t2.start();
        t3.start();
    }

    public void run(){
        mp.put(name, "qqq");
        System.out.println(mp.size()+ "thread" + name + "运行完成");
    }
}
