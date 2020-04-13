package lab;

import java.io.*;
import java.util.StringTokenizer;
/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-04-11 19:55
 **/

public class Main {


    static class FastScanner{//用于快速读入大量数据
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in),16384);
            eat("");
        }
        public void eat(String s) {
            st = new StringTokenizer(s);
        }
        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }
        public boolean hasNext() {
            while(!st.hasMoreTokens()) {
                String s = nextLine();
                if(s==null) return false;
                eat(s);
            }
            return true;
        }
        public String next() {
            hasNext();
            return st.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
    static FastScanner cin = new FastScanner(System.in);//快读
    //static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//快速输出
    private static class Me {

        Me father;

        long value;

        long money;

        Me[] children = new Me[400001];

        int count;

        Me(int value, Me father) {
            this.value = value;
            this.father = father;
            while (father != null) {
                father.children[father.count] = this;
                father.count++;
                father = father.father;
            }
        }

        Me(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        int t = cin.nextInt();
        for (int i = 0; i < t; i++) {
            int n = cin.nextInt();
            Me[] a = new Me[n+1];
            a[1] = new Me(1);
            for (int j = 2; j < n+1; j++) {
                a[j] = new Me(j, a[cin.nextInt()]);
            }
            for (int j = n; j >= 1; j--) {
                long money = 0;
                Me temp = a[j];
                if (temp.count > 0) {
                    long l = temp.children[0].value + temp.value;
                    money += l * l;
                }
                for (int k = 1; k < temp.count; k++) {
                    long he = temp.children[k].value+temp.children[k-1].value;
                    money += he * he;
                }
                temp.money = money;
            }
            System.out.println("Case #" + (i+1) + ":");
            for (int j = 1; j < n+1; j++) {
                System.out.println(a[j].money);
            }
        }
    }
}