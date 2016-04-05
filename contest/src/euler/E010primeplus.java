package euler;

public class E010primeplus {
  public static void main(String[] args) {
    long time = System.currentTimeMillis();
    final int n = 2000000;
    int[] primes = new int[n];
    int count = 0;
    boolean[] isP = new boolean[n];
    for (int i = 0; i < n; i++) {
      isP[i] = true;
    }
    for (int i = 2; i < n; i++) {
      if (isP[i]) {
        primes[count++] = i;
      }
      for (int c = 0; c < count && primes[c] * i < n; c++) {
        isP[primes[c] * i] = false;
        if (i % primes[c] == 0) //if 4%2=0 then 4*2 is ok but 4*3 can
          //be n*2 so we wait unitl 6 comes
          break;
      }

    }
    long sum = 0;
    for (int i = 0; i < count; i++)
      sum += primes[i];
    System.out.println(sum);
    System.out.println(System.currentTimeMillis() - time);
  }
}
