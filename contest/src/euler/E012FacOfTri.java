package euler;

import java.util.Scanner;

public class E012FacOfTri {

  public static void main(String[] args) {
    Scanner inScanner = new Scanner(System.in);
    /**
     * find something new count(a*b)=count(a)*count(b)/count(LCD); count(a*b/2)=count(a)*count(b)/2
     */

    int m = 0;
    int n = 0;
    int a = 0;
    while (true) {
      if (a % 2 == 0) {
        m = countFast(a / 2);
        n = countFast(a + 1);
      } else {
        m = countFast(a);
        n = countFast((a + 1) / 2);
      }
      if (m * n >= 500)
        break;
      a++;
      // if (a % 100 == 0)
      // System.out.println(m + " " + n + " " + (a * (a + 1) / 2));
      // }
    }
    System.out.println(a + " " + m + " " + n + " " + (a * (a + 1)) / 2);

  }

  static int count(long l) { // O(l*2)
    int sum = 0;
    for (long i = 1; i <= l; i++)
      if (l % i == 0)
        sum++;
    return sum;
  }

  static int countFast(long l) { // O(l)
    int accu = 1;
    int div = 2;
    while (l > 1) {
      int c = 1;
      while (l % div == 0) {
        l /= div;
        c++;
        // System.out.println("inner");
      }

      div++;
      accu *= c;
    }
    return accu;
  }

}
