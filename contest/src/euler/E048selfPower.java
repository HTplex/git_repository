package euler;

public class E048selfPower {
  public static void main(String[] args) {
    final int num = 1000;
    long mod = 10000000000L;
//    System.out.println(12345671234567890L%mod);
    long sum = 0;
    for (int i = 1; i < num; i++) {
      long fac = 1;
      for (int i1 = 0; i1 < i; i1++) {
        fac *= i;
        fac %= mod;
      }
      sum += fac;
      sum %= mod;
    }
    System.out.println(sum);
  }
}
