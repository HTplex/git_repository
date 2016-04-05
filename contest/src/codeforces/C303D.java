package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class C303D {
  public static void main(String[] args) {
    Scanner inScanner = new Scanner(System.in);
    int n = inScanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = inScanner.nextInt();
    }
    Arrays.sort(a);
    long sum = 0;
    int count = 0;

    for (int i = 0; i < n; i++) {
      if (sum <= a[i]) {
        count++;
        sum += a[i];
      }
    }
    System.out.println(count);
  }
}
