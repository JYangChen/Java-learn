package Generics;

import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-29 02:44
 **/

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Person person = new Person();

        GenerateTest<Fruit> generateTest = new GenerateTest<Fruit>();
        //apple是Fruit的子类，所以这里可以
        generateTest.show_1(apple);
        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        //generateTest.show_1(person);

        //使用这两个方法都可以成功
        generateTest.show_2(apple);
        generateTest.show_2(person);

        //使用这两个方法也都可以成功
        generateTest.show_3(apple);
        generateTest.show_3(person);

        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
        showKeyValue1(gNumber);
// showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer>
// cannot be applied to Generic<java.lang.Number>
//showKeyValue(gInteger);
    }


    public static void showKeyValue1(Generic<Number> obj){
        System.out.println("泛型测试"+"key value is " + obj.getKey());
    }
}
