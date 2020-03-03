package Thread;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 01:40
 **/

public class ObjectWaitDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(lock){
                    try{
                        lock.wait();
                        System.out.println("thread A is done");
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(lock){
                    System.out.println("thread B is done");
                    lock.notify();
                }
            }
        }).start();
    }
}
