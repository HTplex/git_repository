package euler;

//import
public class E009triangle {
  public static void main(String[] args) {
    final int total = 1000;
    for (int i = 0; i < 1000; i++) {
      for (int i1 = 0; i1 < 1000 - i; i1++) {
        if (square(i * i + i1 * i1) && i + i1 + (int) (Math.sqrt(i * i + i1 * i1)) == 1000)
          System.out.println(i + " " + i1 + " " + (1000 - i - i1) + " " + i * i1 * (1000 - i - i1));
      }

    }
  }

  public static boolean square(int a) {
    if (a == 0) return true;
    double b = Math.sqrt(a);
    int c = (int) b;
    return a % c == 0;
  }
}
