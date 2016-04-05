package codeforces;

import java.util.Scanner;

public class C520A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String s = in.next();
    s = change(s);
    boolean b = true;
    if (n < 26)
      System.out.println("NO");
    else {
      for (Character c = 'a'; c <= 'z'; c++) {
        String ss = c.toString();
        if (!s.contains(ss)) b = false;
      }
      System.out.print(b ? "YES" : "NO");
    }
  }

  public static String change(String s) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      c = c.toLowerCase(c);
      sb.append(c);
    }
    return sb.toString();
  }
}
