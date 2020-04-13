package lab;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-04-08 20:11
 **/

public class A {
    public int ss(){
        try{
            return 1;
        }catch (Exception e){

        }finally {
            return 2;
        }
    }
    public void print(){
        System.out.println("A1");
    }
    public void print(B b){
        System.out.println("A2");
    }
}
