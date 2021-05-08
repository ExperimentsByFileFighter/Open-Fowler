package de.schnick.open;


import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    ;

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    ;

    public String getName() {
        return name;
    }

    ;

    public String statement() {

        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("de.qvalentin.Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            //show figures for this rental
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(String.valueOf(rental.getCharge())).append("\n");

        }
        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(getTotalCharge())).append("\n");
        result.append("You earned ").append(String.valueOf(getFrequentRentalPoints())).append(" frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        double totalAmount = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            //show figures for this rental
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

    private int getFrequentRentalPoints() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental rental = enum_rentals.nextElement();
            //show figures for this rental
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }


}

