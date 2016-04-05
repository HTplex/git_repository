package codeforces;

import java.util.Arrays;
import java.util.Scanner;


public class C303CWA {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    tree[] trees = new tree[n];
    for (int i = 0; i < n; i++) {
      int pos = in.nextInt();
      int h = in.nextInt();
      trees[i] = new tree(pos, h);
    }
    Arrays.sort(trees);
    int[][] dp = new int[n][3];
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[0][2] = 0;// (trees[1].pos-trees[0].pos-trees[0].h)>=0?1:0;
    int max = 0;
    for (int i = 1; i < n - 1; i++) {
      int m1 = (trees[i].pos - trees[i - 1].pos - trees[i].h) >= 0 ? 1 : 0;
      int m2 = (trees[i].pos - trees[i - 1].pos - trees[i].h) >= 0 ? 1 : 0;
      int m3 = (trees[i + 1].pos - trees[i].pos - trees[i].h - trees[i - 1].h) >= 0 ? 1 : 0;
      int m4 = ((trees[i].pos - trees[i - 1].pos - trees[i - 1].h) >= 0 && m3 == 1) ? 1 : 0;
      int a0 = dp[i - 1][0] + m1;
      int a1 = dp[i - 1][1] + m1;
      int a2 = dp[i - 1][2] + m2;
      dp[i][0] = max(a0, a1, a2);
      int b0 = dp[i - 1][0];
      int b1 = dp[i - 1][1];
      int b2 = dp[i - 1][2];
      dp[i][1] = max(b0, b1, b2);
      int c0 = dp[i - 1][0] + m3;
      int c1 = dp[i - 1][1] + m3;
      int c2 = dp[i - 1][2] + m4;
      dp[i][2] = max(c1, c2, c0);

    }
    max = max(dp[n - 2][1], dp[n - 2][2], dp[n - 2][0]) + 1;
    System.out.println(max);
  }

  static int max(int a, int b) {
    return a > b ? a : b;
  }

  static int max(int a, int b, int c) {
    return max(a, max(b, c));
  }
}


class tree implements Comparable<tree> {
  int pos;
  int h;

  tree(int pos, int h) {
    this.pos = pos;
    this.h = h;
  }

  @Override
  public int compareTo(tree that) {
    // TODO Auto-generated method stub

    return this.pos - that.pos;
  }

}
