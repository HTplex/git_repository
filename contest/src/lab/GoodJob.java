package lab;

public class GoodJob extends Thread {
  int x = 0;

  public static void main(String[] args) {
    new GoodJob().run();
  }

  public void run() {
    Runnable r1 = new Runner();
    new Thread(r1).start();
    new Thread(r1).start();
  }

  public class Runner implements Runnable {
    public void run() {
      int current = 0;
      for (int i = 0; i < 4; i++) {
        current = x;
        System.out.print(current + ",");
        x = current + 2;
      }
    }
  }
}
