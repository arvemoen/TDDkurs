package stack;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
  private MyStack s;

  @Before
  public void setup() {
    s = new MyStack(2);
  }

  @Test
  public void newStackShouldHaveSizeZero() throws Exception {
    assertEquals(0, s.size());
  }

  @Test
  public void pushOneElementShouldHaveSizeOne() throws Exception {
    s.push(0);
    assertEquals(1, s.size());
  }

  @Test
  public void popAfterPushShouldResultInZeroSize() throws Exception {
    s.push(0);
    s.pop();
    assertEquals(0, s.size());
  }

  @Test
  public void popAfterPushOneShouldReturnOne() throws Exception {
    s.push(1);
    assertEquals(1, s.pop());
  }

  @Test
  public void popAfterPushTwoShouldReturnTwo() throws Exception {
    s.push(2);
    assertEquals(2, s.pop());
  }

  @Test
  public void popShouldReturnPushesInReverseOrder() throws Exception {
    s.push(1);
    s.push(2);
    assertEquals(2, s.pop());
    assertEquals(1, s.pop());
  }

  @Test
  public void sizeAfterTwoPushesShouldBeTwo() throws Exception {
    s.push(1);
    s.push(2);
    assertEquals(2, s.size());
  }

  @Test(expected = MyStack.Overflow.class)
  public void shouldThrowExceptionOnOverflow() throws Exception {
    s = new MyStack(3);
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
  }

  @Test
  public void canFullyLoadStack() throws Exception {
    s = new MyStack(3);
    for (int i=0; i<3; i++)
      s.push(i);
    assertEquals(3, s.size());
  }

  @Test(expected = MyStack.Underflow.class)
  public void ShouldUnderflowIfTooManyPops() throws Exception {
    s.pop();
  }


}
