package microsoft;

import java.util.Scanner;

public class B {
  static boolean[] flag = new boolean[99999];
  static int[] count = new int[99999];

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {
      int T = in.nextInt();
      for (int i0 = 0; i0 < T; i0++) {
        int mod = in.nextInt();
        int sig = in.nextInt();

        int[] sign = new int[sig];

        signal[] s = new signal[99999];

        int[] index = new int[99999];
        for (int i = 0; i < index.length; i++) {
          index[i] = -1;
        }

        for (int i = 0; i < sig; i++) {
          sign[i] = in.nextInt();
        }

        for (int i = 0; i < mod; i++) {
          int n = in.nextInt();
          int num = in.nextInt();
          int[] em = new int[num];
          index[i] = n;
          flag[n] = true;
          for (int i1 = 0; i1 < num; i1++) {
            em[i1] = in.nextInt();
          }
          s[n] = new signal(num, em);
        }

        for (int i = 0; i < sig; i++) {
          go(sign[i], s);
        }
        for (int i = 0; i < 100; i++) {
          System.out.print(count[i] + " ");
        }
        System.out.println();
      }
    }

  }

  public static void go(int sig, signal[] signal) {
    if (flag[sig]) {
      System.out.print("aa");
      count[sig]++;
      for (int i : signal[sig].exit) {
        go(i, signal);
      }
    }
  }
}

class signal {
  int[] exit;

  signal(int s, int... n) {
    this.exit = new int[s];
    for (int i = 0; i < s; i++) {
      this.exit[i] = n[i];
    }
  }
}