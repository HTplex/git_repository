package contest;

import java.util.Scanner;

public class Go {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    for (int i = 0; i < num; i++) {
      int n = input.nextInt();
      line[] a = new line[n];
      for (int i2 = 0; i2 < n; i2++) {
        int g = input.nextInt();
        int h = input.nextInt();
        a[i2] = new line(g, h);
      }
      java.util.Arrays.sort(a);
      int storge = -1;
      int current = 1;
      //int head=a[0].head;
      int tail = a[0].tail;
      for (int s = 1; s < a.length; s++) {
        if (a[s].head <= tail) {
          current++;
          tail = less(tail, a[s].tail);
          //head=a[s].head;
        } else {
          storge = more(storge, current);
          //head=a[s].head;
          tail = a[s].tail;
          current = 1;
        }

      }
      System.out.println(more(current, storge));

    }
    input.close();
  }

  public static int less(int a, int b) {
    if (a > b) return b;
    else return a;
  }

  public static int more(int a, int b) {
    if (a < b) return b;
    else return a;
  }
}

class line implements Comparable<line> {
  int head;
  int tail;

  public line(int a, int b) {
    this.head = a;
    this.tail = b;
  }

  public int compareTo(line b) {
    return this.head - b.head;
  }

}
