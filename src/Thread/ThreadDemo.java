package Thread;

/**
 * @program: Java-learn
 * @description: 线程测试
 * @author: anthony1314
 * @create: 2020-03-04 01:20
 **/

public class ThreadDemo {
    public static void main(String[] args){
        MyThread mt1 = new MyThread("Thread1");
        MyThread mt2 = new MyThread("Thread2");
        MyThread mt3 = new MyThread("Thread3");
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
