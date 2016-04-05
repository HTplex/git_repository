package euler;

import java.util.Scanner;

public class E011gridnope {
  public static void main(String[] args) {
    int max = 0;
    Scanner in = new Scanner(System.in);
    int[][] g = new int[20][20];
    for (int i = 0; i < 20; i++)
      for (int i1 = 0; i1 < 20; i1++)
        g[i][i1] = in.nextInt();
    for (int i = 0; i < 16; i++) {
      for (int i1 = 0; i1 < 16; i1++) {
        //max=max(g[i][i1]*)
      }
    }
  }

  public static int max(int a, int b) {
    return a > b ? a : b;
  }
}
