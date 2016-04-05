package euler;

import java.util.Scanner;

public class E067tri {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int layer = 15;
    int[][] data = new int[layer][layer];
    for (int i = 0; i < layer; i++)
      for (int i1 = 0; i1 < i + 1; i1++)
        data[i][i1] = in.nextInt();
//		for(int[] i:data){
//			for(int i1:i){
//				System.out.print(i1);
//			}
//		System.out.println();
//		}


//		int[][] maxsum=new int[layer][layer];  
//				maxsum[layer-1]=data[layer-1].clone();
//			for(int i=layer-1;i>=0;i--){
//				for(int i1=0;i1<i+1;i1++){
//					maxsum[i][i1]=data[i][i1]+maxsum[]
//				}
//			}

    for (int i = layer - 2; i >= 0; i--) {
      for (int i1 = 0; i1 < i + 1; i1++) {
        data[i][i1] += max(data[i + 1][i1], data[i + 1][i1 + 1]);//dp: same storage, storage ideal sm
      }
    }

    System.out.println(data[0][0]);

  }

  public static int max(int a, int b) {
    return a > b ? a : b;
  }
}
