package codeforces;

import java.util.Scanner;

public class C520B {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int nn = n;
    int m = in.nextInt();
    //System.out.print(minus(m));
    if (m <= n) System.out.println(n - m);
//		else{
//			int add=0;
//			int min=0;
//			while(n<m){
//				n*=2;
//				add++;
//			}
//			min=minus(n-m,nn);
//			System.out.println(min+add);
//		}
    else {
      int count = 0;
      while (m > n) {
        if (m % 2 == 1) {
          count++;
          m++;
        }

        m /= 2;
        count++;
      }
      count += n - m;
      System.out.println(count);

    }
  }

  public static int minus(int a, int b) {
    int n = 0;
    while (a > b) {
      n += a % 2;
      a /= 2;
    }
    return n + a;
  }
}
