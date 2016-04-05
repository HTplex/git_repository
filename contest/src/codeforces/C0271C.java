package codeforces;

import java.util.Scanner;

public class C0271C {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    for (int qi = 0; qi < n; qi++) {
      pointt[] po = new pointt[4];
      for (int e = 0; e < 4; e++) {
        int x = in.nextInt();
        int y = in.nextInt();
        int hx = in.nextInt();
        int hy = in.nextInt();
        po[e] = new pointt(x, y, hx, hy);
      }

      int min = 9999999;
      for (int i = 0; i < 4; i++) {
        for (int i1 = 0; i1 < 4; i1++) {
          for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
              if (issq(po[0], po[1], po[2], po[3]) && min > (po[0].r + po[1].r + po[2].r + po[3].r))
                min = po[0].r + po[1].r + po[2].r + po[3].r;
              po[0].r();
              //po[0].print();
            }
            po[1].r();
          }
          po[2].r();
        }
        po[3].r();
      }
      System.out.println(min == 9999999 ? -1 : min);
    }

//		a.print();
//		a.r();
//		a.print();
  }

  public static boolean issq(pointt a, pointt b, pointt c, pointt d) {
    line l1 = new line(a, b);
    line l2 = new line(b, c);
    line l3 = new line(c, d);
    line l4 = new line(a, c);
    line l5 = new line(a, d);
    line l6 = new line(b, d);
    //boolean v=(isrect(l1,l2)&&isrect(l2,l3))||(isrect(l1,l3)&&isrect(l2,l3))||isrect(l1,l2)&&isrect(l1,l3);
    //boolean w=l1.lengthsq==l2.lengthsq;
    int sum = isrect(l1, l2) + isrect(l1, l3) + isrect(l1, l4) + isrect(l1, l5) + isrect(l1, l6) + isrect(l2, l3) + isrect(l2, l4) + isrect(l2, l5) + isrect(l2, l6) + isrect(l3, l4) + isrect(l3, l5) + isrect(l3, l6) + isrect(l4, l5) + isrect(l4, l6) + isrect(l5, l6);
    //System.out.println(sum);
    return sum == 5;

  }

  public static int isrect(line x, line y) {
    //System.out.print(x.x*y.x+x.y*y.y==0);
    //System.out.print(x.lengthsq+" "+y.lengthsq+",,");
    return x.x * y.x + x.y * y.y == 0 && (x.lengthsq != 0 && y.lengthsq != 0) ? 1 : 0;
  }
}

class line {
  int x;
  int y;
  int lengthsq;

  line(pointt a, pointt b) {
    this.x = a.x - b.x;
    this.y = a.y - b.y;
    this.lengthsq = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
  }

}

class pointt {
  int x;
  int y;
  int hx;
  int hy;
  int r;

  public pointt(int x, int y, int hx, int hy) {
    this.x = x;
    this.y = y;
    this.hx = hx;
    this.hy = hy;
    this.r = 0;
  }

  public void r() {
    int xx = this.hx + this.hy - this.y;
    int yy = this.hy + this.x - this.hx;
    this.x = xx;
    this.y = yy;
    this.r = (this.r + 1) % 4;
  }

  public void print() {
    System.out.println(this.x + " " + this.y + " " + this.hx + " " + this.hy + " " + this.r);
  }
}