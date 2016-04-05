package lab;


import java.util.Collection;

interface ElementJoiner {
  /**
   * 将ts里的元素以delimiter为分隔符连接起来。如 join(new Integer[]{1, 2, 3}, " | ") 会得到"1 | 2 | 3"
   *
   * @param ts        要连接的数组
   * @param delimiter 分隔符
   */
  public <T> String join(T[] ts, String delimiter);

  /**
   * 将ts里的元素以delimiter为分隔符连接起来。 在连接的结果中元素出现的顺序要按照集合自身的迭代器顺序。
   *
   * @see #join(T[], java.lang.String)
   */
  public <T> String join(Collection<T> ts, String delimiter);
}


public class ElementJointerImpl implements ElementJoiner {

  ElementJointerImpl() {

  }

  public <T> String join(T[] ts, String delimiter) {

    // TODO Auto-generated method stub
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < ts.length; i++) {
      sb.append(ts[i]);
      if (i != ts.length - 1) sb.append(delimiter);
    }
    return sb.toString();
  }

  public <T> String join(Collection<T> ts, String delimiter) {
    // TODO Auto-generated method stub
    StringBuilder sb = new StringBuilder("");
    for (T i : ts) {
      sb.append(i);
      sb.append(delimiter);
    }
    sb.delete(sb.length() - delimiter.length(), sb.length());
    return sb.toString();
  }
}
