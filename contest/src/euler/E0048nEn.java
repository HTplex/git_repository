package euler;

public class E0048nEn {
  public static void main(String[] args) {
    final long a = 10000000000L;
    long b = 394871039413098471L;
    //System.out.println(b%a);
    long sum = 0;
    int i;
    for (i = 1; i <= 1000; i++) {
      long s = i;
      for (int i1 = 0; i1 < i; i1++) {
        s *= s;
        s %= a;
      }
      sum += s;
      sum %= a;
    }
    System.out.println(sum);
  }
}
