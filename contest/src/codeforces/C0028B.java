package codeforces;

import java.util.Scanner;

public class C0028B {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ter = new int[n];//terminal
    int[] reach = new int[n];

    for (int i = 0; i < n; i++) {
      ter[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      reach[i] = in.nextInt();
    }
    BDQuickUnionImproving bq = new BDQuickUnionImproving(n);
    for (int i = 0; i < n; i++) {
      if (reach[i] + i < n) bq.union(i, reach[i] + i);
      if (-reach[i] + i >= 0) bq.union(i, i - reach[i]);
    }
    boolean b = true;
    for (int i = 0; i < n; i++) {
      if (!bq.connected(i, ter[i] - 1)) b = false;
      //System.out.print(bq.connected(i,ter[i]-1));
    }
    System.out.print(b ? "YES" : "NO");
    in.close();
  }
}

class BDQuickUnionImproving {
  public int[] id;
  private int[] sz;

  public BDQuickUnionImproving(int N) {
    id = new int[N];
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  public static void main(String[] args) {

  }

  public int root(int a) {

    while (a != id[a]) {
      id[a] = id[id[a]]; //make the tree almost complete flat
      a = id[a];
    }
    return a;
  }

  public Boolean connected(int a, int b) {
    return root(a) == root(b);
  }

  public void union(int a, int b) {
    if (connected(a, b)) {
    }
    //System.out.println(a+" & "+b+" is already connected");
    else {
      if (sz[root(a)] >= sz[root(b)]) {
        id[root(b)] = root(a);
        sz[root(a)] += sz[root(b)];
      } else {
        id[root(a)] = root(b);
        sz[root(b)] += sz[root(a)];
      }
    }
  }

}
