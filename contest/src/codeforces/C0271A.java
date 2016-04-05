package codeforces;

import java.util.Scanner;

public class C0271A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    StringBuilder sb = new StringBuilder("");
    String a = "qwertyuiop";
    String b = "asdfghjkl;";
    String c = "zxcvbnm,./";
    String s = in.next();
    boolean isr = (s.charAt(0) == 'R');
    String inp = in.next();
    if (isr) {
      for (int i = 0; i < inp.length(); i++) {
        String cc = inp.substring(i, i + 1);
        //char ch=s.charAt(i);
        if (a.substring(1).contains(cc)) sb.append(a.charAt(a.indexOf(cc) - 1));
        if (b.substring(1).contains(cc)) sb.append(b.charAt(b.indexOf(cc) - 1));
        if (c.substring(1).contains(cc)) sb.append(c.charAt(c.indexOf(cc) - 1));
      }
      System.out.println(sb.toString());
    } else {
      for (int i = 0; i < inp.length(); i++) {
        String cc = inp.substring(i, i + 1);
        //char ch=s.charAt(i);
        if (a.substring(0, a.length() - 1).contains(cc)) sb.append(a.charAt(a.indexOf(cc) + 1));
        if (b.substring(0, a.length() - 1).contains(cc)) sb.append(b.charAt(b.indexOf(cc) + 1));
        if (c.substring(0, a.length() - 1).contains(cc)) sb.append(c.charAt(c.indexOf(cc) + 1));
      }
      System.out.println(sb.toString());

    }
    in.close();
  }
}
