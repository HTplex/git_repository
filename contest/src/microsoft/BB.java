package microsoft;

/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
`=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        佛祖保佑       赫冬阳专四高分飘过～～
*/

import java.util.Scanner;

public class BB {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    for (int mm = 0; mm < n; mm++) {
      String s = in.next();
      final int mod = 100007;
      //  System.out.println(s.charAt(0));
      //   System.out.println(isVal(s));
      long[][] total = new long[s.length()][s.length()];
      for (int i = 0; i < total.length; i++) {
        total[i][i] = 1;
      }
      for (int count = 0; count < s.length(); count++) {
        for (int start = 0; start + count < s.length(); start++) {
          if (count == 0) {
            total[start][start + count] = 1;
            continue;
          }
          if (s.charAt(start) == s.charAt(start + count)) {
            long sum = total[start + 1][start + count] + total[start][start + count - 1] + 1;
            sum %= mod;
            //  System.out.println(start+" "+start+count);
            //   System.out.println(start+1+" "+start+count+"  "+start+" "+(start+count-1));
            total[start][start + count] = sum;
            continue;
          }
          total[start][start + count] = (total[start + 1][start + count] +
                  total[start][start + count - 1] - total[start + 1][start + count - 1]) % mod;
          //  System.out.println(start+1+" "+start+count+"  "+start+" "+(start+count-1));
        }
      }
      for (long[] i : total) {
        for (long i1 : i)
          System.out.print(i1 + "\t");
        System.out.println();
      }
      //    System.out.println("Case #"+(mm+1)+": "+total[0][total.length-1]);
    }
  }


  public static boolean isVal(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  }
}
