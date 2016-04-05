package poj;

import java.util.Scanner;

public class P1004 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Double n = 0.0;
    for (int i = 0; i < 12; i++)
      n += in.nextDouble();
    n /= 12.0;
    //System.out.println(n);
    int p = (int) (1000 * n);
    if (p % 10 >= 5) {
      p /= 10;
      p++;
    } else {
      p /= 10;
    }
    n = p / 100.0;
    System.out.print("$");
    System.out.println(n);
    in.close();
  }
}
