package videoStore;

public class Rental {
  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  private Movie movie;
  private int daysRented;

  public double determineRentalAmount() {
    return movie.determineRentalAmount(daysRented);
  }

  public int determineFrequentRenterPoints() {
    return movie.determineFrequentRenterPoints(daysRented);
  }


  public String getTitle() {
    return movie.getTitle();
  }
}