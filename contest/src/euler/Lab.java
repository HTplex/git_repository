package euler;

public class Lab {
  public static void main(String[] args) {
    int[] a = new int[10];
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
    swap(a, 1, 4);
    for (int i : a)
      System.out.println(i);
  }

  public static void swap(int[] a, int m, int n) {
    a[m] = a[n];
  }
}
