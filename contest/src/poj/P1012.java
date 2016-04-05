package poj;

import java.util.Scanner;

public class P1012 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] applewatch = new int[13];
    for (int i = 1; i <= 13; i++) {
      int number = i;
      int go = -1;
      int person = 0;
      int step = number;
      do {
        person = number * 2;
        go = 0;
        step++;
        while (true) {
          go = (go + step - 1) % person;
          if (go < number) break;
          else person--;
          if (person == number) {
            //System.out.println(step);
            applewatch[number - 1] = step;
            break;
          }
        }
      } while (person > number);
    }
    //for(int i:applewatch) System.out.println(i);
    int i = in.nextInt();
    while (i != 0) {
      System.out.println(applewatch[i - 1]);
      i = in.nextInt();
    }
    in.close();
  }
}
