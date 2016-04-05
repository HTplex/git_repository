package euler;

public class E006Sumsquare {
  public static void main(String[] args) {
    long sq = 0;
    long q = 0;
    for (int i = 0; i <= 100; i++) {
      sq += i * i;
      q += i;
    }
    System.out.println(-sq + q * q);
  }
}
