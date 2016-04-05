package microsoft;

import java.util.Arrays;
import java.util.Scanner;

public class BeautyB {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {//every case;
      double finalW = 0;
      int NumOfTri = in.nextInt();
      py[] pys = new py[NumOfTri];
      long[] maxW = new long[NumOfTri];
      for (int i1 = 0; i1 < NumOfTri; i1++) {
        long x = in.nextInt();
        long y = in.nextInt();
        long w = in.nextInt();
        pys[i1] = new py(x, y, w);
        Arrays.sort(pys);


      }


    }
    in.close();
  }
}

class py implements Comparable<py> {

  public long startPosition;
  public long endsPosition;
  public long money;

  py(long hx, long hy, long money) {
    this.startPosition = hx - hy;
    this.endsPosition = hx + hy;
    this.money = money;
  }

  public int compareTo(py that) {
    return this.endsPosition > that.endsPosition ? 1 : this.endsPosition == that.endsPosition ? 0 : -1;
  }
}