package codeforces;

import java.util.Scanner;

public class C0300A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String codeforces = "CODEFORCES";
    String sample = in.next();
    int start = 0;
    int end = codeforces.length() - 1;
    boolean bs = false;
    boolean be = false;
    for (int i = 0; i < 105 && start <= end; i++) {
      if (codeforces.charAt(start) == sample.charAt(start)) {
        start++;
        bs = true;
      }
      if (codeforces.charAt(end) == sample.charAt(sample.length() - codeforces.length() + end)) {
        end--;
        be = true;
      }


    }
    //if(!bs) start;
    //if(be) end--;


    String s1 = sample.substring(0, start);
    String s2 = sample.substring(sample.length() - codeforces.length() + end + 1, sample.length());
    StringBuilder sb = new StringBuilder("");
    sb.append(s1);
    sb.append(s2);
    String s3 = sb.toString();
    boolean b = s1.equals(codeforces) || s2.equals(codeforces) || s3.equals(codeforces);
    System.out.println(s1 + " " + s2 + " " + s3);
    System.out.println(b ? "YES" : "NO");

  }
}
