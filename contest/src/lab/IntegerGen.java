package lab;

/**
 * Created by htplex on 2/12/2015.
 */
public class IntegerGen {
  public static void main(String[] args) {
    for (int i = 0; i < 1000000; i++) {
      System.out.print((int) (1000000 * Math.random()) + " ");
    }
  }
}
