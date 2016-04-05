package codeforces;

import java.util.Scanner;

public class C0028Bwa {
  int n;
  boolean[] tag;
  int[] reach;
  int[] ter;
  public C0028Bwa(int n, int reach[], int[] ter) {
    this.n = n;
    this.reach = reach;
    this.ter = ter;
    this.tag = new boolean[n];
    for (int i = 0; i < n; i++) {
      this.tag[i] = false;
    }
    tag(reach, 0);
    //fulltag();

  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ter = new int[n];//terminal
    int[] reach = new int[n];

    for (int i = 0; i < n; i++) {
      ter[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      reach[i] = in.nextInt();
    }
    C0028Bwa c = new C0028Bwa(n, reach, ter);
    for (boolean i : c.tag) System.out.println(i);
    System.out.print(c.solve());
    //input end

    in.close();
  }

  public void tag(int reach[], int start) {
    if (this.tag[start]) return;
    this.tag[start] = true;
    if (start + reach[start] < n) tag(reach, start + reach[start]);
    if (start - reach[start] >= 0) tag(reach, start - reach[start]);
  }

  //	public void fulltag(){
//		int c=0;
//		for(int i=0;i<n;i++){
//			tag(this.reach,i,c);
//			while(i<n-1&&tag[i+1]>=0) i++;
//			c++;
//		}
//	}
  public boolean solve() {
    boolean b = true;
    for (int i = 0; i < n; i++) {
      for (int i1 = 0; i1 < n; i1++)
        this.tag[i1] = false;
      this.tag(reach, i);
      if (!tag[ter[i] - 1])
        b = false;
    }
    return b;
  }
}
