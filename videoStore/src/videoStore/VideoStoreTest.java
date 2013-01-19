package videoStore;

import junit.framework.TestCase;

public class VideoStoreTest extends TestCase {
  private Movie newRelease = new NewReleaseMovie("New Release");
  private Movie newRelease2 = new NewReleaseMovie("New Release 2");
  private Movie childrensMovie = new ChildrensMovie("Childrens Movie");
  private Movie regular1 = new RegularMovie("Regular 1");
  private Movie regular2 = new RegularMovie("Regular 2");
  private Movie regular3 = new RegularMovie("Regular 3");

  public VideoStoreTest(String name) {
    super(name);
  }

  protected void setUp() {
    Customer customer = new Customer("Fred");
    statement = new Statement(customer);
  }

  public void testSingleNewReleaseStatementFormat() {
    statement.addRental(new Rental(newRelease, 3));
    assertEquals(
      "Rental Record for Fred\n" +
        "\tNew Release\t9.0\n" +
        "You owed 9.0\n" +
        "You earned 2 frequent renter points\n",
      statement.makeStatement());
    assertEquals(9.0, statement.getTotalAmount());
    assertEquals(2, statement.getFrequentRenterPoints());
  }

  public void testSingleNewReleaseStatementTotals() {
    statement.addRental(new Rental(newRelease, 3));
    statement.makeStatement();
    assertEquals(9.0, statement.getTotalAmount());
    assertEquals(2, statement.getFrequentRenterPoints());
  }

  public void testDualNewReleaseStatement() {
    statement.addRental(new Rental(newRelease, 3));
    statement.addRental(new Rental(newRelease2, 3));
    statement.makeStatement();
    assertEquals(18.0, statement.getTotalAmount());
    assertEquals(4, statement.getFrequentRenterPoints());
  }

  public void testSingleChildrensStatement() {
    statement.addRental(new Rental(childrensMovie, 3));
    statement.makeStatement();
    assertEquals(1.5, statement.getTotalAmount());
    assertEquals(1, statement.getFrequentRenterPoints());
  }

  public void testStatementForRentingChildrensMoreThanThreeDays() {
    statement.addRental(new Rental(childrensMovie, 4));
    statement.makeStatement();
    assertEquals(3.0, statement.getTotalAmount());
    assertEquals(1, statement.getFrequentRenterPoints());
  }

  public void testMultipleRegularStatement() {
    statement.addRental(new Rental(regular1, 1));
    statement.addRental(new Rental(regular2, 2));
    statement.addRental(new Rental(regular3, 3));
    statement.makeStatement();
    assertEquals(7.5, statement.getTotalAmount());
    assertEquals(3, statement.getFrequentRenterPoints());
  }

  private Statement statement;
}