package pratice;

import java.util.Scanner;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-04-01 16:48
 **/

public class stringPratice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine();
        StringBuffer ans = new StringBuffer("");
        for(int i = 0; i < ss.length(); i++){
            ans.append(ss.charAt(i));

        }
        System.out.println(ans);
        ans.delete(0,ans.length());
        ans.append('q');
        System.out.println(ans);
    }
}
