package microsoft;

import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {
      int n = in.nextInt();
      int[][] points = new int[n][2];
      for (int i = 0; i < n; i++) {
        points[i][0] = in.nextInt();
        points[i][1] = in.nextInt();
      }
      int dist[] = new int[n];
      for (int i = 1; i < n; i++)
        dist[i] = Integer.MAX_VALUE;
      for (int i = 0; i < n - 1; i++) {
        for (int i1 = i + 1; i1 < n; i1++) {
          dist[i1] = min(dist[i] + dis(i1, i, points), dist[i1]);
        }
      }
      System.out.println(dist[n - 1]);
    }

  }

  public static int dis(int a, int b, int[][] dis) {
    return min(Math.abs(dis[a][0] - dis[b][0]), Math.abs(dis[a][1] - dis[b][1]));
  }

  public static int min(int a, int b) {
    return a < b ? a : b;
  }
}

