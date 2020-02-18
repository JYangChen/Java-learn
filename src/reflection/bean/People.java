package reflection.bean;

/**
 * @program: Java-learn
 * @description: bean
 * @author: anthony1314
 * @create: 2020-02-18 16:39
 **/

public class People {
    public String getName() {
        return name;
    }

    private String name;
    private int age;
//    public People(){
//
//    }
    private People(){

    }
    private People(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "People对象";
    }
}
