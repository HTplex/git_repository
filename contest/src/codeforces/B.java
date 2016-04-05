package codeforces;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char[] c = in.next().toCharArray();
//		swap(1,c);
//		System.out.println(c);

    int n = in.nextInt();
    int[] stor = new int[n];
    int[] stor2 = new int[c.length + 1];
    for (int i = 0; i < n; i++) {
      stor[i] = in.nextInt();
    }
    java.util.Arrays.sort(stor);
    int add = 0;
    int count = 0;
    for (int i = 0; i < c.length; i++) {
      while (count < stor.length && stor[count] == i) {
        add++;
        count++;
      }
      stor2[i] += add;
    }
    for (int i = 0; i <= c.length / 2; i++) {
      if (stor2[i] % 2 != 0)
        swap(i, c);
    }
    System.out.println(c);
  }

  public static void swap(int m, char[] c) {
    char t = c[m - 1];
    c[m - 1] = c[c.length - m];
    c[c.length - m] = t;
  }

  public static void pro(int n, boolean[] b) {

  }
}