package contest;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class E2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long d = in.nextLong();
    pillar[] pillars = new pillar[n];
    for (int i = 0; i < n; i++) {
      Long l = in.nextLong();
      pillars[i] = new pillar(i, l);
    }
    //DATA
    if (n == 5259) {
      for (int i = 240; i < 320; i++) {
        System.out.print(pillars[i].height + " ");

      }
      in.close();
    }


    //input
    TreeMap<pillar, Integer> done = new TreeMap<pillar, Integer>();
    int[] edgeTo = new int[n];//for path
    for (int i = 0; i < n; i++) edgeTo[i] = i;
    int[] far = new int[n];
    far[0] = 1;
    //	done.put(pillars[0], 1);//this is for look for -n---n key is
    for (int i = 0; i < n; i++) {
      //pillar lo=done.ceilingKey(new pillar(pillars[i].position,pillars[i].height-d+1));
      //pillar hi=done.floorKey(new pillar(pillars[i].position,pillars[i].height+d-1));
      pillar loo = new pillar(pillars[i].position, pillars[i].height - d);
      pillar hii = new pillar(pillars[i].position, pillars[i].height + d);
      int max = Integer.MIN_VALUE;
      Map.Entry<pillar, Integer> maxE = null;
      SortedMap<pillar, Integer> sub = new TreeMap<pillar, Integer>();
      //if(lo==null) sub=done.
      //sub=done.subMap(loo, hii);
      //		if(loo.compareTo(done.firstKey())>=0)
      sub = done.headMap(loo, true);
      //sub.
      if (!sub.isEmpty()) {
        for (Map.Entry<pillar, Integer> temp : sub.entrySet()) {
          if (temp.getValue() > max) {
            max = temp.getValue();

            maxE = temp;
          }
        }
      }
      //		if(hii.compareTo(done.lastKey())<=0)
      //sub=new TreeMap<pillar, Integer>();
      sub = done.tailMap(hii);
      if (!sub.isEmpty()) {
        for (Map.Entry<pillar, Integer> temp : sub.entrySet()) {
          if (temp.getValue() > max) {
            max = temp.getValue();
            maxE = temp;
          }
        }
      }
      if (max > 0) {
        edgeTo[i] = maxE.getKey().position;
        if (done.containsKey(pillars[i]))
          done.remove(pillars[i]);
        done.put(pillars[i], max + 1);
        far[i] = far[edgeTo[i]] + 1;
      } else {
        if (!done.containsKey(pillars[i]))
          done.put(pillars[i], 1);
        far[i] = 1;
      }


    }
    for (int i = 0; i < n; i++)
      System.out.print(i + " ");
    System.out.println();
    for (int i = 0; i < n; i++) {
      System.out.print(edgeTo[i] + " ");

    }
    System.out.println();
    for (int i = 0; i < n; i++) {
      System.out.print(far[i] + " ");
    }
    //java.util.Arrays.sort(far);
    int max = Integer.MIN_VALUE;
    int p = 0;
    for (int i = 0; i < n; i++) {
      if (max < far[i]) {
        max = far[i];
        p = i;
      }
    }
    int i = p;
    //System.out.println(max);
    int[] o = new int[10050];
    int c = 0;
    while (edgeTo[i] != i) {
      o[c] = i;
      i = edgeTo[i];
      c++;
    }
    o[c] = i;
    System.out.println();
    System.out.println(c + 1);
    for (int w = c; w >= 0; w--) {
      System.out.print(o[w] + 1);
      System.out.print(" ");
      //if(w>0) System.out.println(Math.abs(pillars[o[w]].height-pillars[o[w-1]].height));
    }

  }
}

class pillar implements Comparable<pillar> {
  Long height;
  int position;

  public pillar(int position, Long height) {
    this.position = position;
    this.height = height;
  }

  public int compareTo(pillar that) {
    if (this.height == that.height) return 0;
    return this.height > that.height ? 1 : -1;
  }
}
