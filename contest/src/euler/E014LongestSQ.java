package euler;

import java.util.Arrays;

public class E014LongestSQ {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    final int terminal = 1000000;


    int[] storage = new int[terminal + 1];
    Arrays.fill(storage, -1);
    storage[1] = 1;
    for (int i = 1; i <= terminal; i++) {
      Long long1 = new Long(i);
      storage[i] = step(long1, storage);

/*      Long current=new Long(i);
      int length=0;
      boolean b=storage[current.intValue()]<0;
      while(b){
        if(current%2==0){
          current/=2;
          length++;
        }
        else{
          current=current*3+1;
          length++;
        }
        
        b=current>=storage.length;
        if(!b) b=storage[current.intValue()]<0;
      }
      storage[i]=length+storage[current.intValue()];*/


    }
    
/*    for (int i : storage)
      System.out.println(i); //out
*/

    int max = 0;
    int maxId = 0;
    for (int i = 0; i < storage.length; i++) {
      if (max < storage[i]) {
        max = storage[i];
        maxId = i;
      }
    }
    System.out.println(maxId);
    System.out.println(storage[maxId]);
    System.out.println(System.currentTimeMillis() - start);
  }

  public static int step(Long a, int[] storage) { // stack exploded
    if (a < storage.length && storage[a.intValue()] > 0)
      return storage[a.intValue()];
    if (a % 2 == 0)
      return step(a / 2, storage) + 1;
    return step(3 * a + 1, storage) + 1;
  }

  public static int max(int a, int b) {
    return a > b ? a : b;
  }

}
