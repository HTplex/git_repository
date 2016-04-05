package codeforces;

import java.util.Scanner;
import java.util.TreeMap;

public class C {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    TreeMap<Integer, Integer> a = new TreeMap<>();
    int[] str = new int[n];
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      str[i] = t;
      if (!a.containsKey(t))

        a.put(t, 1);
      else
        a.put(t, a.get(t) + 1);
    }
    java.util.Arrays.sort(str);
    int count = 2;
    int r = str.length - 1;
    int[] s = new int[2];
    int cc = 0;
    boolean b = false;
    while (count > 0) {

      if (a.get(str[r]) >= 4) {
        System.out.print(str[r] * str[r]);
        b = true;
        break;
      }
      if (a.get(str[r]) >= 2) {
        a.put(str[r], 0);
        r--;
        count--;
        s[cc] = str[r];
        cc++;
      }
    }
    if (!b)
      System.out.println(s[0] * s[1]);
  }
}