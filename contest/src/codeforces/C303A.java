package codeforces;

import java.util.Scanner;

public class C303A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] cars = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        cars[i][j] = in.nextInt();
      }
    }
    int[] carss = new int[n];
    int c = 0;
    for (int i = 0; i < n; i++) {
      if (isc(cars[i])) {
        carss[c++] = i + 1;
      }
    }
    System.out.println(c);
    for (int i = 0; i < c; i++) {
      System.out.print(carss[i] + " ");
    }
  }

  public static boolean isc(int[] a) {
    boolean b = true;
    for (int i : a) {
      if (i == 1 || i == 3)
        b = false;
    }
    return b;
  }
}
