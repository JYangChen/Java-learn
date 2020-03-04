package JUC;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-04 17:41
 **/

public class ExchangerDemo {
    private static Exchanger<String> exchanger = new Exchanger();
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute( () -> {
            try {
                String girl = exchanger.exchange("我其实暗恋你很久了...");
                System.out.println("女生说：" + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute( () -> {
            try {
                System.out.println("女生慢慢的从教室里走出来...");
                TimeUnit.SECONDS.sleep(3);
                String boy = exchanger.exchange("我很喜欢你...");
                System.out.println("男生说：" + boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
