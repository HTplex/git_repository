package codeforces;

import java.util.Scanner;

public class C0271D {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();
    int k = in.nextInt();
    long[] ans = new long[100050];
    ans[0] = 1;
    ans[1] = 1;
    for (int i = 0; i < k; i++) {
      ans[i] = 1;
    }
    for (int i = k; i < ans.length; i++) {
      ans[i] = (ans[i - 1] + ans[i - k]) % 1000000007;
      //	System.out.println(ans[i]);
    }
    long sum = 0;
    long[] su = new long[100050];
    for (int i = 0; i < 100050; i++) {
      if (i < k) sum = (sum + 1) % 1000000007;
      else sum = (sum + ans[i]) % 1000000007;
      su[i] = sum;
    }
    for (int ie = 0; ie < t; ie++) {
      int a = in.nextInt();
      int b = in.nextInt();
      // sum=0;

      long m = su[b] - su[a - 1];
      if (m < 0) m += 1000000007;
      System.out.println(m);
    }
  }
}
