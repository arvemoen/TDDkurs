package videoStore;

public class StatementFormatter {
  private final Statement statement;
  private StringBuilder statementBuilder;

  public StatementFormatter(Statement statement) {
    this.statement = statement;
    statementBuilder = new StringBuilder();
  }

  public String toString() {
    return statementBuilder.toString();
  }

  public void addTotals() {
    statementBuilder.append(String.format(
      "You owed %.1f\n",
      statement.getTotalAmount())
    );
    statementBuilder.append(String.format(
      "You earned %d frequent renter points\n",
      statement.getFrequentRenterPoints())
    );
  }

  public void addRentalLineItem(Rental rental) {
    statementBuilder.append(String.format(
      "\t%s\t%.1f\n",
      rental.getTitle(),
      rental.determineRentalAmount())
    );
  }

  public void addHeader() {
    statementBuilder.append(String.format(
      "Rental Record for %s\n",
      statement.getCustomerName())
    );
  }
}