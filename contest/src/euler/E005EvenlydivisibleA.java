package euler;

public class E005EvenlydivisibleA {
  public static void main(String[] args) {
    long a = 1;
    for (int i = 2; i < 20; i++) {
      a = lcm(a, i);
    }
    System.out.println(a);
  }

  public static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static long lcm(long a, long b) {
    return a * b / gcd(a, b);
  }
}
