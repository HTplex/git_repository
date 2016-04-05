package euler;

public class E002EvenFibonacci {
  public static void main(String[] args) {
    int a = 1;
    int b = 2;
    long sum = 0;
    int c = 0;
    while (c <= 4000000) {
      c = a + b;
      a = b;
      b = c;
      //System.out.println(c);
      if (c % 2 == 0)
        sum += c;
    }
    System.out.println(sum + 2);
  }
}
