package codeforces;

import java.util.Scanner;

public class C0283C {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int length = in.nextInt();
    String s[] = new String[n];
    for (int i = 0; i < n; i++) {
      s[i] = in.next();
    }
    int pos = 0;
    int num = 0;
    while (pos < length) {
      while (num < n - 1) {
        if (s[num + 1].charAt(pos) < s[num].charAt(pos)) {
          pos++;
          num = 0;
        } else if (s[num + 1].charAt(pos) > s[num].charAt(pos)) {

        }
      }
    }
//		String[] a={"1","2","3","4","5"};
//		a=delete(a,3);
//		for(String i:a) System.out.println(i);


    in.close();
  }

  public static String[] delete(String[] a, int m) {
    String[] b = new String[a.length - 1];
    for (int i = 0; i < m - 1; i++) {
      b[i] = a[i];
    }
    if (m > 0)
      for (int i = m; i < a.length; i++) {
        b[i - 1] = a[i];
      }
    return b;
  }

}