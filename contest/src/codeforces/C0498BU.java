package codeforces;

import java.util.Scanner;

public class C0498BU {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int t = in.nextInt();
    double[][] prob = new double[s + 1][t + 1];
    int[][] info = new int[s + 1][2];
    info[0][0] = 0;
    info[0][1] = 0;
    for (int i = 1; i <= s; i++) {
      info[i][0] = in.nextInt();
      info[i][1] = info[i - 1][1] = in.nextInt();
    }
    for (int i = 0; i < s + 1; i++) {
      for (int i1 = 0; i1 < t + 1; i1++) {
        prob[i][i1] = Double.NEGATIVE_INFINITY;
        if (i == 0) prob[i][i1] = 1;
        else if (i1 == 0) prob[i][i1] = 0;
      }
    }
    double sum = 0;
    for (int i = 0; i < s + 1; i++) {
      sum += i * pp(prob, info, t, i);
    }
    for (double[] s1 : prob) {
      for (double s2 : s1)
        System.out.print(s2 + "\t");
      System.out.println();
    }
    System.out.println(sum / (s));
    in.close();
  }

  public static double pp(double[][] prob, int[][] info, int t, int s) {
    if (prob[s][t] >= 0) return prob[s][t];
    else {
      if (t >= info[s][1]) {
        prob[s][t] = 0;

      } else {
        prob[s][t] += (1 - prob[s][t - 1]) * (info[s][0] / 100.0) * prob[s - 1][t];

      }
      return prob[s][t];
    }
  }
}
