package templets;

public class LinearSievePrime {
  public static void main(String[] args) {
    final int n = 1000000; // the biggest expected(limit in int)
    int[] primes = new int[n]; // place to storage known primes
    int count = 0; // end of primes array area
    boolean[] isP = new boolean[n]; // elimate future non-prime

    for (int i = 0; i < n; i++) {
      isP[i] = true; // initialize isP
    }

    for (int i = 2; i < n; i++) {
      if (isP[i]) {
        primes[count++] = i; // put found primes in storage
      }

      // main part

      for (int c = 0; c < count && primes[c] * i < n; c++) { // ///elimate non-primes(i) whose
        // smallest evenly-divede prime is
        // primes[c]
        isP[primes[c] * i] = false;
        if (i % primes[c] == 0) // if 4%2=0 then 4*2 is ok but 4*3 can
          break; // be n*2 so we wait unitl 6 comes

      }
    }

    // end of the algorithm


    for (int i = 0; i < count; i++)
      System.out.println(primes[i]); // sample output

  }
}
