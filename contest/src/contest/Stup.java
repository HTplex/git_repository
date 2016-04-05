package contest;

import java.util.Scanner;

public class Stup {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      StringBuilder sb = new StringBuilder("");
      String s = in.nextLine();
      for (int i = 0; i < s.length(); i++) {
        Character c = s.charAt(i);
        if (Character.isUpperCase(c) || Character.isLowerCase(c) || c == ' ') {
          sb.append(c);
        }
      }
      System.out.println(sb.toString());
    }
    in.close();
  }
}
