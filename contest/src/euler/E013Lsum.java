package euler;

import java.math.BigInteger;
import java.util.Scanner;

public class E013Lsum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BigInteger sum = new BigInteger("0");
    for (int i = 0; i < 100; i++)
      sum = sum.add(new BigInteger(in.next()));
    System.out.println(sum.toString().substring(0, 10));
  }
}
