package factory;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-04-19 22:03
 **/

public class threadtestTwo extends Thread{
    public static void main(String[] args) throws InterruptedException {
        threadt ta = new threadt("aaaaa");
        threadtt tb = new threadtt("bbbbb");
      //  ta.sleep(10000);
        System.out.println("--------------------------");

        ta.run();
        tb.run();
        System.out.println("--------------------------");

    }
}
class threadt extends Thread{
    private String name;
    public threadt(String ss){
        name = ss;
    }
    public void run(){
       // for(int i = 0; i < 100000000; i++)
        System.out.print("aaaaa");
        System.out.println();
        try {
            String ss = new String("qqqq");
            ss.wait(100000);
            //ss.notify();
            //Thread.sleep(10000);
        }catch (Exception E){

        }

        for(int i = 0; i < 10; i++){
            System.out.println(name + "=======");
        }
    }
}
class threadtt extends Thread{

    private String name;
    public threadtt(String ss){
        name = ss;
    }
    public void run(){
       // for(int i = 0; i < 100000000; i++)
        System.out.print("bbbbb");
        System.out.println();
        System.out.println("b线程开始");
//        try {
//            Thread.sleep(10000);
//        }catch (Exception E){
//
//        }
        for(int i = 0; i < 10; i++){
            System.out.println(name + "----");
        }
    }
}