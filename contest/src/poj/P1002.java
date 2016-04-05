package poj;

import java.util.Scanner;

public class P1002 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    Call[] a = new Call[N];
    for (int i = 0; i < N; i++) {
      a[i] = new Call(in.next());
    }
    java.util.Arrays.sort(a);
    int m = 0;
    boolean b = true;
    for (int i = 1; i < N; i++) {

      if (a[i].compareTo(a[m]) == 0) {
        a[m].dup++;
        b = false;
      } else {
        m = i;
      }

    }
    for (int i = 0; i < N; i++) {
      if (a[i].dup > 1) {
        System.out.println(a[i].num + " " + a[i].dup);
      }
    }
    if (b) System.out.println("No duplicates. ");
    in.close();
  }
}

class Call implements Comparable<Call> {
  String num;
  int dup;

  Call(String s) {
    process(s);
    dup = 1;
  }

  public static int cToN(Character c) {
    int out;
    int i = (int) (c);
    if (i < 82) {
      out = (int) ((i - 65) / 3) + 2;

    } else {
      out = (int) ((i - 66) / 3) + 2;
    }
    return out;
  }

  public void process(String s) {
    StringBuilder sb = new StringBuilder("");

    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (sb.length() == 3)
        sb.append('-');
      if (Character.isUpperCase(c)) {
        sb.append(cToN(c));
      }
      if (Character.isDigit(c)) {
        sb.append(c);
      }
    }
    num = sb.toString();
  }

  public int compareTo(Call that) {
    return this.num.compareTo(that.num);
  }
}