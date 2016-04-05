package codeforces;

import java.util.Scanner;

public class C0283B {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.nextInt();
    String s = in.next();
    String min = go(s);
    for (int i = 0; i <= s.length(); i++) {
      s = go(swap(s));
      if (min.compareTo(s) > 0)
        min = s;
    }
    System.out.println(min);
    in.close();
  }

  public static String go(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {

      char d = (char) ('9' - s.charAt(0) + 1);
      char e = (char) (s.charAt(i) + d);
      if (e > '0') e -= 10;
      if (e < '0') e += 10;
      sb.append(e);
    }
    return sb.toString();
  }

  public static String swap(String s) {
    StringBuilder sb = new StringBuilder();
    sb.append(s.charAt(s.length() - 1));
    //for(int i=0;i<s.length()-1;i++){
    sb.append(s.substring(0, s.length() - 1));
    return sb.toString();
  }
}