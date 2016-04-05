package euler;

public class E007prime {
  public static void main(String[] args) {
    long im = System.currentTimeMillis();
    final int num = 100001;
    long[] str = new long[num];
    int n = 2;
    str[0] = 2;
    for (int i = 1; i < num; i++) {
      while (!prime(str, i, n))
        n++;
      str[i] = n;
      if (i % 1000 == 0) System.out.println(i / 1000 + "%");
    }
    System.out.println(n);
    System.out.println(System.currentTimeMillis() - im);
  }

  public static boolean prime(long[] a, int go, long test) {
    for (int i = 0; i < go; i++) {
      if (test % a[i] == 0)
        return false;
    }
    return true;
  }
}
