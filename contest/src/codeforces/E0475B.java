package codeforces;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Map;

public class E0475B {
  public static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();
    int n = Integer.parseInt(in.readLine());
    TreeMap<Integer, Integer> gend = new TreeMap<>();
    int[] a = new int[n];
    StringTokenizer strtok;
    strtok = new StringTokenizer(in.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(strtok.nextToken());
    int q = Integer.parseInt(in.readLine());
    int[] queries = new int[q];
    TreeMap<Integer, Long> qans = new TreeMap<>();
    for (int i = 0; i < q; i++) {
      queries[i] = Integer.parseInt(in.readLine());
    }

    int[][] temp = new int[60][2]; // cause im 1337 :D
    for (int i = 0; i < a.length; i++) {
      int top = 0;
      for (Entry<Integer, Integer> e : gend.entrySet()) {
        temp[top][0] = e.getKey();
        temp[top++][1] = e.getValue();
      }
      temp[top][0] = a[i];
      temp[top++][1] = i;
      for (int j = 0; j < top; j++) {
        int g = gcd(temp[j][0], a[i]);
        if (g != temp[j][0])
          gend.remove(temp[j][0]);
        if (!gend.containsKey(g))
          gend.put(g, temp[j][1]);
        gend.put(g, Math.min(gend.get(g), temp[j][1]));
      }
      top = 0;
      for (Entry<Integer, Integer> e : gend.entrySet()) {
        temp[top][0] = e.getKey();
        temp[top++][1] = e.getValue();
      }
      int s = i + 1;
      for (int j = top - 1; j >= 0; j--) {
        // System.out.println(i + " " + Arrays.toString(temp[j]));
        if (!qans.containsKey(temp[j][0]))
          qans.put(temp[j][0], 0L);
        qans.put(temp[j][0], qans.get(temp[j][0]) + s - temp[j][1]);
        s = temp[j][1];
      }
    }
    for (int i = 0; i < q; i++) {
      if (qans.containsKey(queries[i]))
        out.append(qans.get(queries[i]) + "\n");
      else
        out.append(0 + "\n");
    }
    System.out.print(out);
  }
}