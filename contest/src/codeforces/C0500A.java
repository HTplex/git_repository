package codeforces;

import java.util.Scanner;

public class C0500A {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int d = in.nextInt();
    int[] p = new int[n];
    int i = 0;
    for (i = 0; i < p.length - 1; i++) {
      p[i] = in.nextInt();
    }
    //System.out.print(i);
//		Boolean[] b=new Boolean[n];
//		b[0]=true;
//		for(int i=1;i<n;i++){
//			b[i]=false;
//		}
    i = 0;
    int c = 0;
    while (i < (d - 1) && c < p.length) {
      i += p[i];
      c++;
    }
//		System.out.print(i+" "+d);
    if (i == d - 1) System.out.print("YES");
    else System.out.print("NO");

    in.close();
  }
}
