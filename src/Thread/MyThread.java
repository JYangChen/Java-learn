package Thread;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 01:21
 **/

public class MyThread extends Thread {
    private String name;
    public MyThread (String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread start : " + this.name + " i = " + i);
        }
    }
}

