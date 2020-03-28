package collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-03-06 00:53
 **/

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<String> list =  new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("yangwenqiang");
// 创建迭代器实现遍历集合
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
