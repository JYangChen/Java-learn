package lab;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: Java-learn
 * @description:
 * @author: anthony1314
 * @create: 2020-04-10 01:48
 **/

public class Matrix {
    public BigInteger mat[][];

    public int rows;

    public int cols;

    public static BigInteger MOD = new BigInteger("100000000");

    public static BigInteger zero = new BigInteger("0");

    public static BigInteger one = new BigInteger("1");

    public static BigInteger TWENTY_FOUR = new BigInteger("24");

    public Matrix(){

    }

    public Matrix(int rows,int cols){
        this.rows = rows;
        this.cols = cols;

        mat = new BigInteger[rows][cols];

    }

    public Matrix(Matrix m){
        this.rows = m.rows;
        this.cols = m.cols;
        mat = new BigInteger[rows][cols];
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                mat[i][j] = m.mat[i][j];
            }
        }
    }

    public Matrix(BigInteger[][] bigIntegers){
        this.cols = bigIntegers.length;
        this.rows = bigIntegers[0].length;
        mat = new BigInteger[rows][cols];
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                mat[i][j] = bigIntegers[i][j];
            }
        }
    }

    public static Matrix multiply(Matrix m1,Matrix m2){
        Matrix ans = new Matrix(m1.rows,m2.cols);

        for(int i=0;i<ans.rows;i++){
            for(int j=0;j<ans.cols;j++){
                BigInteger sum = new BigInteger("0");
                for(int x=0;x<m1.cols;x++){
                    BigInteger temp = m1.mat[i][x].multiply(m2.mat[x][j]);
                    sum = sum.add(sum);
                    sum = sum.mod(MOD);
                }
                ans.mat[i][j]  = new BigInteger("0");
                ans.mat[i][j].add(sum);
            }
        }

        return ans;
    }

    public static Matrix poww(Matrix m1,BigInteger k){
        Matrix m = Matrix.eye(m1.rows);
        System.out.println(m1.rows+" "+m1.cols);
        Matrix temp = new Matrix(m1);
        while(k.compareTo(zero)==1){
            if(k.and(one).compareTo(zero)==1){
                m = Matrix.multiply(m,temp);
            }
            temp = Matrix.multiply(temp,temp);
            k = k.shiftRight(1);
        }
        return m;
    }

    public static Matrix eye(int k){
        Matrix m = new Matrix(k,k);

        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                m.mat[i][j] = new BigInteger("0");
            }
        }
        for(int i=0;i<k;i++){
            m.mat[i][i] = one;
        }
        return m;
    }

    public void print(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    //    public static Matrix power(Matrix m1,int k){
//
//    }
    public static void main(String[] args) {
        //BigInteger s =
        Matrix m1 = new Matrix(6,6);
        Matrix m2 = new Matrix(6,1);
        BigInteger one = new BigInteger("1");
        m1.mat[0][0] = new BigInteger("0");
        m1.mat[0][1] = new BigInteger("1");
        m1.mat[0][2] = new BigInteger("0");
        m1.mat[0][3] = new BigInteger("0");
        m1.mat[0][4] = new BigInteger("0");
        m1.mat[0][5] = new BigInteger("0");

        m1.mat[1][0] = new BigInteger("2");
        m1.mat[1][1] = new BigInteger("1");
        m1.mat[1][2] = new BigInteger("1");
        m1.mat[1][3] = new BigInteger("0");
        m1.mat[1][4] = new BigInteger("2");
        m1.mat[1][5] = new BigInteger("1");

        m1.mat[2][0] = new BigInteger("0");
        m1.mat[2][1] = new BigInteger("0");
        m1.mat[2][2] = new BigInteger("1");
        m1.mat[2][3] = new BigInteger("3");
        m1.mat[2][4] = new BigInteger("3");
        m1.mat[2][5] = new BigInteger("1");

        m1.mat[3][0] = new BigInteger("0");
        m1.mat[3][1] = new BigInteger("0");
        m1.mat[3][2] = new BigInteger("0");
        m1.mat[3][3] = new BigInteger("1");
        m1.mat[3][4] = new BigInteger("2");
        m1.mat[3][5] = new BigInteger("1");

        m1.mat[4][0] = new BigInteger("0");
        m1.mat[4][1] = new BigInteger("0");
        m1.mat[4][2] = new BigInteger("0");
        m1.mat[4][3] = new BigInteger("0");
        m1.mat[4][4] = new BigInteger("1");
        m1.mat[4][5] = new BigInteger("1");

        m1.mat[5][0] = new BigInteger("0");
        m1.mat[5][1] = new BigInteger("0");
        m1.mat[5][2] = new BigInteger("0");
        m1.mat[5][3] = new BigInteger("0");
        m1.mat[5][4] = new BigInteger("0");
        m1.mat[5][5] = new BigInteger("1");

        m2.mat[0][0] = new BigInteger("0");
        m2.mat[1][0] = new BigInteger("1");
        m2.mat[2][0] = new BigInteger("27");
        m2.mat[3][0] = new BigInteger("9");
        m2.mat[4][0] = new BigInteger("3");
        m2.mat[5][0] = new BigInteger("1");

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        for(int i=0;i<m;i++){
            BigInteger n = scanner.nextBigInteger();
            if(n.equals(one)){
                System.out.println("0");
            }else{
                BigInteger s = n.add(one.negate());
                Matrix WW = Matrix.poww(m1,s);
                Matrix m3 = new Matrix(WW);
                Matrix m4 = new Matrix(Matrix.multiply(m3,m2));
                if(n.compareTo(TWENTY_FOUR)==1){
                    System.out.print(m4.mat[0][0]);
                }else{
                    int ans = m4.mat[0][0].intValue();
                    if(n.compareTo(TWENTY_FOUR)==1){
                        System.out.printf("%d\n",ans);
                    }else{
                        System.out.printf("08d\n",ans);
                    }
                }
            }
        }


    }
}
