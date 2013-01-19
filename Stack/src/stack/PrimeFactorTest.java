package stack;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static stack.PrimeFactors.generate;

import static java.util.Arrays.asList;

public class PrimeFactorTest {
  @Test
  public void one() throws Exception {
    assertEquals(asList(), generate(1));
  }

  @Test
  public void two() throws Exception {
    assertEquals(asList(2), generate(2));
  }

  @Test
  public void three() throws Exception {
    assertEquals(asList(3), generate(3));
  }

  @Test
  public void four() throws Exception {
    assertEquals(asList(2, 2), generate(4));
  }

  @Test
  public void five() throws Exception {
    assertEquals(asList(5), generate(5));
  }

  @Test
  public void six() throws Exception {
    assertEquals(asList(2, 3), generate(6));
  }

  @Test
  public void seven() throws Exception {
    assertEquals(asList(7), generate(7));
  }

  @Test
  public void eight() throws Exception {
    assertEquals(asList(2, 2, 2), generate(8));
  }

  @Test
  public void nine() throws Exception {
    assertEquals(asList(3, 3), generate(9));
  }

  @Test
  public void bigComposite() throws Exception {
    assertEquals(
      asList(2, 2, 3, 3, 5, 7, 11),
      generate(2 * 2 * 3 * 3 * 5 * 7 * 11));
  }
}
