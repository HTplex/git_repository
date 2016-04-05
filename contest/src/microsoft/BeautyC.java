package microsoft;

import java.util.Scanner;

public class BeautyC {
  public static void main(String[] args) {
    final int n = 500000; // the biggest expected(limit in int)
    int[] primes = new int[n]; // place to storage known primes
    int count = 0; // end of primes array area
    boolean[] isP = new boolean[n]; // elimate future non-prime

    for (int i = 0; i < n; i++) {
      isP[i] = true; // initialize isP
    }

    for (int i = 2; i < n; i++) {
      if (isP[i]) {
        primes[count++] = i; // put found primes in storage
      }

      // main part

      for (int c = 0; c < count && primes[c] * i < n; c++) { // ///elimate non-primes(i) whose
        // smallest evenly-divede prime is
        // primes[c]
        isP[primes[c] * i] = false;
        if (i % primes[c] == 0) // if 4%2=0 then 4*2 is ok but 4*3 can
          break; // be n*2 so we wait unitl 6 comes

      }
    }
    isP[0] = false;
    isP[1] = false;


    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {

      int N = in.nextInt();
      int nums[] = new int[N];
      int[][] groups = new int[N][N];
      int[] grcount = new int[N];
      for (int i1 = 0; i1 < N; i1++) {
        nums[i1] = in.nextInt();
        groups[i1][grcount[i1]++] = nums[i1];

      }


      for (int im = 0; im < N; im++) {

        boolean b = true;
        int temp = 0;
        for (int ie = im + 1; ie < N; ie++) {
          while (groups[im][temp] > 0) {
            int a = groups[im][temp];
            int a2 = nums[ie];
            if (a < a2) {
              int tem = a;
              a = a2;
              a2 = tem;
            }

            if (!(a % a2 == 0 && isP[a / a2]))
              b = false;
            temp++;
          }
          if (b)
            groups[im][grcount[im]++] = nums[ie];
        }
      }


      for (int[] u : groups) {
        for (int uu : u) {
          System.out.print(uu + " ");
        }
        System.out.println();
      }
    }


    // end of the algorithm


  }
}
