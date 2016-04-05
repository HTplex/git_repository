package poj;

import java.util.Scanner;

public class P1007 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    input.nextInt();
    int N = input.nextInt();
    DNA[] m = new DNA[N];
    for (int i = 0; i < N; i++) {
      m[i] = new DNA(input.next());
    }
    java.util.Arrays.sort(m);
    for (int i = 0; i < N; i++) {
      System.out.println(m[i].info);
    }
    input.close();
  }
}

class DNA implements Comparable<DNA> {
  String info;
  int num;

  DNA(String s) {
    this.info = s;
    this.num = this.n(this.info);
  }

  public int n(String s) {
    int a = 0;
    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; i++)
      for (int i2 = i + 1; i2 < c.length; i2++)
        if (c[i] > c[i2])
          a++;
    return a;
  }

  public int compareTo(DNA that) {
    return this.num - that.num;
  }
}