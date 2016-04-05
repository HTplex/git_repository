package templets;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFeb {
  BigInteger[][] Matrix;
  BigInteger[][] One;
  int n;
  public BigFeb(int n, BigInteger[][] Matrix) {
    this.n = n;
    this.Matrix = new BigInteger[n][n];
    this.One = new BigInteger[n][n];
    this.Matrix = Matrix.clone();
    this.One = Matrix.clone();
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = 2;
    int mul = in.nextInt();
    BigInteger[][] Matrix = new BigInteger[2][2];
    Matrix[0][0] = BigInteger.ONE;
    Matrix[0][1] = BigInteger.ONE;
    Matrix[1][0] = BigInteger.ONE;
    Matrix[1][1] = BigInteger.ZERO;


    for (int i = 1; i < mul; i++) {
      BigFeb c = new BigFeb(n, Matrix);
      c.FMM(i);
      System.out.println(c.Matrix[0][1].toString());
    }
//    for (BigInteger[] l : c.Matrix) {
//      for (BigInteger m : l) {
//        System.out.print(m+"\t");
//      }
//      System.out.println();
//    }
  }

  public BigInteger[][] Multiply(BigInteger[][] a, BigInteger[][] b) {
    int n = a.length;
    BigInteger[][] c = new BigInteger[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        c[i][j] = BigInteger.ZERO;
      }
    }
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        for (int k = 0; k < n; k++)
          c[i][j] = c[i][j].add(a[i][k].multiply(b[k][j]));
    return c;
  }

  public void FMM(int n) {
    String Bin = Integer.toBinaryString(n);
    // System.out.println(Bin);
    for (int i = 1; i < Bin.length(); i++) {
      this.Matrix = Multiply(this.Matrix, this.Matrix);
      if (Bin.charAt(i) == '1') {
        this.Matrix = Multiply(this.Matrix, this.One);
      }
    }
  }
  //test collision
}
