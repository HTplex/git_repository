package microsoft;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      int x, y, z;
      x = in.nextInt();
      y = in.nextInt();
      z = in.nextInt();
      int maxc = max(x, y, z);
      int minc = min(x, y, z);
      boolean b = false;
      if (z != x + y && x != y + z && y != z + x)
        b = true;
      //System.out.print(b);
      int cx = 0;
      int cy = 0;
      int cz = 0;
      int max = 0;
      String s = in.next();
      if (b)
        System.out.print(s.length());
      else {
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == 'R') cx++;
          if (s.charAt(i) == 'Y') cy++;
          if (s.charAt(i) == 'B') cz++;
          max = max(max, cx + cy + cz);
          if (max(cx, cy, cz) - min(cx, cy, cz) == maxc && (mid(cx, cy, cz) - min(cx, cy, cz) == minc || max(cx, cy, cz) - mid(cx, cy, cz) == minc)) {
            //max=max(max,cx+cy+cz);
            cx = 0;
            cy = 0;
            cz = 0;
          }
        }
        System.out.println(max);
      }
    }

  }

  // public static boolean is()
  public static int max(int a, int b) {
    return a > b ? a : b;
  }

  public static int min(int a, int b) {
    return a < b ? a : b;
  }

  public static int max(int a, int b, int c) {
    return max(a, max(b, c));
  }

  public static int min(int a, int b, int c) {
    return min(a, min(b, c));
  }

  public static int mid(int a, int b, int c) {
    return a + b + c - max(a, b, c) - min(a, b, c);
  }
}
