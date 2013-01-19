package stack;

public class MyStack {
  private int size = 0;
  private int elements[];

  public MyStack(int bound) {
    elements = new int[bound];
  }

  public void push(int element) {
    if (size >= elements.length) {
      throw new Overflow();
    }
    this.elements[size] = element;
    size++;
  }

  public int size() {
    return size;
  }

  public int pop() {
    if (size == 0)
      throw new Underflow();
    size--;
    return elements[size];
  }

  public class Overflow extends RuntimeException {
  }

  public class Underflow extends RuntimeException {
  }
}
