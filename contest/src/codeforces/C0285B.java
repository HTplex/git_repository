package codeforces;

import java.util.Scanner;

public class C0285B {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int lect = in.nextInt();
    int dic = in.nextInt();
    dic[] dicc = new dic[dic];
    for (int i = 0; i < dic; i++) {
      String s1 = in.next();
      String s2 = in.next();
      dicc[i] = new dic(s1, s2);
    }
    java.util.Arrays.sort(dicc);
    for (int i = 0; i < lect; i++) {
      String s = in.next();
      System.out.print(go(s, dicc, 0, dicc.length) + " ");
    }
    in.close();
  }

  public static String go(String s, dic[] d, int a, int b) {
    int m = (a + b) / 2;
    if (a == b) return d[m].which ? d[m].info1 : d[m].info2;
    if (s.compareTo(d[m].info1) > 0) return go(s, d, m + 1, b);
    else return go(s, d, a, m);
  }
}

class dic implements Comparable<dic> {
  String info1;
  String info2;
  boolean which;

  public dic(String s1, String s2) {
    this.info1 = s1;
    this.info2 = s2;
    this.which = this.info1.length() <= this.info2.length();
  }

  public int compareTo(dic that) {
    return this.info1.compareTo(that.info1);
  }
}