package factory;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-04-08 17:59
 **/

public class Single {
    public static volatile Single s = null;
    private Single(){}
    public Single getSingle(){
        if(s == null){
            synchronized (Single.class){
                if(s == null){
                    s = new Single();
                }
            }
        }
        return s;
    }
}
