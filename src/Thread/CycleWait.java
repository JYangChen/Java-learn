package Thread;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 01:23
 **/

public class CycleWait implements Runnable{
    private String value;
    public void run() {
        try{
            Thread.currentThread().sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        value = "xxxx";
    }
    public static void main(String[] args) throws InterruptedException {
        CycleWait cw = new CycleWait();
        Thread t = new Thread(cw);
        t.start();


        //       1.
//        while(cw.value == null){
//            Thread.currentThread().sleep(100);
//        }

        //      2.
//        t.join();
        System.out.println("value = " + cw.value);
    }
}
