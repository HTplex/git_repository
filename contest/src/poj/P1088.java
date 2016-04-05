package poj;

import java.util.Scanner;

public class P1088 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    int y = in.nextInt();
    int[][] a = new int[x][y];
    int[][] map = new int[x][y];

    for (int i = 0; i < a.length; i++) {
      for (int i2 = 0; i2 < a[0].length; i2++) {
        map[i][i2] = in.nextInt();
        a[i][i2] = Integer.MIN_VALUE;
      }
    }
    //System.out.println(tx+" "+ty);
    int max = -1;
    for (int i = 0; i < a.length; i++) {
      for (int i2 = 0; i2 < a[0].length; i2++) {
        max = max(max, path(map, a, i, i2));
        System.out.print(a[i][i2] + " ");
      }
      System.out.println();
    }
    System.out.print(max);
    in.close();
  }

  public static int path(int[][] map, int[][] a, int x1, int y1) {
    //int m=1;
//		if(x1==x2&&y1==y2) {
//			a[x1][y1]=1;
//			return 1;
//		}
    if (a[x1][y1] > 0) return a[x1][y1];
    int max = Integer.MIN_VALUE;
    boolean b = true;
    if (x1 > 0 && map[x1][y1] > map[x1 - 1][y1]) {
      int temp = path(map, a, x1 - 1, y1) + 1;
      max = max(temp, max);

      b = false;
    }
    if (x1 < (a.length - 1) && map[x1][y1] > map[x1 + 1][y1]) {
      int temp = path(map, a, x1 + 1, y1) + 1;
      max = max(temp, max);

      b = false;
    }

    if (y1 > 0 && map[x1][y1] > map[x1][y1 - 1]) {
      int temp = path(map, a, x1, y1 - 1) + 1;
      max = max(temp, max);

      b = false;
    }
    if (y1 < (a[0].length - 1) && map[x1][y1] > map[x1][y1 + 1]) {
      int temp = path(map, a, x1, y1 + 1) + 1;
      max = max(temp, max);

      b = false;
    }

    if (b) {
      a[x1][y1] = 1;
      return 1;
    } else {
      a[x1][y1] = max;
      return max;
    }
  }

  public static int max(int a, int b) {
    return a > b ? a : b;
  }
}
