package lab;


import java.io.*;
import java.math.BigInteger;
import java.util.*;

interface Function<A, V> {
  public abstract V value(A argument);
}

interface Edge {
  public int getSource();

  public int getDestination();

  public long getWeight();

  public long getCapacity();

  public long getFlow();

  public void pushFlow(long flow);

  public boolean getFlag(int bit);

  public void setFlag(int bit);

  public void removeFlag(int bit);

  public int getTransposedID();

  public Edge getTransposedEdge();

  public int getReverseID();

  public Edge getReverseEdge();

  public int getID();

  public void remove();

  public void restore();
}

interface IntIterator {
  public int value() throws NoSuchElementException;

  /*
   * @throws NoSuchElementException only if iterator already invalid
   */
  public void advance() throws NoSuchElementException;

  public boolean isValid();
}

interface IntComparator {
  public static final IntComparator DEFAULT = new IntComparator() {
    public int compare(int first, int second) {
      if (first < second)
        return -1;
      if (first > second)
        return 1;
      return 0;
    }
  };

  public static final IntComparator REVERSE = new IntComparator() {
    public int compare(int first, int second) {
      if (first < second)
        return 1;
      if (first > second)
        return -1;
      return 0;
    }
  };

  public int compare(int first, int second);
}

interface IntTask {
  public void process(int value);
}

interface IntFunction {
  public int value(int key);
}

interface IndependentSetSystem {
  public boolean join(int first, int second);

  public int get(int index);

  public int getSetCount();

  public void setListener(Listener listener);

  public static interface Listener {
    public void joined(int joinedRoot, int root);
  }
}

public class longlong {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    OutputWriter out = new OutputWriter(outputStream);
    Task solver = new Task();
    solver.solve(1, in, out);
    out.close();
  }
}

class Task {

  Map<Integer, Long>[] map;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    map = new Map[n + 1];
    for (int i = 0; i <= n; i++) map[i] = new TreeMap<Integer, Long>();
    for (int i = 1; i <= n; i++) {
      int x = in.readInt();
      map[i].put(x, get(i, x) + 1);
      for (int j : map[i - 1].keySet()) {
        int gcd = IntegerUtils.gcd(j, x);
        map[i].put(gcd, get(i, gcd) + get(i - 1, j));
      }
//			for (int j: map[i].keySet()) out.printFormat("(%d, %d) ", j, map[i].get(j));
//			out.printLine();
    }
    for (int i = 1; i < n; i++) for (int j : map[i].keySet()) map[n].put(j, get(n, j) + get(i, j));
    int q = in.readInt();
    while (q-- > 0) {
      int x = in.readInt();
      out.printLine(get(n, x));
    }
  }

  long get(int i, int x) {
    return map[i].containsKey(x) ? map[i].get(x) : 0;
  }
}

class OutputWriter {
  private final PrintWriter writer;

  public OutputWriter(OutputStream outputStream) {
    writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
            outputStream)));
  }

  public OutputWriter(Writer writer) {
    this.writer = new PrintWriter(writer);
  }

  public void print(char[] array) {
    writer.print(array);
  }

  public void print(Object... objects) {
    for (int i = 0; i < objects.length; i++) {
      if (i != 0)
        writer.print(' ');
      writer.print(objects[i]);
    }
  }

  public void print(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (i != 0)
        writer.print(' ');
      writer.print(array[i]);
    }
  }

  public void print(long[] array) {
    for (int i = 0; i < array.length; i++) {
      if (i != 0)
        writer.print(' ');
      writer.print(array[i]);
    }
  }

  public void print(IntCollection collection) {
    boolean first = true;
    for (IntIterator iterator = collection.iterator(); iterator.isValid(); iterator
            .advance()) {
      if (first)
        first = false;
      else
        writer.print(' ');
      writer.print(iterator.value());
    }
  }

  public void printLine(int[] array) {
    print(array);
    writer.println();
  }

  public void printLine(long[] array) {
    print(array);
    writer.println();
  }

  public void printLine(IntCollection collection) {
    print(collection);
    writer.println();
  }

  public void printLine() {
    writer.println();
  }

  public void printLine(Object... objects) {
    print(objects);
    writer.println();
  }

  public void print(char i) {
    writer.print(i);
  }

  public void printLine(char i) {
    writer.println(i);
  }

  public void printLine(char[] array) {
    writer.println(array);
  }

  public void printFormat(String format, Object... objects) {
    writer.printf(format, objects);
  }

  public void close() {
    writer.close();
  }

  public void flush() {
    writer.flush();
  }

  public void print(long i) {
    writer.print(i);
  }

  public void printLine(long i) {
    writer.println(i);
  }

  public void print(int i) {
    writer.print(i);
  }

  public void printLine(int i) {
    writer.println(i);
  }
}

class InputReader {
  private boolean finished = false;

  private InputStream stream;
  private byte[] buf = new byte[1024];
  private int curChar;
  private int numChars;
  private SpaceCharFilter filter;

  public InputReader(InputStream stream) {
    this.stream = stream;
  }

  public static boolean isWhitespace(int c) {
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
  }

  public int read() {
    if (numChars == -1)
      throw new InputMismatchException();
    if (curChar >= numChars) {
      curChar = 0;
      try {
        numChars = stream.read(buf);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
      if (numChars <= 0)
        return -1;
    }
    return buf[curChar++];
  }

  public int peek() {
    if (numChars == -1)
      return -1;
    if (curChar >= numChars) {
      curChar = 0;
      try {
        numChars = stream.read(buf);
      } catch (IOException e) {
        return -1;
      }
      if (numChars <= 0)
        return -1;
    }
    return buf[curChar];
  }

  public int readInt() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    int res = 0;
    do {
      if (c < '0' || c > '9')
        throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public long readLong() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    long res = 0;
    do {
      if (c < '0' || c > '9')
        throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    } while (!isSpaceChar(c));
    return res * sgn;
  }

  public String readString() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    StringBuilder res = new StringBuilder();
    do {
      if (Character.isValidCodePoint(c))
        res.appendCodePoint(c);
      c = read();
    } while (!isSpaceChar(c));
    return res.toString();
  }

  public boolean isSpaceChar(int c) {
    if (filter != null)
      return filter.isSpaceChar(c);
    return isWhitespace(c);
  }

  private String readLine0() {
    StringBuilder buf = new StringBuilder();
    int c = read();
    while (c != '\n' && c != -1) {
      if (c != '\r')
        buf.appendCodePoint(c);
      c = read();
    }
    return buf.toString();
  }

  public String readLine() {
    String s = readLine0();
    while (s.trim().length() == 0)
      s = readLine0();
    return s;
  }

  public String readLine(boolean ignoreEmptyLines) {
    if (ignoreEmptyLines)
      return readLine();
    else
      return readLine0();
  }

  public BigInteger readBigInteger() {
    try {
      return new BigInteger(readString());
    } catch (NumberFormatException e) {
      throw new InputMismatchException();
    }
  }

  public char readCharacter() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    return (char) c;
  }

  public double readDouble() {
    int c = read();
    while (isSpaceChar(c))
      c = read();
    int sgn = 1;
    if (c == '-') {
      sgn = -1;
      c = read();
    }
    double res = 0;
    while (!isSpaceChar(c) && c != '.') {
      if (c == 'e' || c == 'E')
        return res * Math.pow(10, readInt());
      if (c < '0' || c > '9')
        throw new InputMismatchException();
      res *= 10;
      res += c - '0';
      c = read();
    }
    if (c == '.') {
      c = read();
      double m = 1;
      while (!isSpaceChar(c)) {
        if (c == 'e' || c == 'E')
          return res * Math.pow(10, readInt());
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        m /= 10;
        res += (c - '0') * m;
        c = read();
      }
    }
    return res * sgn;
  }

  public boolean isExhausted() {
    int value;
    while (isSpaceChar(value = peek()) && value != -1)
      read();
    return value == -1;
  }

  public String next() {
    return readString();
  }

  public SpaceCharFilter getFilter() {
    return filter;
  }

  public void setFilter(SpaceCharFilter filter) {
    this.filter = filter;
  }

  public interface SpaceCharFilter {
    public boolean isSpaceChar(int ch);
  }
}

class ArrayUtils {
  public static Integer[] generateOrder(int size) {
    Integer[] order = new Integer[size];
    for (int i = 0; i < size; i++)
      order[i] = i;
    return order;
  }

  public static void fillColumn(long[][] array, int index, long value) {
    for (long[] row : array)
      row[index] = value;
  }

  public static void fillColumn(int[][] array, int index, int value) {
    for (int[] row : array)
      row[index] = value;
  }

  public static long sumArray(int[] array) {
    long result = 0;
    for (int element : array)
      result += element;
    return result;
  }

  public static int[] range(int from, int to) {
    int[] result = new int[Math.max(from, to) - Math.min(from, to) + 1];
    int index = 0;
    if (to > from) {
      for (int i = from; i <= to; i++)
        result[index++] = i;
    } else {
      for (int i = from; i >= to; i--)
        result[index++] = i;
    }
    return result;
  }

  public static long multiply(int[] first, int[] second) {
    long result = 0;
    for (int i = 0; i < first.length; i++)
      result += (long) first[i] * second[i];
    return result;
  }

  public static int[] createOrder(int size) {
    int[] order = new int[size];
    for (int i = 0; i < size; i++)
      order[i] = i;
    return order;
  }

  public static int[] sort(int[] array, IntComparator comparator) {
    return sort(array, 0, array.length, comparator);
  }

  public static int[] sort(int[] array, int from, int to,
                           IntComparator comparator) {
    if (from == 0 && to == array.length)
      new IntArray(array).inPlaceSort(comparator);
    else
      new IntArray(array).subList(from, to).inPlaceSort(comparator);
    return array;
  }

  public static int[] unique(int[] array) {
    return unique(array, 0, array.length);
  }

  public static int[] unique(int[] array, int from, int to) {
    if (from == to)
      return new int[0];
    int count = 1;
    for (int i = from + 1; i < to; i++) {
      if (array[i] != array[i - 1])
        count++;
    }
    int[] result = new int[count];
    result[0] = array[from];
    int index = 1;
    for (int i = from + 1; i < to; i++) {
      if (array[i] != array[i - 1])
        result[index++] = array[i];
    }
    return result;
  }

  public static char[] unique(char[] array) {
    return unique(array, 0, array.length);
  }

  public static char[] unique(char[] array, int from, int to) {
    if (from == to)
      return new char[0];
    int count = 1;
    for (int i = from + 1; i < to; i++) {
      if (array[i] != array[i - 1])
        count++;
    }
    char[] result = new char[count];
    result[0] = array[from];
    int index = 1;
    for (int i = from + 1; i < to; i++) {
      if (array[i] != array[i - 1])
        result[index++] = array[i];
    }
    return result;
  }

  public static int maxElement(int[] array) {
    return maxElement(array, 0, array.length);
  }

  public static int maxElement(int[] array, int from, int to) {
    int result = Integer.MIN_VALUE;
    for (int i = from; i < to; i++)
      result = Math.max(result, array[i]);
    return result;
  }

  public static int[] reversePermutation(int[] permutation) {
    int[] result = new int[permutation.length];
    for (int i = 0; i < permutation.length; i++)
      result[permutation[i]] = i;
    return result;
  }

  public static void reverse(int[] array) {
    for (int i = 0, j = array.length - 1; i < j; i++, j--) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  public static void reverse(char[] array) {
    for (int i = 0, j = array.length - 1; i < j; i++, j--) {
      char temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  public static int minPosition(int[] array) {
    return minPosition(array, 0, array.length);
  }

  public static int maxPosition(int[] array) {
    return maxPosition(array, 0, array.length);
  }

  public static int minPosition(int[] array, int from, int to) {
    if (from >= to)
      return -1;
    int min = array[from];
    int result = from;
    for (int i = from + 1; i < to; i++) {
      if (array[i] < min) {
        min = array[i];
        result = i;
      }
    }
    return result;
  }

  public static int maxPosition(int[] array, int from, int to) {
    if (from >= to)
      return -1;
    int max = array[from];
    int result = from;
    for (int i = from + 1; i < to; i++) {
      if (array[i] > max) {
        max = array[i];
        result = i;
      }
    }
    return result;
  }

  public static int[] multiplyPermutations(int[] first, int[] second) {
    int count = first.length;
    int[] result = new int[count];
    for (int i = 0; i < count; i++) {
      result[i] = first[second[i]];
    }
    return result;
  }

  public static int[] compress(int[]... arrays) {
    int totalLength = 0;
    for (int[] array : arrays)
      totalLength += array.length;
    int[] all = new int[totalLength];
    int delta = 0;
    for (int[] array : arrays) {
      System.arraycopy(array, 0, all, delta, array.length);
      delta += array.length;
    }
    sort(all, IntComparator.DEFAULT);
    all = unique(all);
    for (int[] array : arrays) {
      for (int i = 0; i < array.length; i++)
        array[i] = Arrays.binarySearch(all, array[i]);
    }
    return all;
  }

  public static int minElement(int[] array) {
    return array[minPosition(array)];
  }

  public static long[] partialSums(int[] array) {
    long[] result = new long[array.length + 1];
    for (int i = 0; i < array.length; i++)
      result[i + 1] = result[i] + array[i];
    return result;
  }

  public static long[] asLong(int[] array) {
    long[] result = new long[array.length];
    for (int i = 0; i < array.length; i++)
      result[i] = array[i];
    return result;
  }

  public static int count(int[] array, int value) {
    int result = 0;
    for (int i : array) {
      if (i == value)
        result++;
    }
    return result;
  }

  public static int count(char[] array, char value) {
    int result = 0;
    for (char i : array) {
      if (i == value)
        result++;
    }
    return result;
  }

  public static int count(boolean[] array, boolean value) {
    int result = 0;
    for (boolean i : array) {
      if (i == value)
        result++;
    }
    return result;
  }

  public static int[] merge(int[] first, int[] second) {
    int[] result = new int[first.length + second.length];
    int firstIndex = 0;
    int secondIndex = 0;
    int index = 0;
    while (firstIndex < first.length && secondIndex < second.length) {
      if (first[firstIndex] < second[secondIndex])
        result[index++] = first[firstIndex++];
      else
        result[index++] = second[secondIndex++];
    }
    System.arraycopy(first, firstIndex, result, index, first.length
            - firstIndex);
    System.arraycopy(second, secondIndex, result, index, second.length
            - secondIndex);
    return result;
  }

  public static boolean nextPermutation(int[] array) {
    return new IntArray(array).nextPermutation();
  }

  public static <V> void reverse(V[] array) {
    for (int i = 0, j = array.length - 1; i < j; i++, j--) {
      V temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  public static IntComparator compareBy(final int[]... arrays) {
    return new IntComparator() {
      public int compare(int first, int second) {
        for (int[] array : arrays) {
          if (array[first] != array[second])
            return Integer.compare(array[first], array[second]);
        }
        return 0;
      }
    };
  }

  public static long minElement(long[] array) {
    return array[minPosition(array)];
  }

  public static long maxElement(long[] array) {
    return array[maxPosition(array)];
  }

  public static int minPosition(long[] array) {
    return minPosition(array, 0, array.length);
  }

  public static int maxPosition(long[] array) {
    return maxPosition(array, 0, array.length);
  }

  public static int minPosition(long[] array, int from, int to) {
    if (from >= to)
      return -1;
    long min = array[from];
    int result = from;
    for (int i = from + 1; i < to; i++) {
      if (array[i] < min) {
        min = array[i];
        result = i;
      }
    }
    return result;
  }

  public static int maxPosition(long[] array, int from, int to) {
    if (from >= to)
      return -1;
    long max = array[from];
    int result = from;
    for (int i = from + 1; i < to; i++) {
      if (array[i] > max) {
        max = array[i];
        result = i;
      }
    }
    return result;
  }
}

class BidirectionalGraph extends Graph {
  public int[] transposedEdge;

  public BidirectionalGraph(int vertexCount) {
    this(vertexCount, vertexCount);
  }

  public BidirectionalGraph(int vertexCount, int edgeCapacity) {
    super(vertexCount, 2 * edgeCapacity);
    transposedEdge = new int[2 * edgeCapacity];
  }

  public static BidirectionalGraph createGraph(int vertexCount, int[] from,
                                               int[] to) {
    BidirectionalGraph graph = new BidirectionalGraph(vertexCount,
            from.length);
    for (int i = 0; i < from.length; i++)
      graph.addSimpleEdge(from[i], to[i]);
    return graph;
  }

  public static BidirectionalGraph createWeightedGraph(int vertexCount,
                                                       int[] from, int[] to, long[] weight) {
    BidirectionalGraph graph = new BidirectionalGraph(vertexCount,
            from.length);
    for (int i = 0; i < from.length; i++)
      graph.addWeightedEdge(from[i], to[i], weight[i]);
    return graph;
  }

  public static BidirectionalGraph createFlowGraph(int vertexCount,
                                                   int[] from, int[] to, long[] capacity) {
    BidirectionalGraph graph = new BidirectionalGraph(vertexCount,
            from.length * 2);
    for (int i = 0; i < from.length; i++)
      graph.addFlowEdge(from[i], to[i], capacity[i]);
    return graph;
  }

  public static BidirectionalGraph createFlowWeightedGraph(int vertexCount,
                                                           int[] from, int[] to, long[] weight, long[] capacity) {
    BidirectionalGraph graph = new BidirectionalGraph(vertexCount,
            from.length * 2);
    for (int i = 0; i < from.length; i++)
      graph.addFlowWeightedEdge(from[i], to[i], weight[i], capacity[i]);
    return graph;
  }

  @Override
  public int addEdge(int fromID, int toID, long weight, long capacity,
                     int reverseEdge) {
    int lastEdgeCount = edgeCount;
    super.addEdge(fromID, toID, weight, capacity, reverseEdge);
    super.addEdge(toID, fromID, weight, capacity, reverseEdge == -1 ? -1
            : reverseEdge + 1);
    this.transposedEdge[lastEdgeCount] = lastEdgeCount + 1;
    this.transposedEdge[lastEdgeCount + 1] = lastEdgeCount;
    return lastEdgeCount;
  }

  @Override
  protected int entriesPerEdge() {
    return 2;
  }

  @Override
  public final int transposed(int id) {
    return transposedEdge[id];
  }

  @Override
  protected void ensureEdgeCapacity(int size) {
    if (size > edgeCapacity()) {
      super.ensureEdgeCapacity(size);
      transposedEdge = resize(transposedEdge, edgeCapacity());
    }
  }
}

class Graph {
  public static final int REMOVED_BIT = 0;

  protected int vertexCount;
  protected int edgeCount;

  private int[] firstOutbound;
  private int[] firstInbound;

  private Edge[] edges;
  private int[] nextInbound;
  private int[] nextOutbound;
  private int[] from;
  private int[] to;
  private long[] weight;
  private long[] capacity;
  private int[] reverseEdge;
  private int[] flags;

  public Graph(int vertexCount) {
    this(vertexCount, vertexCount);
  }

  public Graph(int vertexCount, int edgeCapacity) {
    this.vertexCount = vertexCount;
    firstOutbound = new int[vertexCount];
    Arrays.fill(firstOutbound, -1);

    from = new int[edgeCapacity];
    to = new int[edgeCapacity];
    nextOutbound = new int[edgeCapacity];
    flags = new int[edgeCapacity];
  }

  public static Graph createGraph(int vertexCount, int[] from, int[] to) {
    Graph graph = new Graph(vertexCount, from.length);
    for (int i = 0; i < from.length; i++)
      graph.addSimpleEdge(from[i], to[i]);
    return graph;
  }

  public static Graph createWeightedGraph(int vertexCount, int[] from,
                                          int[] to, long[] weight) {
    Graph graph = new Graph(vertexCount, from.length);
    for (int i = 0; i < from.length; i++)
      graph.addWeightedEdge(from[i], to[i], weight[i]);
    return graph;
  }

  public static Graph createFlowGraph(int vertexCount, int[] from, int[] to,
                                      long[] capacity) {
    Graph graph = new Graph(vertexCount, from.length * 2);
    for (int i = 0; i < from.length; i++)
      graph.addFlowEdge(from[i], to[i], capacity[i]);
    return graph;
  }

  public static Graph createFlowWeightedGraph(int vertexCount, int[] from,
                                              int[] to, long[] weight, long[] capacity) {
    Graph graph = new Graph(vertexCount, from.length * 2);
    for (int i = 0; i < from.length; i++)
      graph.addFlowWeightedEdge(from[i], to[i], weight[i], capacity[i]);
    return graph;
  }

  public static Graph createTree(int[] parent) {
    Graph graph = new Graph(parent.length + 1, parent.length);
    for (int i = 0; i < parent.length; i++)
      graph.addSimpleEdge(parent[i], i + 1);
    return graph;
  }

  public int addEdge(int fromID, int toID, long weight, long capacity,
                     int reverseEdge) {
    ensureEdgeCapacity(edgeCount + 1);
    if (firstOutbound[fromID] != -1)
      nextOutbound[edgeCount] = firstOutbound[fromID];
    else
      nextOutbound[edgeCount] = -1;
    firstOutbound[fromID] = edgeCount;
    if (firstInbound != null) {
      if (firstInbound[toID] != -1)
        nextInbound[edgeCount] = firstInbound[toID];
      else
        nextInbound[edgeCount] = -1;
      firstInbound[toID] = edgeCount;
    }
    this.from[edgeCount] = fromID;
    this.to[edgeCount] = toID;
    if (capacity != 0) {
      if (this.capacity == null)
        this.capacity = new long[from.length];
      this.capacity[edgeCount] = capacity;
    }
    if (weight != 0) {
      if (this.weight == null)
        this.weight = new long[from.length];
      this.weight[edgeCount] = weight;
    }
    if (reverseEdge != -1) {
      if (this.reverseEdge == null) {
        this.reverseEdge = new int[from.length];
        Arrays.fill(this.reverseEdge, 0, edgeCount, -1);
      }
      this.reverseEdge[edgeCount] = reverseEdge;
    }
    if (edges != null)
      edges[edgeCount] = createEdge(edgeCount);
    return edgeCount++;
  }

  protected final GraphEdge createEdge(int id) {
    return new GraphEdge(id);
  }

  public final int addFlowWeightedEdge(int from, int to, long weight,
                                       long capacity) {
    if (capacity == 0) {
      return addEdge(from, to, weight, 0, -1);
    } else {
      int lastEdgeCount = edgeCount;
      addEdge(to, from, -weight, 0, lastEdgeCount + entriesPerEdge());
      return addEdge(from, to, weight, capacity, lastEdgeCount);
    }
  }

  protected int entriesPerEdge() {
    return 1;
  }

  public final int addFlowEdge(int from, int to, long capacity) {
    return addFlowWeightedEdge(from, to, 0, capacity);
  }

  public final int addWeightedEdge(int from, int to, long weight) {
    return addFlowWeightedEdge(from, to, weight, 0);
  }

  public final int addSimpleEdge(int from, int to) {
    return addWeightedEdge(from, to, 0);
  }

  public final int vertexCount() {
    return vertexCount;
  }

  public final int edgeCount() {
    return edgeCount;
  }

  protected final int edgeCapacity() {
    return from.length;
  }

  public final Edge edge(int id) {
    initEdges();
    return edges[id];
  }

  public final int firstOutbound(int vertex) {
    int id = firstOutbound[vertex];
    while (id != -1 && isRemoved(id))
      id = nextOutbound[id];
    return id;
  }

  public final int nextOutbound(int id) {
    id = nextOutbound[id];
    while (id != -1 && isRemoved(id))
      id = nextOutbound[id];
    return id;
  }

  public final int firstInbound(int vertex) {
    initInbound();
    int id = firstInbound[vertex];
    while (id != -1 && isRemoved(id))
      id = nextInbound[id];
    return id;
  }

  public final int nextInbound(int id) {
    initInbound();
    id = nextInbound[id];
    while (id != -1 && isRemoved(id))
      id = nextInbound[id];
    return id;
  }

  public final int source(int id) {
    return from[id];
  }

  public final int destination(int id) {
    return to[id];
  }

  public final long weight(int id) {
    if (weight == null)
      return 0;
    return weight[id];
  }

  public final long capacity(int id) {
    if (capacity == null)
      return 0;
    return capacity[id];
  }

  public final long flow(int id) {
    if (reverseEdge == null)
      return 0;
    return capacity[reverseEdge[id]];
  }

  public final void pushFlow(int id, long flow) {
    if (flow == 0)
      return;
    if (flow > 0) {
      if (capacity(id) < flow)
        throw new IllegalArgumentException("Not enough capacity");
    } else {
      if (flow(id) < -flow)
        throw new IllegalArgumentException("Not enough capacity");
    }
    capacity[id] -= flow;
    capacity[reverseEdge[id]] += flow;
  }

  public int transposed(int id) {
    return -1;
  }

  public final int reverse(int id) {
    if (reverseEdge == null)
      return -1;
    return reverseEdge[id];
  }

  public final void addVertices(int count) {
    ensureVertexCapacity(vertexCount + count);
    Arrays.fill(firstOutbound, vertexCount, vertexCount + count, -1);
    if (firstInbound != null)
      Arrays.fill(firstInbound, vertexCount, vertexCount + count, -1);
    vertexCount += count;
  }

  protected final void initEdges() {
    if (edges == null) {
      edges = new Edge[from.length];
      for (int i = 0; i < edgeCount; i++)
        edges[i] = createEdge(i);
    }
  }

  public final void removeVertex(int vertex) {
    int id = firstOutbound[vertex];
    while (id != -1) {
      removeEdge(id);
      id = nextOutbound[id];
    }
    initInbound();
    id = firstInbound[vertex];
    while (id != -1) {
      removeEdge(id);
      id = nextInbound[id];
    }
  }

  private void initInbound() {
    if (firstInbound == null) {
      firstInbound = new int[firstOutbound.length];
      Arrays.fill(firstInbound, 0, vertexCount, -1);
      nextInbound = new int[from.length];
      for (int i = 0; i < edgeCount; i++) {
        nextInbound[i] = firstInbound[to[i]];
        firstInbound[to[i]] = i;
      }
    }
  }

  public final boolean flag(int id, int bit) {
    return (flags[id] >> bit & 1) != 0;
  }

  public final void setFlag(int id, int bit) {
    flags[id] |= 1 << bit;
  }

  public final void removeFlag(int id, int bit) {
    flags[id] &= -1 - (1 << bit);
  }

  public final void removeEdge(int id) {
    setFlag(id, REMOVED_BIT);
  }

  public final void restoreEdge(int id) {
    removeFlag(id, REMOVED_BIT);
  }

  public final boolean isRemoved(int id) {
    return flag(id, REMOVED_BIT);
  }

  public final Iterable<Edge> outbound(final int id) {
    initEdges();
    return new Iterable<Edge>() {
      public Iterator<Edge> iterator() {
        return new EdgeIterator(id, firstOutbound, nextOutbound);
      }
    };
  }

  public final Iterable<Edge> inbound(final int id) {
    initEdges();
    initInbound();
    return new Iterable<Edge>() {
      public Iterator<Edge> iterator() {
        return new EdgeIterator(id, firstInbound, nextInbound);
      }
    };
  }

  protected void ensureEdgeCapacity(int size) {
    if (from.length < size) {
      int newSize = Math.max(size, 2 * from.length);
      if (edges != null)
        edges = resize(edges, newSize);
      from = resize(from, newSize);
      to = resize(to, newSize);
      nextOutbound = resize(nextOutbound, newSize);
      if (nextInbound != null)
        nextInbound = resize(nextInbound, newSize);
      if (weight != null)
        weight = resize(weight, newSize);
      if (capacity != null)
        capacity = resize(capacity, newSize);
      if (reverseEdge != null)
        reverseEdge = resize(reverseEdge, newSize);
      flags = resize(flags, newSize);
    }
  }

  private void ensureVertexCapacity(int size) {
    if (firstOutbound.length < size) {
      int newSize = Math.max(size, 2 * from.length);
      firstOutbound = resize(firstOutbound, newSize);
      if (firstInbound != null)
        firstInbound = resize(firstInbound, newSize);
    }
  }

  protected final int[] resize(int[] array, int size) {
    int[] newArray = new int[size];
    System.arraycopy(array, 0, newArray, 0, array.length);
    return newArray;
  }

  private long[] resize(long[] array, int size) {
    long[] newArray = new long[size];
    System.arraycopy(array, 0, newArray, 0, array.length);
    return newArray;
  }

  private Edge[] resize(Edge[] array, int size) {
    Edge[] newArray = new Edge[size];
    System.arraycopy(array, 0, newArray, 0, array.length);
    return newArray;
  }

  public final boolean isSparse() {
    return vertexCount == 0 || edgeCount * 20 / vertexCount <= vertexCount;
  }

  protected class GraphEdge implements Edge {
    protected int id;

    protected GraphEdge(int id) {
      this.id = id;
    }

    public int getSource() {
      return source(id);
    }

    public int getDestination() {
      return destination(id);
    }

    public long getWeight() {
      return weight(id);
    }

    public long getCapacity() {
      return capacity(id);
    }

    public long getFlow() {
      return flow(id);
    }

    public void pushFlow(long flow) {
      Graph.this.pushFlow(id, flow);
    }

    public boolean getFlag(int bit) {
      return flag(id, bit);
    }

    public void setFlag(int bit) {
      Graph.this.setFlag(id, bit);
    }

    public void removeFlag(int bit) {
      Graph.this.removeFlag(id, bit);
    }

    public int getTransposedID() {
      return transposed(id);
    }

    public Edge getTransposedEdge() {
      int reverseID = getTransposedID();
      if (reverseID == -1)
        return null;
      initEdges();
      return edge(reverseID);
    }

    public int getReverseID() {
      return reverse(id);
    }

    public Edge getReverseEdge() {
      int reverseID = getReverseID();
      if (reverseID == -1)
        return null;
      initEdges();
      return edge(reverseID);
    }

    public int getID() {
      return id;
    }

    public void remove() {
      removeEdge(id);
    }

    public void restore() {
      restoreEdge(id);
    }
  }

  public class EdgeIterator implements Iterator<Edge> {
    private final int[] next;
    private int edgeID;
    private int lastID = -1;

    public EdgeIterator(int id, int[] first, int[] next) {
      this.next = next;
      edgeID = nextEdge(first[id]);
    }

    private int nextEdge(int id) {
      while (id != -1 && isRemoved(id))
        id = next[id];
      return id;
    }

    public boolean hasNext() {
      return edgeID != -1;
    }

    public Edge next() {
      if (edgeID == -1)
        throw new NoSuchElementException();
      lastID = edgeID;
      edgeID = nextEdge(next[lastID]);
      return edges[lastID];
    }

    public void remove() {
      if (lastID == -1)
        throw new IllegalStateException();
      removeEdge(lastID);
      lastID = -1;
    }
  }

}

class MiscUtils {
  public static final int[] DX4 = {1, 0, -1, 0};
  public static final int[] DY4 = {0, -1, 0, 1};
  public static final int[] DX8 = {1, 1, 1, 0, -1, -1, -1, 0};
  public static final int[] DY8 = {-1, 0, 1, 1, 1, 0, -1, -1};
  public static final int[] DX_KNIGHT = {2, 1, -1, -2, -2, -1, 1, 2};
  public static final int[] DY_KNIGHT = {1, 2, 2, 1, -1, -2, -2, -1};

  private static final String[] ROMAN_TOKENS = {"M", "CM", "D", "CD", "C",
          "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
  private static final int[] ROMAN_VALUES = {1000, 900, 500, 400, 100, 90,
          50, 40, 10, 9, 5, 4, 1};

  public static long josephProblem(long n, int k) {
    if (n == 1)
      return 0;
    if (k == 1)
      return n - 1;
    if (k > n)
      return (josephProblem(n - 1, k) + k) % n;
    long count = n / k;
    long result = josephProblem(n - count, k);
    result -= n % k;
    if (result < 0)
      result += n;
    else
      result += result / (k - 1);
    return result;
  }

  public static boolean isValidCell(int row, int column, int rowCount,
                                    int columnCount) {
    return row >= 0 && row < rowCount && column >= 0
            && column < columnCount;
  }

  public static IntList getPath(int[] last, int destination) {
    IntList path = new IntArrayList();
    while (destination != -1) {
      path.add(destination);
      destination = last[destination];
    }
    path.inPlaceReverse();
    return path;
  }

  public static IntList getPath(int[][] lastIndex, int[][] lastPathNumber,
                                int destination, int pathNumber) {
    IntList path = new IntArrayList();
    while (destination != -1 || pathNumber != 0) {
      path.add(destination);
      int nextDestination = lastIndex[destination][pathNumber];
      pathNumber = lastPathNumber[destination][pathNumber];
      destination = nextDestination;
    }
    path.inPlaceReverse();
    return path;
  }

  public static long maximalRectangleSum(long[][] array) {
    int n = array.length;
    int m = array[0].length;
    long[][] partialSums = new long[n + 1][m + 1];
    for (int i = 0; i < n; i++) {
      long rowSum = 0;
      for (int j = 0; j < m; j++) {
        rowSum += array[i][j];
        partialSums[i + 1][j + 1] = partialSums[i][j + 1] + rowSum;
      }
    }
    long result = Long.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = i; j < m; j++) {
        long minPartialSum = 0;
        for (int k = 1; k <= n; k++) {
          long current = partialSums[k][j + 1] - partialSums[k][i];
          result = Math.max(result, current - minPartialSum);
          minPartialSum = Math.min(minPartialSum, current);
        }
      }
    }
    return result;
  }

  public static int parseIP(String ip) {
    String[] components = ip.split("[.]");
    int result = 0;
    for (int i = 0; i < 4; i++)
      result += (1 << (24 - 8 * i)) * Integer.parseInt(components[i]);
    return result;
  }

  public static String buildIP(int mask) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      if (i != 0)
        result.append('.');
      result.append(mask >> (24 - 8 * i) & 255);
    }
    return result.toString();
  }

  public static long binarySearch(long from, long to,
                                  Function<Long, Boolean> function) {
    while (from < to) {
      long argument = from + (to - from) / 2;
      if (function.value(argument))
        to = argument;
      else
        from = argument + 1;
    }
    return from;
  }

  public static <T> boolean equals(T first, T second) {
    return first == null && second == null || first != null
            && first.equals(second);
  }

  public static boolean isVowel(char ch) {
    ch = Character.toUpperCase(ch);
    return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
            || ch == 'Y';
  }

  public static boolean isStrictVowel(char ch) {
    ch = Character.toUpperCase(ch);
    return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
  }

  public static String convertToRoman(int number) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < ROMAN_TOKENS.length; i++) {
      while (number >= ROMAN_VALUES[i]) {
        number -= ROMAN_VALUES[i];
        result.append(ROMAN_TOKENS[i]);
      }
    }
    return result.toString();
  }

  public static int convertFromRoman(String number) {
    int result = 0;
    for (int i = 0; i < ROMAN_TOKENS.length; i++) {
      while (number.startsWith(ROMAN_TOKENS[i])) {
        number = number.substring(ROMAN_TOKENS[i].length());
        result += ROMAN_VALUES[i];
      }
    }
    return result;
  }

  public static int distance(int x1, int y1, int x2, int y2) {
    int dx = x1 - x2;
    int dy = y1 - y2;
    return dx * dx + dy * dy;
  }

  public static <T extends Comparable<T>> T min(T first, T second) {
    if (first.compareTo(second) <= 0)
      return first;
    return second;
  }

  public static <T extends Comparable<T>> T max(T first, T second) {
    if (first.compareTo(second) <= 0)
      return second;
    return first;
  }

  public static void decreaseByOne(int[]... arrays) {
    for (int[] array : arrays) {
      for (int i = 0; i < array.length; i++)
        array[i]--;
    }
  }

  public static int[] getIntArray(String s) {
    String[] tokens = s.split(" ");
    int[] result = new int[tokens.length];
    for (int i = 0; i < result.length; i++)
      result[i] = Integer.parseInt(tokens[i]);
    return result;
  }
}

class IntArrayList extends IntList {
  private int[] array;
  private int size;

  public IntArrayList() {
    this(10);
  }

  public IntArrayList(int capacity) {
    array = new int[capacity];
  }

  public IntArrayList(IntList list) {
    this(list.size());
    addAll(list);
  }

  @Override
  public int get(int index) {
    if (index >= size)
      throw new IndexOutOfBoundsException();
    return array[index];
  }

  @Override
  public void set(int index, int value) {
    if (index >= size)
      throw new IndexOutOfBoundsException();
    array[index] = value;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void add(int value) {
    ensureCapacity(size + 1);
    array[size++] = value;
  }

  public void ensureCapacity(int newCapacity) {
    if (newCapacity > array.length) {
      int[] newArray = new int[Math.max(newCapacity, array.length << 1)];
      System.arraycopy(array, 0, newArray, 0, size);
      array = newArray;
    }
  }

  @Override
  public int[] toArray() {
    int[] array = new int[size];
    System.arraycopy(this.array, 0, array, 0, size);
    return array;
  }

  @Override
  public int popBack() {
    return array[--size];
  }
}

class IntArray extends IntList {
  private final int[] array;

  public IntArray(int[] array) {
    this.array = array;
  }

  public IntArray(IntCollection collection) {
    array = new int[collection.size()];
    int i = 0;
    for (IntIterator iterator = collection.iterator(); iterator.isValid(); iterator
            .advance())
      array[i++] = iterator.value();
  }

  @Override
  public int get(int index) {
    return array[index];
  }

  @Override
  public void set(int index, int value) {
    array[index] = value;
  }

  @Override
  public int size() {
    return array.length;
  }

  @Override
  public void add(int value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int[] toArray() {
    return array;
  }
}

abstract class IntList extends IntCollection implements Comparable<IntList> {
  private static final int INSERTION_THRESHOLD = 16;
  private static IntList EMPTY_LIST;

  public static IntList emptyList() {
    if (EMPTY_LIST == null)
      EMPTY_LIST = new IntArray(new int[0]);
    return EMPTY_LIST;
  }

  public abstract int get(int index);

  public abstract void set(int index, int value);

  @Override
  public IntIterator iterator() {
    return new IntIterator() {
      private int size = size();
      private int index = 0;

      public int value() throws NoSuchElementException {
        if (!isValid())
          throw new NoSuchElementException();
        return get(index);
      }

      public void advance() throws NoSuchElementException {
        if (!isValid())
          throw new NoSuchElementException();
        index++;
      }

      public boolean isValid() {
        return index < size;
      }
    };
  }

  @Override
  public void remove(int value) {
    throw new UnsupportedOperationException();
  }

  public int find(int value) {
    int size = size();
    for (int i = 0; i < size; i++) {
      if (get(i) == value)
        return i;
    }
    return -1;
  }

  public int findLast(int value) {
    int size = size();
    for (int i = size - 1; i >= 0; i--) {
      if (get(i) == value)
        return i;
    }
    return -1;
  }

  public boolean nextPermutation() {
    return nextPermutation(IntComparator.DEFAULT);
  }

  private boolean nextPermutation(IntComparator comparator) {
    int size = size();
    int last = get(size - 1);
    for (int i = size - 2; i >= 0; i--) {
      int current = get(i);
      if (comparator.compare(last, current) > 0) {
        for (int j = size - 1; j > i; j--) {
          if (comparator.compare(get(j), current) > 0) {
            swap(i, j);
            subList(i + 1, size).inPlaceReverse();
            return true;
          }
        }
      }
      last = current;
    }
    return false;
  }

  public void inPlaceReverse() {
    for (int i = 0, j = size() - 1; i < j; i++, j--)
      swap(i, j);
  }

  public IntList subList(final int from, final int to) {
    return new SubList(from, to);
  }

  private void swap(int first, int second) {
    if (first == second)
      return;
    int temp = get(first);
    set(first, get(second));
    set(second, temp);
  }

  public IntSortedList inPlaceSort() {
    return inPlaceSort(IntComparator.DEFAULT);
  }

  public IntSortedList inPlaceSort(IntComparator comparator) {
    quickSort(0, size() - 1,
            (Integer.bitCount(Integer.highestOneBit(size()) - 1) * 5) >> 1,
            comparator);
    return new IntSortedArray(this, comparator);
  }

  private void quickSort(int from, int to, int remaining,
                         IntComparator comparator) {
    if (to - from < INSERTION_THRESHOLD) {
      insertionSort(from, to, comparator);
      return;
    }
    if (remaining == 0) {
      heapSort(from, to, comparator);
      return;
    }
    remaining--;
    int pivotIndex = (from + to) >> 1;
    int pivot = get(pivotIndex);
    swap(pivotIndex, to);
    int storeIndex = from;
    int equalIndex = to;
    for (int i = from; i < equalIndex; i++) {
      int value = comparator.compare(get(i), pivot);
      if (value < 0)
        swap(storeIndex++, i);
      else if (value == 0)
        swap(--equalIndex, i--);
    }
    quickSort(from, storeIndex - 1, remaining, comparator);
    for (int i = equalIndex; i <= to; i++)
      swap(storeIndex++, i);
    quickSort(storeIndex, to, remaining, comparator);
  }

  private void heapSort(int from, int to, IntComparator comparator) {
    for (int i = (to + from - 1) >> 1; i >= from; i--)
      siftDown(i, to, comparator, from);
    for (int i = to; i > from; i--) {
      swap(from, i);
      siftDown(from, i - 1, comparator, from);
    }
  }

  private void siftDown(int start, int end, IntComparator comparator,
                        int delta) {
    int value = get(start);
    while (true) {
      int child = ((start - delta) << 1) + 1 + delta;
      if (child > end)
        return;
      int childValue = get(child);
      if (child + 1 <= end) {
        int otherValue = get(child + 1);
        if (comparator.compare(otherValue, childValue) > 0) {
          child++;
          childValue = otherValue;
        }
      }
      if (comparator.compare(value, childValue) >= 0)
        return;
      swap(start, child);
      start = child;
    }
  }

  private void insertionSort(int from, int to, IntComparator comparator) {
    for (int i = from + 1; i <= to; i++) {
      int value = get(i);
      for (int j = i - 1; j >= from; j--) {
        if (comparator.compare(get(j), value) <= 0)
          break;
        swap(j, j + 1);
      }
    }
  }

  public IntSortedList sort() {
    return sort(IntComparator.DEFAULT);
  }

  public IntSortedList sort(IntComparator comparator) {
    return new IntArray(this).inPlaceSort(comparator);
  }

  public int back() {
    return get(size() - 1);
  }

  public int popBack() {
    throw new UnsupportedOperationException();
  }

  public int hashCode() {
    int hashCode = 1;
    for (IntIterator i = iterator(); i.isValid(); i.advance())
      hashCode = 31 * hashCode + i.value();
    return hashCode;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof IntList))
      return false;
    IntList list = (IntList) obj;
    if (list.size() != size())
      return false;
    IntIterator i = iterator();
    IntIterator j = list.iterator();
    while (i.isValid()) {
      if (i.value() != j.value())
        return false;
      i.advance();
      j.advance();
    }
    return true;
  }

  public int compareTo(IntList o) {
    IntIterator i = iterator();
    IntIterator j = o.iterator();
    while (true) {
      if (i.isValid()) {
        if (j.isValid()) {
          if (i.value() != j.value()) {
            if (i.value() < j.value())
              return -1;
            else
              return 1;
          }
        } else
          return 1;
      } else {
        if (j.isValid())
          return -1;
        else
          return 0;
      }
      i.advance();
      j.advance();
    }
  }

  private class SubList extends IntList {
    private final int to;
    private final int from;
    private int size;

    public SubList(int from, int to) {
      this.to = to;
      this.from = from;
      size = to - from;
    }

    @Override
    public int get(int index) {
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException();
      return IntList.this.get(index + from);
    }

    @Override
    public void set(int index, int value) {
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException();
      IntList.this.set(index + from, value);
    }

    @Override
    public int size() {
      return size;
    }

    @Override
    public void add(int value) {
      throw new UnsupportedOperationException();
    }
  }
}

abstract class IntCollection {
  public abstract IntIterator iterator();

  public abstract int size();

  public abstract void add(int value);

  public abstract void remove(int value);

  public void forEach(IntTask task) {
    for (IntIterator iterator = iterator(); iterator.isValid(); iterator
            .advance())
      task.process(iterator.value());
  }

  public boolean contains(int value) {
    for (IntIterator iterator = iterator(); iterator.isValid(); iterator
            .advance()) {
      if (iterator.value() == value)
        return true;
    }
    return false;
  }

  public int count(int value) {
    int result = 0;
    for (IntIterator iterator = iterator(); iterator.isValid(); iterator
            .advance()) {
      if (iterator.value() == value)
        result++;
    }
    return result;
  }

  public int min() {
    if (size() == 0)
      throw new NoSuchElementException();
    int result = Integer.MAX_VALUE;
    for (IntIterator iterator = iterator(); iterator.isValid(); iterator
            .advance())
      result = Math.min(result, iterator.value());
    return result;
  }

  public int max() {
    if (size() == 0)
      throw new NoSuchElementException();
    int result = Integer.MIN_VALUE;
    for (IntIterator iterator = iterator(); iterator.isValid(); iterator
            .advance())
      result = Math.max(result, iterator.value());
    return result;
  }

  public IntCollection union(final IntCollection other) {
    return new IntCollection() {
      @Override
      public IntIterator iterator() {
        return new IntIterator() {
          private IntIterator first = IntCollection.this.iterator();
          private IntIterator second;

          public int value() throws NoSuchElementException {
            if (first.isValid())
              return first.value();
            return second.value();
          }

          public void advance() throws NoSuchElementException {
            if (first.isValid()) {
              first.advance();
              if (!first.isValid())
                second = other.iterator();
            } else
              second.advance();
          }

          public boolean isValid() {
            return first.isValid() || second.isValid();
          }
        };
      }

      @Override
      public int size() {
        return IntCollection.this.size() + other.size();
      }

      @Override
      public void add(int value) {
        throw new UnsupportedOperationException();
      }

      @Override
      public void remove(int value) {
        throw new UnsupportedOperationException();
      }
    };
  }

  public IntCollection map(final IntFunction function) {
    return new IntCollection() {
      @Override
      public IntIterator iterator() {
        return new IntIterator() {
          private IntIterator iterator = IntCollection.this
                  .iterator();

          public int value() throws NoSuchElementException {
            return function.value(iterator.value());
          }

          public void advance() throws NoSuchElementException {
            iterator().advance();
          }

          public boolean isValid() {
            return iterator().isValid();
          }
        };
      }

      @Override
      public int size() {
        return IntCollection.this.size();
      }

      @Override
      public void add(int value) {
        throw new UnsupportedOperationException();
      }

      @Override
      public void remove(int value) {
        throw new UnsupportedOperationException();
      }
    };
  }

  public int[] toArray() {
    int size = size();
    int[] array = new int[size];
    int i = 0;
    for (IntIterator iterator = iterator(); iterator.isValid(); iterator
            .advance())
      array[i++] = iterator.value();
    return array;
  }

  public long sum() {
    long result = 0;
    for (IntIterator iterator = iterator(); iterator.isValid(); iterator
            .advance())
      result += iterator.value();
    return result;
  }

  public void addAll(IntCollection values) {
    for (IntIterator it = values.iterator(); it.isValid(); it.advance()) {
      add(it.value());
    }
  }

  public void removeAll(IntCollection values) {
    for (IntIterator it = values.iterator(); it.isValid(); it.advance()) {
      remove(it.value());
    }
  }

  public void retainAll(IntCollection values) {
    for (IntIterator it = iterator(); it.isValid(); it.advance()) {
      if (!values.contains(it.value())) {
        remove(it.value());
      }
    }
  }
}

abstract class IntSortedList extends IntList {
  protected final IntComparator comparator;

  protected IntSortedList(IntComparator comparator) {
    this.comparator = comparator;
  }

  @Override
  public void set(int index, int value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void add(int value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public IntSortedList inPlaceSort(IntComparator comparator) {
    if (comparator == this.comparator)
      return this;
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean contains(int value) {
    int index = lowerBound(value);
    return index != size() && get(index) == value;
  }

  public int lowerBound(int value) {
    int left = 0;
    int right = size();
    while (left < right) {
      int middle = (left + right) >> 1;
      if (comparator.compare(get(middle), value) >= 0)
        right = middle;
      else
        left = middle + 1;
    }
    return left;
  }

  public int upperBound(int value) {
    int left = 0;
    int right = size();
    while (left < right) {
      int middle = (left + right) >> 1;
      if (comparator.compare(get(middle), value) > 0)
        right = middle;
      else
        left = middle + 1;
    }
    return left;
  }

  protected void ensureSorted() {
    int size = size();
    if (size == 0)
      return;
    int last = get(0);
    for (int i = 1; i < size; i++) {
      int current = get(i);
      if (comparator.compare(last, current) > 0)
        throw new IllegalArgumentException();
      last = current;
    }
  }

  @Override
  public IntSortedList subList(final int from, final int to) {
    return new IntSortedList(comparator) {
      private int size = to - from;

      @Override
      public int get(int index) {
        if (index < 0 || index >= size)
          throw new IndexOutOfBoundsException();
        return IntSortedList.this.get(index + from);
      }

      @Override
      public int size() {
        return size;
      }
    };
  }
}

class IntSortedArray extends IntSortedList {
  private final int[] array;

  public IntSortedArray(int[] array) {
    this(array, IntComparator.DEFAULT);
  }

  public IntSortedArray(IntCollection collection) {
    this(collection, IntComparator.DEFAULT);
  }

  public IntSortedArray(int[] array, IntComparator comparator) {
    super(comparator);
    this.array = array;
    ensureSorted();
  }

  public IntSortedArray(IntCollection collection, IntComparator comparator) {
    super(comparator);
    array = new int[collection.size()];
    int i = 0;
    for (IntIterator iterator = collection.iterator(); iterator.isValid(); iterator
            .advance())
      array[i++] = iterator.value();
    ensureSorted();
  }

  @Override
  public int get(int index) {
    return array[index];
  }

  @Override
  public int size() {
    return array.length;
  }
}

class IntegerUtils {
  public static long gcd(long a, long b) {
    a = Math.abs(a);
    b = Math.abs(b);
    while (b != 0) {
      long temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static int[] generatePrimes(int upTo) {
    int[] isPrime = generateBitPrimalityTable(upTo);
    IntList primes = new IntArrayList();
    for (int i = 0; i < upTo; i++) {
      if ((isPrime[i >> 5] >>> (i & 31) & 1) == 1)
        primes.add(i);
    }
    return primes.toArray();
  }

  public static boolean[] generatePrimalityTable(int upTo) {
    boolean[] isPrime = new boolean[upTo];
    if (upTo < 2)
      return isPrime;
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i < upTo; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j < upTo; j += i)
          isPrime[j] = false;
      }
    }
    return isPrime;
  }

  public static int[] generateBitPrimalityTable(int upTo) {
    int[] isPrime = new int[(upTo + 31) >> 5];
    if (upTo < 2)
      return isPrime;
    Arrays.fill(isPrime, -1);
    isPrime[0] &= -4;
    for (int i = 2; i * i < upTo; i++) {
      if ((isPrime[i >> 5] >>> (i & 31) & 1) == 1) {
        for (int j = i * i; j < upTo; j += i)
          isPrime[j >> 5] &= -1 - (1 << (j & 31));
      }
    }
    return isPrime;
  }

  public static int[] generateDivisorTable(int upTo) {
    int[] divisor = new int[upTo];
    for (int i = 1; i < upTo; i++)
      divisor[i] = i;
    for (int i = 2; i * i < upTo; i++) {
      if (divisor[i] == i) {
        for (int j = i * i; j < upTo; j += i)
          divisor[j] = i;
      }
    }
    return divisor;
  }

  public static long powerInFactorial(long n, long p) {
    long result = 0;
    while (n != 0) {
      result += n /= p;
    }
    return result;
  }

  public static int sumDigits(CharSequence number) {
    int result = 0;
    for (int i = number.length() - 1; i >= 0; i--)
      result += digitValue(number.charAt(i));
    return result;
  }

  public static int digitValue(char digit) {
    if (Character.isDigit(digit))
      return digit - '0';
    if (Character.isUpperCase(digit))
      return digit + 10 - 'A';
    return digit + 10 - 'a';
  }

  public static int longCompare(long a, long b) {
    if (a < b)
      return -1;
    if (a > b)
      return 1;
    return 0;
  }

  public static long[][] generateBinomialCoefficients(int n) {
    long[][] result = new long[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      result[i][0] = 1;
      for (int j = 1; j <= i; j++)
        result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
    }
    return result;
  }

  public static long[][] generateBinomialCoefficients(int n, long module) {
    long[][] result = new long[n + 1][n + 1];
    if (module == 1)
      return result;
    for (int i = 0; i <= n; i++) {
      result[i][0] = 1;
      for (int j = 1; j <= i; j++) {
        result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
        if (result[i][j] >= module)
          result[i][j] -= module;
      }
    }
    return result;
  }

  public static long[] generateBinomialRow(int n, long module) {
    long[] result = generateReverse(n + 1, module);
    result[0] = 1;
    for (int i = 1; i <= n; i++)
      result[i] = result[i - 1] * (n - i + 1) % module * result[i]
              % module;
    return result;
  }

  public static int[] representationInBase(long number, int base) {
    long basePower = base;
    int exponent = 1;
    while (number >= basePower) {
      basePower *= base;
      exponent++;
    }
    int[] representation = new int[exponent];
    for (int i = 0; i < exponent; i++) {
      basePower /= base;
      representation[i] = (int) (number / basePower);
      number %= basePower;
    }
    return representation;
  }

  public static int trueDivide(int a, int b) {
    return (a - trueMod(a, b)) / b;
  }

  public static long trueDivide(long a, long b) {
    return (a - trueMod(a, b)) / b;
  }

  public static int trueMod(int a, int b) {
    a %= b;
    a += b;
    a %= b;
    return a;
  }

  public static long trueMod(long a, long b) {
    a %= b;
    a += b;
    a %= b;
    return a;
  }

  public static long factorial(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++)
      result *= i;
    return result;
  }

  public static long factorial(int n, long mod) {
    long result = 1;
    for (int i = 2; i <= n; i++)
      result = result * i % mod;
    return result % mod;
  }

  public static List<Pair<Long, Integer>> factorize(long number) {
    List<Pair<Long, Integer>> result = new ArrayList<Pair<Long, Integer>>();
    for (long i = 2; i * i <= number; i++) {
      if (number % i == 0) {
        int power = 0;
        do {
          power++;
          number /= i;
        } while (number % i == 0);
        result.add(Pair.makePair(i, power));
      }
    }
    if (number != 1)
      result.add(Pair.makePair(number, 1));
    return result;
  }

  public static List<Long> getDivisors(long number) {
    List<Pair<Long, Integer>> primeDivisors = factorize(number);
    return getDivisorsImpl(primeDivisors, 0, 1, new ArrayList<Long>());
  }

  private static List<Long> getDivisorsImpl(
          List<Pair<Long, Integer>> primeDivisors, int index, long current,
          List<Long> result) {
    if (index == primeDivisors.size()) {
      result.add(current);
      return result;
    }
    long p = primeDivisors.get(index).first;
    int power = primeDivisors.get(index).second;
    for (int i = 0; i <= power; i++) {
      getDivisorsImpl(primeDivisors, index + 1, current, result);
      current *= p;
    }
    return result;
  }

  public static long power(long base, long exponent) {
    if (exponent == 0)
      return 1;
    long result = power(base, exponent >> 1);
    result = result * result;
    if ((exponent & 1) != 0)
      result = result * base;
    return result;
  }

  public static long power(long base, long exponent, long mod) {
    if (base >= mod)
      base %= mod;
    if (exponent == 0)
      return 1 % mod;
    long result = power(base, exponent >> 1, mod);
    result = result * result % mod;
    if ((exponent & 1) != 0)
      result = result * base % mod;
    return result;
  }

  public static long lcm(long a, long b) {
    return a / gcd(a, b) * b;
  }

  public static long[] generateFibonacci(long upTo) {
    int count = 0;
    long last = 0;
    long current = 1;
    while (current <= upTo) {
      long next = last + current;
      last = current;
      current = next;
      count++;
    }
    return generateFibonacci(count, -1);
  }

  public static long[] generateFibonacci(int count, long module) {
    long[] result = new long[count];
    if (module == -1) {
      if (count != 0)
        result[0] = 1;
      if (count > 1)
        result[1] = 1;
      for (int i = 2; i < count; i++)
        result[i] = result[i - 1] + result[i - 2];
    } else {
      if (count != 0)
        result[0] = 1 % module;
      if (count > 1)
        result[1] = 1 % module;
      for (int i = 2; i < count; i++)
        result[i] = (result[i - 1] + result[i - 2]) % module;
    }
    return result;
  }

  public static long[] generateHappy(int digits) {
    long[] happy = new long[(1 << (digits + 1)) - 2];
    happy[0] = 4;
    happy[1] = 7;
    int first = 0;
    int last = 2;
    for (int i = 2; i <= digits; i++) {
      for (int j = 0; j < last - first; j++) {
        happy[last + 2 * j] = 10 * happy[first + j] + 4;
        happy[last + 2 * j + 1] = 10 * happy[first + j] + 7;
      }
      int next = last + 2 * (last - first);
      first = last;
      last = next;
    }
    return happy;
  }

  public static long[] generateFactorial(int count, long module) {
    long[] result = new long[count];
    if (module == -1) {
      if (count != 0)
        result[0] = 1;
      for (int i = 1; i < count; i++)
        result[i] = result[i - 1] * i;
    } else {
      if (count != 0)
        result[0] = 1 % module;
      for (int i = 1; i < count; i++)
        result[i] = (result[i - 1] * i) % module;
    }
    return result;
  }

  public static long reverse(long number, long module) {
    return power(number, module - 2, module);
  }

  public static boolean isPrime(long number) {
    if (number < 2)
      return false;
    for (long i = 2; i * i <= number; i++) {
      if (number % i == 0)
        return false;
    }
    return true;
  }

  public static long[] generateReverse(int upTo, long module) {
    long[] result = new long[upTo];
    if (upTo > 1)
      result[1] = 1;
    for (int i = 2; i < upTo; i++)
      result[i] = (module - module / i * result[((int) (module % i))]
              % module)
              % module;
    return result;
  }

  public static long[] generateReverseFactorials(int upTo, long module) {
    long[] result = generateReverse(upTo, module);
    if (upTo > 0)
      result[0] = 1;
    for (int i = 1; i < upTo; i++)
      result[i] = result[i] * result[i - 1] % module;
    return result;
  }

  public static long[] generatePowers(long base, int count, long mod) {
    long[] result = new long[count];
    if (count != 0)
      result[0] = 1 % mod;
    for (int i = 1; i < count; i++)
      result[i] = result[i - 1] * base % mod;
    return result;
  }

  public static long nextPrime(long from) {
    if (from <= 2)
      return 2;
    from += 1 - (from & 1);
    while (!isPrime(from))
      from += 2;
    return from;
  }

  public static long binomialCoefficient(int n, int m, long mod) {
    if (m < 0 || m > n)
      return 0;
    if (2 * m > n)
      m = n - m;
    long result = 1;
    for (int i = n - m + 1; i <= n; i++)
      result = result * i % mod;
    return result
            * BigInteger.valueOf(factorial(m, mod))
            .modInverse(BigInteger.valueOf(mod)).longValue() % mod;
  }

  public static boolean isSquare(long number) {
    long sqrt = Math.round(Math.sqrt(number));
    return sqrt * sqrt == number;
  }

  public static long findCommon(long aRemainder, long aMod, long bRemainder,
                                long bMod) {
    long modGCD = gcd(aMod, bMod);
    long gcdRemainder = aRemainder % modGCD;
    if (gcdRemainder != bRemainder % modGCD)
      return -1;
    aMod /= modGCD;
    aRemainder /= modGCD;
    bMod /= modGCD;
    bRemainder /= modGCD;
    long aReverse = BigInteger.valueOf(aMod)
            .modInverse(BigInteger.valueOf(bMod)).longValue();
    long bReverse = BigInteger.valueOf(bMod)
            .modInverse(BigInteger.valueOf(aMod)).longValue();
    long mod = aMod * bMod;
    return (bReverse * aRemainder % mod * bMod + aReverse * bRemainder
            % mod * aMod)
            % mod * modGCD + gcdRemainder;
  }

  public static long[] generatePowers(long base, long maxValue) {
    if (maxValue <= 0)
      return new long[0];
    int size = 1;
    long current = 1;
    while (maxValue / base >= current) {
      current *= base;
      size++;
    }
    return generatePowers(base, size, Long.MAX_VALUE);
  }
}

class Pair<U, V> implements Comparable<Pair<U, V>> {
  public final U first;
  public final V second;

  private Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }

  public static <U, V> Pair<U, V> makePair(U first, V second) {
    return new Pair<U, V>(first, second);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Pair pair = (Pair) o;

    return !(first != null ? !first.equals(pair.first) : pair.first != null)
            && !(second != null ? !second.equals(pair.second)
            : pair.second != null);

  }

  @Override
  public int hashCode() {
    int result = first != null ? first.hashCode() : 0;
    result = 31 * result + (second != null ? second.hashCode() : 0);
    return result;
  }

  public Pair<V, U> swap() {
    return makePair(second, first);
  }

  @Override
  public String toString() {
    return "(" + first + "," + second + ")";
  }

  @SuppressWarnings({"unchecked"})
  public int compareTo(Pair<U, V> o) {
    int value = ((Comparable<U>) first).compareTo(o.first);
    if (value != 0)
      return value;
    return ((Comparable<V>) second).compareTo(o.second);
  }
}

class RecursiveIndependentSetSystem implements IndependentSetSystem {
  private final int[] color;
  private final int[] rank;
  private int setCount;
  private Listener listener;

  public RecursiveIndependentSetSystem(int size) {
    color = new int[size];
    rank = new int[size];
    for (int i = 0; i < size; i++)
      color[i] = i;
    setCount = size;
  }

  public RecursiveIndependentSetSystem(RecursiveIndependentSetSystem other) {
    color = other.color.clone();
    rank = other.rank.clone();
    setCount = other.setCount;
  }

  public boolean join(int first, int second) {
    first = get(first);
    second = get(second);
    if (first == second)
      return false;
    if (rank[first] < rank[second]) {
      int temp = first;
      first = second;
      second = temp;
    } else if (rank[first] == rank[second])
      rank[first]++;
    setCount--;
    color[second] = first;
    if (listener != null)
      listener.joined(second, first);
    return true;
  }

  public int get(int index) {
    if (color[index] == index)
      return index;
    return color[index] = get(color[index]);
  }

  public int getSetCount() {
    return setCount;
  }

  public void setListener(Listener listener) {
    this.listener = listener;
  }
}