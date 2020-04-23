package lc;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-04-21 13:33
 **/

public class Solution {

    //PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->o2-o1);
    //PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N;
    public void Insert(Integer num) {
        if(N%2==0){
            left.add(num);
            right.add(left.poll());
        }else{
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if(N%2==0)
            return (left.peek()+right.peek())/2.0;
        else
            return (double)right.peek();
    }
}
