package codeforces;

import java.util.Scanner;

public class C0285A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int sum = 0;
    int s = 1;
    for (int i = 0; i < n; i++) {
      int m1 = in.nextInt();
      int m2 = in.nextInt();
      sum += (m1 - s) >= m ? (m1 - s) % m : m1 - s;
      sum += (m2 - m1 + 1);
      s = m2 + 1;
    }
    System.out.println(sum);
    in.close();
  }
}
