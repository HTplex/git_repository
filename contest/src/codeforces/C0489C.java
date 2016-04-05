package codeforces;

import java.util.Scanner;

public class C0489C {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int leng = in.nextInt();
    int num = in.nextInt();
    int leng2 = leng;
    int num2 = num;
    boolean b = true;
    boolean b2 = true;
    StringBuilder sb = new StringBuilder("");
    StringBuilder ssb = new StringBuilder("");

    if (leng == 1 && num == 0) System.out.print(0);
    else if (num > leng * 9 || num == 0) {
      System.out.print(-1);
    } else {
      b2 = true;
      if (num2 < 9 * (leng2 - 1)) {
        ssb.append(1);
        leng2--;
        num2--;
      }
      while (leng2 > 0) {
        while (num2 < 9 * (leng2 - 1)) {
          ssb.append(0);
          leng2--;
        }
        if (b2) {
          ssb.append(num2 - 9 * (leng2 - 1));
          b2 = false;
          leng2--;
        }
        if (leng2 > 0) {
          ssb.append(9);
          leng2--;
        }
      }
    }
    System.out.print(ssb.toString() + " ");

    if (leng == 1 && num == 0)
      System.out.println(0);
    else if (num > leng * 9 || num == 0) {
      System.out.println(-1);
    } else {
      while (leng > 0) {
        while (num > 9) {
          sb.append(9);
          num -= 9;
          leng -= 1;
        }

        if (b) {
          sb.append(num);
          leng -= 1;
          b = false;
        }
        if (leng >= 1) {
          sb.append(0);
          leng -= 1;
        }
      }
    }
    System.out.println(sb.toString());
    in.close();
  }
}
