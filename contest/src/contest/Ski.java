package contest;

import java.util.Scanner;

public class Ski {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = 20;
    int m = n * n;
    for (int i = 0; i < n; i += 2) {
      for (int i1 = 0; i1 < n; i1++) {
        System.out.print(m-- + " ");
      }
      m -= (n - 1);
      System.out.println();
      for (int i1 = 0; i1 < n; i1++) {
        System.out.print(m++ + " ");
      }
      m -= (n + 1);
      System.out.println();
    }
    in.close();
  }
}
