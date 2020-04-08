package wejudge;

import java.util.Scanner;

/**
 * @program: Java-learn
 * @description: wejudge1024
 * @author: anthony1314
 * @create: 2020-04-08 13:21
 **/

public class Main {
    public static void main(String[] args) {
        int n, minn, minnindex, i, temp,x;
        int[] ss = new int[105];
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n = sc.nextInt();
            minn = 0x3f3f3f3f;
            minnindex = 0;
            if(n == 0) break;
            for(i = 0; i < n; i++){
                x = sc.nextInt();
                if(x < minn){
                    minn = x;
                    minnindex = i;
                }
                ss[i] = x;
            }
            temp = ss[0];
            ss[0] = minn;
            ss[minnindex] = temp;
            for(i = 0; i < n; i++){
                if(i == n-1)
                    System.out.print(ss[i]);
                else
                    System.out.print(ss[i]+" ");
            }
            System.out.println();
        }
    }
}
