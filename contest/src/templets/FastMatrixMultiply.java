package templets;

import java.util.Scanner;

public class FastMatrixMultiply {
  long[][] Matrix;
  long[][] One;
  int n;
  public FastMatrixMultiply(int n, long[][] Matrix) {
    this.n = n;
    this.Matrix = new long[n][n];
    this.One = new long[n][n];
    this.Matrix = Matrix.clone();
    this.One = Matrix.clone();
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = 2;
    int mul = in.nextInt();
    long[][] Matrix = {{1L, 1L}, {1L, 0L}};

//    for(int i=0;i<n;i++){
//      for(int j=0;j<n;j++){
//        Matrix[i][j]=in.nextLong();
//      }
//    }


    FastMatrixMultiply c = new FastMatrixMultiply(n, Matrix);
    c.FMM(mul);
    long[][] mm = c.Multiply(Matrix, Matrix);
    for (long[] l : c.Matrix) {
      for (long m : l) {
        System.out.print(m + "\t");
      }
      System.out.println();
    }
  }

  public long[][] Multiply(long[][] a, long[][] b) {
    int n = a.length;
    long[][] c = new long[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        for (int k = 0; k < n; k++)
          c[i][j] += a[i][k] * b[k][j];
    return c;
  }

  public void FMM(int n) {
    String Bin = Integer.toBinaryString(n);
    System.out.println(Bin);
    for (int i = 1; i < Bin.length(); i++) {
      this.Matrix = Multiply(this.Matrix, this.Matrix);
      if (Bin.charAt(i) == '1') {
        this.Matrix = Multiply(this.Matrix, this.One);
      }
    }
  }

}
