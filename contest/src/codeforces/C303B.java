package codeforces;

import java.util.Scanner;

public class C303B {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s1 = in.next();
    String s2 = in.next();

    int c = diff(s1, s2);
    if (c % 2 != 0) {
      System.out.println("impossible");
    } else {
      StringBuilder sbBuilder = new StringBuilder("");
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) == s2.charAt(i) || c == 0) {
          sbBuilder.append(s1.charAt(i));
        } else {
          sbBuilder.append(s2.charAt(i));
          c -= 2;
        }
      }
      if (c == 0) System.out.println(sbBuilder.toString());
      else System.out.println("impossible");
    }
  }

  public static int count(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1')
        count++;
    }
    return count;
  }

  public static int diff(String s1, String s2) {
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i))
        count++;
    }
    return count;
  }
}
