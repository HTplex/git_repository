package codeforces;

import java.util.Scanner;

public class C0071A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      String s = in.next();
      if (s.length() > 10) {
        System.out.print(s.charAt(0));
        System.out.print(s.length() - 2);
        System.out.println(s.charAt(s.length() - 1));
      } else
        System.out.println(s);
    }
    in.close();
  }
}
