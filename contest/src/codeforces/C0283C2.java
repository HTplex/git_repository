package codeforces;

import java.util.Scanner;

public class C0283C2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextInt();
    String[] s = new String[n];
    for (int i = 0; i < n; i++)
      s[i] = in.next();
    //System.out.println(t(s));

    in.close();
  }

  public static boolean t(String[] s) {
    for (int i = 0; i < s.length - 1; i++) {
      if (s[i + 1].compareTo(s[i]) < 0)
        return false;
    }
    return true;
  }

}