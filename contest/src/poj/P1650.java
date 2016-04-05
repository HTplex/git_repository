package poj;

import java.math.BigDecimal;
import java.util.Scanner;

public class P1650 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double d = in.nextDouble();
    int limit = in.nextInt();
    double up;
    double down;
    double storgemin = Double.MAX_VALUE;

    int storgefinal = Integer.MAX_VALUE;
    int storgefinalup = Integer.MAX_VALUE;
    if (d > 1) {
      if (d > limit) {
        System.out.println(limit + " " + 1);
      } else {
        for (up = limit; (int) (up / d) > 0; up--) {
          double m = min(delta(up, (int) (up / d), d), delta(up, (int) (up / d + 1), d));
          double n = minn(up, (int) (up / d), (int) (up / d + 1), d);
          if (storgemin > m) {
            storgemin = m;
            storgefinal = (int) n;
            storgefinalup = (int) up;
          }
        }
        int G = GCD(storgefinalup, storgefinal);
        System.out.println(storgefinalup / G + " " + storgefinal / G);
      }
    } else {
      if (1 / d > limit) {
        System.out.println(1 + " " + limit);
      } else {
        for (down = limit; (int) (down * d) > 0; down--) {

          double m = min(delta((int) (down * d), down, d), delta((int) (down * d) + 1, down, d));
          double n = minnn((int) (down * d), (int) (down * d) + 1, down, d);
          if (storgemin > m) {
            storgemin = m;
            storgefinal = (int) n;
            storgefinalup = (int) down;
          }
        }
        int G = GCD(storgefinalup, storgefinal);
        System.out.println(storgefinal / G + " " + storgefinalup / G);
      }
    }
    in.close();
  }

  public static BigDecimal deltaa(double a, double b, double c) {
    BigDecimal A = new BigDecimal(a);
    BigDecimal B = new BigDecimal(b);
    BigDecimal C = new BigDecimal(c);
    BigDecimal r = (A.divide(B, 20, BigDecimal.ROUND_HALF_UP)).add(C.negate());
    return r.abs();
  }

  public static double delta(double a, double b, double c) {
    return Math.abs(a / b - c);
  }

  public static double min(double a, double b) {
    return a < b ? a : b;
  }

  public static double minn(double a, double b, double c, double d) {
    return delta(a, b, d) > delta(a, c, d) ? c : b;
  }

  public static double minnn(double a, double b, double c, double d) {
    return delta(a, c, d) > delta(b, c, d) ? b : a;
  }

  public static int GCD(int a, int b) {
    if (a % b == 0) return b;
    else return (GCD(b, a % b));
  }
}
