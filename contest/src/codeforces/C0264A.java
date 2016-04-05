package codeforces;

import java.util.Scanner;

public class C0264A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int money = in.nextInt() * 100;
    int prize;
    int candy = -1;
    for (int i = 0; i < n; i++) {
      int m = money;
      prize = in.nextInt() * 100 + in.nextInt();
      //System.out.print(prize);
      if (m - prize >= 0) {
        int e = 100 - (prize % 100);
        if (e == 100) e = 0;

        candy = more(candy, e);
      }
//			candy=more(candy,(m%prize)%100);
      //System.out.println(candy);
    }
    //int candy=money%prize[i];
    System.out.println(candy);
  }

  public static int more(int a, int b) {
    return a > b ? a : b;
  }
}
