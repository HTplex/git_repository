package poj;

import java.util.Scanner;

public class P1005 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      double x = in.nextDouble();
      double y = in.nextDouble();
      double sqr = Math.PI * (x * x + y * y) / 2;
      System.out.println("Property " + (i + 1) + ": This property will begin eroding in year " + ((int) (sqr / 50.0) + 1) + ".");
    }
    System.out.println("END OF OUTPUT.");
    in.close();
  }
}
