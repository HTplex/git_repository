package codeforces;

import java.util.Scanner;

public class C0283A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] m = new int[n];
    int[] p = new int[n - 2];
    int dif = 0;
    for (int i = 0; i < n; i++) {
      m[i] = in.nextInt();
    }
    for (int i = 0; i < n - 1; i++) {
      if (dif < m[i + 1] - m[i])
        dif = m[i + 1] - m[i];
    }
    for (int i = 0; i < n - 2; i++) {
      p[i] = m[i + 2] - m[i];
    }
    java.util.Arrays.sort(p);
    System.out.print(p[0] > dif ? p[0] : dif);
    in.close();
  }
}
