package 集合;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-06 00:55
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverTest {
    public static void main(String[] args) {
        // list集合转换成数组
        ArrayList<String> list =  new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("yangwenqiang");
        Object[] arr = list.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("---------------");
        // 数组转换为list集合
        String[] arr2 = {"niuke", "alibaba"};
        List<String> asList = Arrays.asList(arr2);
        asList.add("qaqaqa");
        for (int i = 0; i < asList.size(); i++) {
            System.out.println(asList.get(i));
        }

    }
}