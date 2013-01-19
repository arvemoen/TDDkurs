package videoStore;

public class ChildrensMovie extends Movie {
  public ChildrensMovie(String title) {
    super(title);
  }

  public double determineRentalAmount(int daysRented) {
    double thisAmount = 1.5;
    if (daysRented > 3) {
      int extraDays = daysRented - 3;
      thisAmount += extraDays * 1.5;
    }
    return thisAmount;
  }

  public int determineFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
