package codeforces;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    char[] b = in.next().toCharArray();
    boolean[] take = new boolean[b.length];
    boolean[] take2 = new boolean[b.length];
    char[] key = new char[b.length / 2];
    char[] door = new char[b.length / 2];
    for (int i = 0; i < b.length; i++) {
      if (i % 2 == 0)
        key[i / 2] = b[i];
      else
        door[i / 2] = b[i];
    }
    int count = n - 1;
    for (int i = 0; i < take2.length; i++)
      take2[i] = false;
    for (int i = 0; i < take.length; i++)
      take[i] = false;

    for (int i = 0; i < door.length; i++) {
      for (int i1 = 0; i1 <= i; i1++) {
        if (take[i] == false && take[i1] == false && (door[i] - key[i1] == 'A' - 'a')) {
          take[i1] = true;
          take[i] = true;
          count--;
          //break;
        }
      }
    }
    System.out.print(count);
//		for(char c:key) System.out.println(c);
//		for(char c:door) System.out.println(c);
  }
}
