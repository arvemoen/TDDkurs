package videoStore;

import java.util.ArrayList;
import java.util.List;

public class Statement {
  private double totalAmount;
  private int frequentRenterPoints;
  private List<Rental> rentals = new ArrayList<Rental>();
  private Customer customer;

  public Statement(Customer customer) {
    this.customer = customer;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String makeStatement() {
    StatementFormatter formatter = new StatementFormatter(this);
    clearTotals();
    formatter.addHeader();
    addRentals(formatter);
    formatter.addTotals();
    return formatter.toString();
  }

  private void addRentals(StatementFormatter formatter) {
    for (Rental rental : rentals) {
      calcTotals(rental);
      formatter.addRentalLineItem(rental);
    }
  }

  private double calcTotals(Rental rental) {
    double amount = rental.determineRentalAmount();
    totalAmount += amount;
    frequentRenterPoints += rental.determineFrequentRenterPoints();
    return amount;
  }

  private void clearTotals() {
    totalAmount = 0;
    frequentRenterPoints = 0;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public int getFrequentRenterPoints() {
    return frequentRenterPoints;
  }

  public String getCustomerName() {
    return customer.getName();
  }
}