package codeforces;

import java.util.Scanner;

public class C2775B {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n1 = in.nextInt();
    int[] male = new int[n1];
    for (int i = 0; i < n1; i++) {
      male[i] = in.nextInt();
    }
    int n2 = in.nextInt();
    int[] female = new int[n2];
    for (int i = 0; i < n2; i++) {
      female[i] = in.nextInt();
    }
    java.util.Arrays.sort(male);
    java.util.Arrays.sort(female);
    int count2 = 0;
    int count3 = 0;
    for (int i = 0; i < n1 && count2 < n2; i++) {
      if (female[count2] < male[i] - 1) {
        count2++;
        i--;
      } else if (female[count2] <= male[i] + 1) {
        count2++;
        count3++;
      }
    }
    System.out.println(count3);
  }
}
