package poj;

import java.math.BigDecimal;
import java.util.Scanner;

public class P1001 {
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    String s = "";
    while (in.hasNext()) {
      BigDecimal a = new BigDecimal(in.next());
      int b = in.nextInt();
      BigDecimal m = a.pow(b);
      s = m.toPlainString();
      if (!s.contains(".")) {
        System.out.println(s);
      } else {
        while (s.charAt(0) == '0') {
          s = s.substring(1);
        }
        int l = s.length() - 1;
        while (s.charAt(l) == '0') {
          s = s.substring(0, s.length() - 1);
          l--;
        }
        if (s.charAt(l) == '.') {
          s = s.substring(0, s.length() - 1);
          l--;
        }
        System.out.println(s);
      }
    }
    //System.out.println(s);
    in.close();
  }
}