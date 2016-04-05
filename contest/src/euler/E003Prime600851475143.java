package euler;

public class E003Prime600851475143 {
  public static void main(String[] args) {
    long g = 600851475143L;
    for (long i = 2; i < 10000000; i++) {
      while (g % i == 0 && g != i)
        g /= i;
    }
    System.out.println(g);
  }
}
