package euler;

public class E042TriWords {
  public static void main(String[] args) {

//    Scanner in=new Scanner(System.in);
//    String string=in.next();
//    String[] strings=string.split(",");
//    int sum=0;
//    
//    for(int i=0;i<strings.length;i++){
//      if(tri(strings[i])) sum++;
//    }
//    System.out.println(sum); 300 385 285
//    
    for (int i = 0; i < 10000; i++) {
      if (isTriNum(i))
        System.out.println(i);
    }
  }

  public static boolean tri(String s) {
    int acc = 0;
    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; i++) {
      acc += c[i] - 'A' + 1;
    }
    System.out.println(acc);
    return isTriNum(acc);
  }

  public static boolean isTriNum(int n) {
    for (int i = 0; i <= n; i++) {
      if (n == i * (i + 1) / 2)
        return true;
    }
    return false;
  }
}
