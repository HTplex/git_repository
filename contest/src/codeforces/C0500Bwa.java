package codeforces;

import java.util.Scanner;

public class C0500Bwa {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
//		int[] l={1,2,3,4,5};
//		swap(l,2,3);
//		for(int i:l){
//			System.out.print(i);
//		}
    int n = in.nextInt();


    int[] num = new int[n];

    int[][] sw = new int[n][n];
    for (int i = 0; i < n; i++) {
      num[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      String s = in.next();
      for (int i1 = 0; i1 < n; i1++) {
        sw[i][i1] = Integer.parseInt(s.substring(i1, i1 + 1));
      }
    }
    boolean[] tagw = new boolean[n];
    boolean[] tag = new boolean[n];

    for (int i = 0; i < n; i++) {
      tag[i] = false;
      tagw[i] = false;
    }
    for (int i = 0; i < n; i++) {
      //swap(num,i,findmin(i, sw,num,tag));
      findmin(i, sw, num, tag);
      //tagw[i]=true;
      for (int i1 = 0; i1 < n; i1++) {
        tag[i1] = tagw[i1];
      }
    }
    for (int i : num)
      System.out.print(i + " ");
    //System.out.print(findmin(0, sw,num,tag));
    in.close();
  }

  public static int findmin(int i, int[][] m, int[] a, boolean[] tag) {
    tag[i] = true;

    int min = a[i];
    int sw = i;
    for (int i1 = 0; i1 < a.length; i1++) {
      if (tag[i1]) continue;
      if (m[i1][i] == 1) {
        int w = findmin(i1, m, a, tag);
        if (a[w] > a[i1]) {
          if (min > a[i1]) {
            min = a[i1];
            sw = i1;
          }
        } else if (min > a[w]) {
          min = a[w];
          sw = w;
        }

      }

    }
    swap(a, i, sw);
    return i;
  }

  public static void swap(int[] c, int a, int b) {
    int m = c[a];
    c[a] = c[b];
    c[b] = m;
  }
}
