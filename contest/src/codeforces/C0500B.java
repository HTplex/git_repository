package codeforces;

import java.util.Scanner;

public class C0500B {
  //12:57:28
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] num = new int[n];
    boolean[][] map = new boolean[n][n];//01010101001
    int[] temp1 = new int[n];
    int[] temp2 = new int[n];

    boolean[] tag = new boolean[n];//tag the conjoint place and ready to replace
    for (int i = 0; i < n; i++) {
      tag[i] = false;
    }              //clear tag;

    for (int i = 0; i < n; i++) {
      num[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      String s = in.next();
      for (int i1 = 0; i1 < n; i1++) {
        map[i][i1] = s.charAt(i1) == '1';
      }
    }
    //input over
    for (int i = 0; i < n; i++) {
      boolean[] ta = new boolean[n];
      for (int ie = 0; ie < n; ie++) {
        ta[ie] = findconjoint(map, i, tag)[ie];
      }
      for (int ie = 0; ie < n; ie++) {
        tag[ie] = ta[ie];
      }
      int c = 0;
      for (int i1 = 0; i1 < n; i1++) { //copy conjoint place
        //c=0;
        if (tag[i1]) {
          temp1[c] = num[i1];
          c++;
        }            //copy end;
      }
      java.util.Arrays.sort(temp1, 0, c);
      c = 0;
      for (int i1 = 0; i1 < n; i1++) {

        if (tag[i1]) {
          temp2[i1] = temp1[c];
          c++;
        }
      }
      while (i < n - 1 && tag[i + 1]) i++;
      //i--;
      for (int i1 = 0; i1 < n; i1++) {
        tag[i1] = false;
      }
    }
    for (int i : temp2) System.out.print(i + " ");

    in.close();
  }

  public static boolean[] findconjoint(boolean[][] map, int i, boolean[] tag) {
    //if(!tag[i]) return;
    tag[i] = true;
    for (int i1 = 0; i1 < map.length; i1++) {
      if (tag[i1]) continue;
      if (map[i][i1])
        findconjoint(map, i1, tag);
    }
    return tag;
  }
}
