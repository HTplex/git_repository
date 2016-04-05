package lab;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by htplex on 2/12/2015.
 */
public class fastInput {
  public static void main(String[] args) {
    long i = System.currentTimeMillis();
    int[] a = slowin(1000000);
    System.out.println(System.currentTimeMillis() - i);
    i = System.currentTimeMillis();
    int[] b = fastin1(1000000);
    System.out.println(System.currentTimeMillis() - i);
    i = System.currentTimeMillis();
    int[] c = fastInByPetr(1000000);
    System.out.println(System.currentTimeMillis() - i);


  }

  static int[] slowin(int n) {
    Scanner in = new Scanner(System.in);
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    return a;
  }

  static int[] fastin1(int n) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    String[] ss = s.split(" ");
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(ss[i]);
    }
    return a;
  }

  static int[] fastInByPetr(int n) {
    InputStream inputStream = System.in;
    OutputStream outStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outStream);
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    return a;
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

  }
}
