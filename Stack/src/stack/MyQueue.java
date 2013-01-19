package stack;

public class MyQueue {
  private int size = 0;
  private int elements[];
  private int first = 0;
  private int last = 0;

  public MyQueue(int bound) {
    elements = new int[bound];
  }

  public int size() {
    return size;
  }

  public void enqueue(int element) {
    if (size >= elements.length)
      throw new Overflow();
    elements[last++] = element;
    last %= elements.length;
    size++;
  }

  public int dequeue() {
    if (size == 0)
      throw new Underflow();
    size--;
    int element = elements[first++];
    first %= elements.length;
    return element;
  }

  public class Overflow extends RuntimeException {
  }

  public class Underflow extends RuntimeException {
  }
}
