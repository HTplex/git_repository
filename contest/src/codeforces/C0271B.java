package codeforces;

import java.util.Scanner;
import java.util.TreeMap;

public class C0271B {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = in.nextInt();
    }
    int sum = 0;
    TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      sum += id[i];
      m.put(sum, i + 1);
    }
    int n2 = in.nextInt();
    for (int i = 0; i < n2; i++) {
      int k = in.nextInt();
      sb.append(m.get(m.ceilingKey(k)) + "\n");
    }
    System.out.print(sb.toString());
  }
}
