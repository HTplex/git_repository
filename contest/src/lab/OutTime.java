package lab;

public class OutTime {
  public static void main(String[] args) {

    long t = System.currentTimeMillis();
    StringBuilder a = new StringBuilder("");

    for (int i = 0; i < 300000; i++) {
//			System.out.println(0);
      a.append(0);
      a.append("\n");
    }

    System.out.println(a.toString());
    System.out.println(System.currentTimeMillis() - t);
  }
}
