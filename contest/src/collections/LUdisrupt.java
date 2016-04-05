package collections;

import java.util.Scanner;

/**
 * this is a program for developing a algorithm(not very efficient one) in order to calculate the LU
 * for a matrix
 *
 * @author htplex
 */
public class LUdisrupt {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int ax = in.nextInt();
    int ay = in.nextInt();
    int lx = in.nextInt();
    int ly = in.nextInt();
    int ux = in.nextInt();
    int uy = in.nextInt();
    double[][] a = new double[ay][ax];
    double[][] l = new double[ly][lx];
    double[][] u = new double[uy][ux];
    for (int i = 0; i < ay; i++) {
      for (int i2 = 0; i2 < ax; i2++) {
        a[i][i2] = in.nextDouble();
      }
    }

    // calculation start
    u[0] = a[0].clone();
    for (int i = 0; i < ay; i++) {
      l[i][0] = a[i][0] / u[0][0];
    }

    for (int r = 1; r < ay; r++) {
      for (int i = r; i < ax; i++) {
        u[r][i] = a[r][i];
        for (int k = 0; k < r; k++) {
          u[r][i] -= (l[r][k] * u[k][i]);
        }
      }
    }
    for (double[] ds : u) {
      for (double d : ds) {
        System.out.print(d + "\t");
      }
      System.out.println();
    }

  }
}
