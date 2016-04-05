package microsoft;

import java.util.Scanner;

public class Beauty2C {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {
      long sum = 0;
      int n = in.nextInt();
      int m = in.nextInt();
      int q = in.nextInt();
      boolean[] gender = new boolean[n + 1];
      int[][] nums = new int[n + 1][n + 1];

      for (int i1 = 0; i1 < n; i1++) {
        gender[i] = (in.nextInt() == 1);
      }
      for (int i1 = 0; i1 < m; i1++) {
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        nums[x][y] = z;
        nums[y][x] = z;
      }
      for (int i1 = 0; i1 < q; i1++) {
        int t = in.nextInt();
        if (t == 1) {
          int b = in.nextInt();
          gender[b] = (!gender[b]);
        }
        if (t == 2) {
          int x = in.nextInt();
          int y = in.nextInt();
          int z = in.nextInt();
          nums[x][y] = z;
        }
        if (t == 3) {
          sum = 0;
          for (int iw = 0; iw < n + 1; iw++) {
            for (int iw2 = 0; iw2 < n + 1; iw2++) {

              if (gender[iw] != gender[iw2]) {
                sum += nums[iw][iw2];
              }
            }
          }
          System.out.println(sum);
        }
      }
    }
  }
}
