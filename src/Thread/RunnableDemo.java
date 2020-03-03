package Thread;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 01:23
 **/

public class RunnableDemo {
    public static void main(String[] args){
        MyRunnable mr1 = new MyRunnable("Thread1");
        MyRunnable mr2 = new MyRunnable("Thread2");
        MyRunnable mr3 = new MyRunnable("Thread3");
        Thread t1 = new Thread(mr1);
        Thread t2 = new Thread(mr2);
        Thread t3 = new Thread(mr3);
        t1.start();
        t2.start();
        t3.start();
    }
}
