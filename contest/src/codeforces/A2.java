package codeforces;

import java.util.Scanner;

public class A2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] keys = new int[26];
    int count = 0;
    int n = in.nextInt();
    char[] c = in.next().toCharArray();
    for (int i = 0; i < c.length; i++) {
      if (i % 2 == 0) {
        keys[c[i] - 'a']++;
      } else {
        if (keys[c[i] - 'A'] > 0)
          keys[c[i] - 'A']--;
        else count++;
      }
    }
    System.out.print(count);
  }
}
