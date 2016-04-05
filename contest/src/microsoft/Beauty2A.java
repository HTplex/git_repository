package microsoft;

import java.util.Scanner;


public class Beauty2A {
  String string;
  long sum;

  public Beauty2A(String s) {
    this.string = s;
    this.sum = 0;
    StringBuffer buffer = new StringBuffer();
    String input = this.string;
    for (int i = 0; i < input.length(); i++) {
      permutation(input, i, buffer);
    }
  }

  public static void main(String args[]) {
    Scanner inScanner = new Scanner(System.in);
    int T = inScanner.nextInt();
    for (int i = 0; i < T; i++) {
      int n = inScanner.nextInt();
      StringBuilder sbBuilder = new StringBuilder("");
      for (int i2 = 0; i2 < n; i2++) {
        sbBuilder.append(inScanner.next().charAt(0));
      }
      Beauty2A v = new Beauty2A(sbBuilder.toString());
      if (sbBuilder.toString().length() > 1) {
        System.out.println("Case #" + (i + 1) + ": " + v.sum);
      } else System.out.println("Case #" + (i + 1) + ": " + 1);

    }

  }

  public void permutation(String inStr, int pos, StringBuffer parentData) {
    if (inStr.length() == 0) {
      return;
    }
    if (inStr.length() == 1) {

      return;
    }
    // here we need a new buffer to avoid to pollute the other nodes.  
    StringBuffer buffer = new StringBuffer();
    // copy from the parent node  
    buffer.append(parentData.toString());

    // choose the element  
    buffer.append(inStr.charAt(pos));

    // get the remnant elements.  
    String subStr = kickChar(inStr, pos);

    // got one of the result  
    if (subStr.length() == 1) {
      buffer.append(subStr);
      if (isV(buffer.toString()))
        this.sum++;


      return;
    }

    // here we use loop to choose other children.  
    for (int i = 0; i < subStr.length(); i++) {
      permutation(subStr, i, buffer);
    }

  }

  // a simple method to delete the element we choose
  private String kickChar(String src, int pos) {
    StringBuffer srcBuf = new StringBuffer();
    srcBuf.append(src);
    srcBuf.deleteCharAt(pos);
    return srcBuf.toString();
  }

  public boolean isV(String s) {
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1))
        return false;
    }
    return true;
  }
}
