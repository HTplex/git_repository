package lab;

import java.util.Scanner;

public class duplicator {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    for (Integer i = 0; i < 16; i++) {
      System.out.println("\t\t" + s.replace("0", i.toString()));
    }
  }
}
