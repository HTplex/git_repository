package euler;

import java.util.Scanner;

public class U01 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      int n = in.nextInt();
      int b = in.nextInt();
      String[] com = new String[n];
      for (int i = 0; i < n; i++) {
        com[i] = in.next();
      }
      String s = com[0];
      for (int i = 1; i < n; i++) {
        s = add(s, com[i], b);
      }
      while (s.charAt(0) == '0') {
        s = s.substring(1);

      }
      System.out.println(s);

    }

  }

  public static String add(String a, String b, int c) {
    StringBuilder sb = new StringBuilder();
    int m = a.length() - 1;
    int n = b.length() - 1;
    while (m >= 0 && n >= 0) {
      //System.out.println(add(a.charAt(m),b.charAt(n),c));
      sb.append(add(a.charAt(m), b.charAt(n), c));
      m--;
      n--;
    }
    if (m >= 0) {
      StringBuilder ss = new StringBuilder(a.substring(0, m + 1));
      sb.append(ss.reverse().toString());
    }

    //	m--;

    if (n >= 0) {
      StringBuilder ss = new StringBuilder(b.substring(0, n + 1));
      sb.append(ss.reverse().toString());
    }
    //	n--;
    //	}
    return sb.reverse().toString();
  }

  public static String add(char a, char b, int c) {
    //System.out.println(r2((r1(a)+r1(b))%c));
    StringBuilder sb = new StringBuilder();
    sb.append(r2((r1(a) + r1(b)) % c));
    return sb.toString();
  }

  public static int r1(char a) {
    if (a >= 'a') return a - 'a' + 10;
    else return a - '0';
  }

  public static char r2(int a) {
    if (a >= 10) return (char) ('a' + 10 - a);
    else return (char) ('0' + a);
  }

  public static int max(int a, int b) {
    return a > b ? a : b;
  }

  public static int min(int a, int b) {
    return a < b ? a : b;
  }
}
