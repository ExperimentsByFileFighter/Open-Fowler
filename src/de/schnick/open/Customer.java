package de.schnick.open;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Customer {
    private final String name;
    private final Vector rentals = new Vector();

    public Customer(String newname) {
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("de.schnick.open.Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Iterator it = rentals.asIterator(); it.hasNext(); ) {
            Rental rental = (Rental) it.next();

            //show figures for this rental
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(rental.movie.getCharge(rental.getDaysRented())).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(this.getFrequentRentalPoints()).append(" frequent renter points");
        return result.toString();
    }


    private double getTotalCharge() {
        double totalAmount = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            totalAmount += rental.movie.getCharge(rental.getDaysRented());
        }
        return totalAmount;
    }

    private int getFrequentRentalPoints() {
        int rentalPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            rentalPoints += rental.getFrequentRenterPoints();
        }
        return rentalPoints;
    }
}
    