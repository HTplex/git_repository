package euler;

import java.math.BigInteger;

public class E010FactDSum {
  public static void main(String[] args) {


  }

  public static int BigIntSolve(int nums) {
    BigInteger Fact = BigInteger.ONE;
    for (Integer i = 1; i <= nums; i++) {
      Fact = Fact.multiply(new BigInteger(i.toString()));
    }
    // System.out.println(Fact.toString());
    String string = Fact.toString();
    int DSum = 0;
    for (int i = 0; i < string.length(); i++)
      DSum += (string.charAt(i) - '0');

    return DSum;
  }
  /*
   * public static int[] BigIntSolveDp(int nums){ failed int[] count=new int[10]; count[1]=1;
   * for(Integer i=1;i<=nums;i++){ count=multi(i, count); } int sum=0; for(int
   * i=0;i<count.length;i++){ sum+=i*count[i]; } return count; } public static int[] multi(Integer
   * m, int[] stor){ int[] re=new int[10]; for(Integer i=1;i<=9;i++){ String multi=(new
   * Integer(i*m)).toString(); for(int i1=0;i1<multi.length();i1++){
   * re[multi.charAt(i1)-'0']+=stor[i]; } } return re; }
   */
}
