package poj;

import java.util.Scanner;

public class P1003 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double a = in.nextDouble();
    int i;
    while (a != 0.00) {
      double sum = 0;
      for (i = 1; sum < a; i++)
        sum += 1.0 / (i + 1);
      System.out.println(i - 1 + " card(s)");
      a = in.nextDouble();
    }
    in.close();
  }
}
