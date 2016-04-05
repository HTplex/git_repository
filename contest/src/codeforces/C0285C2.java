package codeforces;

import java.util.Scanner;

public class C0285C2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double x1 = in.nextDouble();
    double y1 = in.nextDouble();
    double x2 = in.nextDouble();
    double y2 = in.nextDouble();
    int n = in.nextInt();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      double a = in.nextDouble();
      double b = in.nextDouble();
      double c = in.nextDouble();
      if ((a * x1 + b * y1 + c) * (a * x2 + b * y2 + c) < 0)
        sum++;
    }
    System.out.print(sum);
    in.close();
  }
}
