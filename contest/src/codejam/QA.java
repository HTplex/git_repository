package codejam;

import java.util.Scanner;

public class QA {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {
      int length = in.nextInt();
      String s = in.next();
      int sum = 0;
      int addition = 0;
      for (int i1 = 0; i1 <= length; i1++) {
        int numH = s.charAt(i1) - '0';
        if (sum < i1) {
          addition += (i1 - sum);
          sum += (i1 - sum);
        }
        sum += numH;


      }
      System.out.println("Case #" + (i + 1) + ": " + addition);
    }
  }
}
