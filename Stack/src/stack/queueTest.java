package stack;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class queueTest {
  private MyQueue q;

  @Before
  public void setup() {
    q = new MyQueue(2);
  }
  @Test
  public void newQueueShouldBeEmpty() throws Exception {
    assertEquals(0, q.size());
  }

  @Test
  public void withOneElementShouldHaveSizeOne() throws Exception {
    q.enqueue(1);
    assertEquals(1, q.size());
  }

  @Test
  public void enqueAndDequeShouldResultInSizeZero() throws Exception {
    q.enqueue(1);
    q.dequeue();
    assertEquals(0, q.size());
  }

  @Test
  public void enqueOneShouldDequeOne() throws Exception {
    q.enqueue(1);
    assertEquals(1, q.dequeue());
  }

  @Test
  public void enqueTwoShouldDequeTwo() throws Exception {
    q.enqueue(2);
    assertEquals(2, q.dequeue());
  }

  @Test
  public void enqueueOneAndTwoShouldDequeueOneAndTwo() throws Exception {
    q.enqueue(1);
    q.enqueue(2);
    assertEquals(1, q.dequeue());
    assertEquals(2, q.dequeue());
  }

  @Test(expected = MyQueue.Overflow.class)
  public void tooManyEnqueuesShouldOverflow() throws Exception {
    for (int i=0; i<3; i++)
      q.enqueue(i);
  }

  @Test (expected = MyQueue.Underflow.class)
  public void tooManyDequeuesWillUnderflow() throws Exception {
    q.dequeue();
  }

  @Test
  public void canEnqueueAndDequeueManyTimes() throws Exception {
    for (int i=0; i<100; i++) {
      q.enqueue(i);
      assertEquals(i, q.dequeue());
    }
  }
}
