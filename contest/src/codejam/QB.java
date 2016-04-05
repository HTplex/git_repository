package codejam;

import java.util.Calendar;

public class QB {
  public static void main(String[] args) {
    Calendar a = Calendar.getInstance();
    a.set(1, 2014);
    a.set(2, 11);
    for (int i = 0; i <= 1000; i++) {
      a.set(5, 9 + i);
      System.out.println(a.get(1) + " " + a.get(2) + " " + a.get(5) + " ");
    }


  }
}
