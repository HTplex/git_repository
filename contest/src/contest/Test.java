package contest;

import java.util.Scanner;

public class Test {
  int count = 0;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int e = input.nextInt();

    char[] c = input.next().toCharArray();
    input.close();
    Test m = new Test();
    //System.out.println(m.testSym(c, 1,2));
    m.count(c, 0, e - 1);
    System.out.println(m.count);
    //	System.out.println(testSym(s.toCharArray(),0,s.length()-1));
  }

  public static boolean testSym(char[] c, int a, int b) {
    for (int i = 0; i <= b - a; i++) {
      if (c[a + i] == c[b - i])
        return false;
    }
    return true;
  }

  public void count(char[] a, int from, int to) {

    int m = (from + to) / 2;
    if (from >= to) return;
    count(a, from, m);
    count(a, m + 1, to);


    for (int i = from; i <= m; i++)
      for (int i2 = m + 1; i2 <= to; i2++) {
        if ((i2 - i) % 2 == 1) {
          if (testSym(a, i, i2)) {
            this.count++;
          }
          //for(int k=i;k<=i2;k++){
          //	System.out.print(a[k]);
          //}
          //		System.out.println();

        }
      }
  }
}

