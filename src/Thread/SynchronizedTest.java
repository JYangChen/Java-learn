package Thread;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-07 02:36
 **/

public class SynchronizedTest {
    public static void main(String[] args) {

        synchronized (SynchronizedTest.class){
            System.out.println("这是一个同步方法块");
        }
        test();
    }

    public static synchronized void test(){
        System.out.println("这是一个同步方法，因为在方法上使用了synchronized关键字");
    }
}
