package euler;

public class E004tripalidrome {
  public static void main(String[] args) {
    int fnal = 0;
    for (int i = 100; i <= 999; i++) {
      for (int i2 = 100; i2 <= 999; i2++) {
        if (g(i * i2) && fnal < i * i2)
          fnal = i * i2;
      }
    }
    System.out.print(fnal);
  }

  public static boolean g(Integer a) {
    String s = a.toString();
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    return sb.toString().equals(s);
  }
}
