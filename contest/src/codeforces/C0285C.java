package codeforces;

import java.util.Scanner;

public class C0285C {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int sum = 0;
    double x = 1.0, y = 1.0, z = 1.0;
    double hx = in.nextDouble();
    double hy = in.nextDouble();
    double sx = in.nextDouble();
    double sy = in.nextDouble();
    int n = in.nextInt();
    if (sx == hx) {
      for (int i = 0; i < n; i++) {
        in.nextDouble();
        double yx = in.nextDouble();
        double zx = in.nextDouble();
        if (yx != 0 && ((zx <= hy && zx >= sy) || (zx >= hy && zx <= sy))) {
          sum++;
        } else continue;
      }
    } else {
      if (sy == hy) {
        x = 0;
        z = sy;
      } else {
        x = -1.0 / (sx - hx);
        y = -1.0 / (sy - hy);
        z = hy / (sy - hy) - hx / (sx - hx);
      }
//		point[] points=new point[300];
//		for(int i=0;i<points.length;i++){
//			points[i]=new point();
//		}


      for (int i = 0; i < n; i++) {
        double xq = 0;
        double xin = in.nextDouble();
        double yin = in.nextDouble();
        double zin = in.nextDouble();
        if (yin == 0) {
          if ((hx >= zin && sx <= zin) || (hx <= zin && sx >= zin)) {
            sum++;
          }
        } else if (xin / yin == x / y) continue;
        else {
          xq = po(x, y, z, xin, yin, zin);
          if ((hx >= xq && sx <= xq) || (hx <= xq && sx >= xq)) {
            sum++;
          }
        }
      }
    }
    System.out.println(sum);
    in.close();
  }

  public static double po(double x1, double y1, double z1, double x2, double y2, double z2) {
    double ans;
    ans = (z1 * y2 - z2 * y1) / (x1 * y2 - x2 * y1);
    //ans[1]=(x1*z2-x2*z1)/(x1*y2-x2*y1);
    return ans;
  }
}

class point {
  public double x;
  public double y;
  public int num;

  point(double x, double y) {
    this.x = x;
    this.y = y;
    this.num = 1;
  }

  point() {
    this.x = Double.NEGATIVE_INFINITY;
    this.y = Double.NEGATIVE_INFINITY;
    this.num = -1;
  }
}
