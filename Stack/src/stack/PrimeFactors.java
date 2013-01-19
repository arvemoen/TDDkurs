package stack;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
  public static List<Integer> generate(int n) {
    ArrayList<Integer> factors = new ArrayList<Integer>();

    for (int candidate = 2; n > 1; candidate++)
      for (; n % candidate == 0; n /= candidate)
        factors.add(candidate);

    return factors;
  }
}
