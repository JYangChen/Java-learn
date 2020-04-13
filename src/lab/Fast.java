package lab;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-04-10 01:06
 **/

public class Fast {
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
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//快速输出

    public static void main(String[] args) {
        int cas = 1;
        while(cin.hasNext()){
            int n = cin.nextInt();
            int m = cin.nextInt();
            int q = cin.nextInt();
            String ch = cin.next();
            char[] str = ch.toCharArray();
            int len = ch.length();
            out.printf("Case #%d:\n",cas++);
            for(int i=0;i<q;i++){
                int op = cin.nextInt();
                int pos = cin.nextInt();
                if(op==2){
                    out.print(str[pos-1]);
                }else{
                    pos--;
                    int cnt = pos;
                    int count = (pos+m)-1;
                    while(cnt<count){
                        char temp = str[cnt];
                        str[cnt] = str[count] ;
                        str[count] = temp;
                        cnt++;count--;
                    }
                }
//                for(int k=0;k<str.length;k++){
//                    System.out.print(str[k]);
//                }
//                System.out.println();
            }
            out.println();
            out.flush();
        }
    }
}
