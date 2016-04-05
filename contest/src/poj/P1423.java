package poj;

import java.util.Scanner;

public class P1423 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double sum = 0;
    int[] ans = new int[10000001];
    for (int i = 1; i < ans.length; i++) {
      sum += Math.log10(i);
      ans[i] = ((int) (sum + 1));
    }
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();

    for (int i = 0; i < n; i++) {
      System.out.println(ans[a[i]]);
    }
    in.close();
  }
}
