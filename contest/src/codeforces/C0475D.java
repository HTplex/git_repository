package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//import java.util.TreeMap;

public class C0475D {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    StringBuilder sb = new StringBuilder("");
    //TreeMap<Integer,Integer> t=new TreeMap<Integer,Integer>();
    //System.out.println(t.get(10));
    //System.out.print(gcd(0,0,t));
    //System.out.print(gcd(1000,60,t));

    //	System.out.println(gcd(2,6));
    Map<Integer, Integer> g = new HashMap<Integer, Integer>();
    int a = in.nextInt();
    int[] num = new int[a];
    for (int i = 0; i < a; i++) {
      num[i] = in.nextInt();
    }
//		java.util.Arrays.sort(num);
    int test = in.nextInt();
//		for(int i=0;i<a;i++){
//			int gc=num[i];
//			for(int i1=i;i1<a;i1++){
//				gc=gcd(gc,num[i1],t);
//				if(g.containsKey(gc)){
//					//if(g.get(gc)<i1-i+1)
//						g.put(gc,g.get(gc)+1);
//				}
//				else g.put(gc,1);
//			}
//		}
    //	int[][] temp=new int[100][2];


    //for(int i=1;i<num.length;i++){

//			g.put(num[0],1);
//			for(int u=0;u<temp.length;u++){
//				temp[u][0]=Integer.MIN_VALUE;
//				temp[u][1]=Integer.MIN_VALUE;
//			}
//			int c=0;
//			for(Integer k:g.keySet()){
//				temp[c][0]=gcd(k,num[i]);
//				if(g.containsKey(temp[c][0]))
//				temp[c][1]=g.get(k)+g.get(gcd(k,num[i]));
//				else temp[c][1]=g.get(k);
//				c++;
//				temp[c][0]=num[i];
//				if(g.containsKey(temp[c][0]))
//					temp[c][1]=g.get(temp[c][0])+1;
//				else temp[c][1]=1;
//				c++;
//			}
//			c=0;
    //g.clear();
    Map<Integer, Long> n = new HashMap<Integer, Long>();
    for (int iq = 0; iq < num.length; iq++) {
      Map<Integer, Integer> m = new HashMap<Integer, Integer>();
      for (Integer k : g.keySet()) {
        int t = gcd(k, num[iq]);
        if (m.containsKey(t))
          m.put(t, g.get(k) + m.get(t));
        else m.put(t, g.get(k));
      }
      if (m.containsKey(num[iq])) {
        m.put(num[iq], m.get(num[iq]) + 1);
      } else
        m.put(num[iq], 1);
      g = new HashMap<Integer, Integer>();
      for (Integer k : m.keySet()) {
        g.put(k, m.get(k));
      }
      for (Integer k : g.keySet()) {
        if (n.containsKey(k))
          n.put(k, n.get(k) + g.get(k));
        else
          n.put(k, (long) (g.get(k)));
      }
//			}
//			while(c<100&&temp[c][0]>=0){
//				//if(g.containsKey(temp[c][0]))
//					g.put(temp[c][0], temp[c][1]);
//				//else g.put(temp[c][0], temp[c][1]);
//				c++;
//			}
    }

    for (int i = 0; i < test; i++) {
      int p = in.nextInt();
      if (n.containsKey(p))
        sb.append(n.get(p));
      else sb.append(0);
      sb.append("\n");
    }
    System.out.print(sb.toString());
    in.close();
  }

  //	public static int ha(int a, int b){
//		Long d=a*10000000001L+b;
//		return d.hashCode();
//	}
//	public static int gcd(int a, int b,Map<Integer,Integer> t){
//		
//		if(a<b){
//			int c=a; a=b; b=c;
//		}
//		if(t.get(ha(a,b))!=null)
//			return t.get(ha(a,b));
//		else{
//		if(a%b!=0) {
//			t.put(ha(a,b),gcd(b,a-b));
//			return gcd(b,a-b);
//		}
//		t.put(ha(a,b),b);
//		return b;
//		}
//	}
  public static int gcd(int a, int b) {
    if (a < b) {
      int c = a;
      a = b;
      b = c;
    }
    if (a % b == 0) return b;
    return gcd(b, a % b);
  }
}
