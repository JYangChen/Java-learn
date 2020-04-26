package test;

import java.util.HashMap;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-04-17 18:34
 **/

public class fx {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    public fx(String a, int b){
        name = a;
        b = age;
    }

    public static void main(String[] args) {
        HashMap<fx, String> mp = new HashMap<>();
        fx ff = new fx("qqqq", 5);
        fx f = new fx("qqqq", 5);
        mp.put(ff, "666");
        System.out.println(f.hashCode());
        System.out.println(ff.hashCode());
        String qaqaq = mp.get(ff);
       // System.out.println(qaqaq);
        ff.setAge(666);
        System.out.println(ff.hashCode());
        String qaq = mp.get(ff);
       // System.out.println(qaq);
    }
}
