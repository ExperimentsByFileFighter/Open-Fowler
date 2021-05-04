package de.schnick.open.test;

import de.schnick.open.Customer;
import de.schnick.open.Movie;
import de.schnick.open.Rental;

public class Test {

    public static void main(String[] args) {
        System.out.println("Testing...");
        testSTOUTMain();
    }

    private static void testSTOUTMain() {
        String customerName0 = "SomeDude";
        String customerName1 = "SomeOtherDude";


        Customer customer0 = new Customer(customerName0);
        Customer customer1 = new Customer(customerName1);

        String movieTitle0 = "SomeMovieTitle0";
        String movieTitle1 = "SomeMovieTitle1";
        String movieTitle2 = "SomeMovieTitle2";
        String movieTitle3 = "SomeMovieTitle3";
        int moviePrice0 = 1;
        int moviePrice1 = 5;
        int moviePrice2 = 10;
        int moviePrice3 = 15;
        Movie movie0 = new Movie(movieTitle0, moviePrice0);
        Movie movie1 = new Movie(movieTitle1, moviePrice1);
        Movie movie2 = new Movie(movieTitle2, moviePrice2);
        Movie movie3 = new Movie(movieTitle3, moviePrice3);

        int days0 = 1234;
        int days1 = 4321;
        int days2 = 1233;
        int days3 = 7126;
        Rental rental0 = new Rental(movie0, days0);
        Rental rental1 = new Rental(movie1, days1);
        Rental rental2 = new Rental(movie2, days2);
        Rental rental3 = new Rental(movie3, days3);

        customer0.addRental(rental0);
        customer1.addRental(rental1);
        customer0.addRental(rental2);
        customer1.addRental(rental3);

        String expectedOutput0 = "de.schnick.open.Rental Record for "+customerName0+"\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tSomeMovieTitle0\t\t1234\t3702.0\n" +
                "\tSomeMovieTitle2\t\t1233\t0.0\n" +
                "Amount owed is 3702.0\n" +
                "You earned 3 frequent renter points";
        String expectedOutput1 = "de.schnick.open.Rental Record for SomeOtherDude\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tSomeMovieTitle1\t\t4321\t0.0\n" +
                "\tSomeMovieTitle3\t\t7126\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 2 frequent renter points";

        String actualOutput0 = customer0.statement();
        String actualOutput1 = customer1.statement();

        if (!expectedOutput0.equals(actualOutput0))
            throw new AssertionError("The expectedOutput differed from the actual one. Expected:\n" + expectedOutput0 + "\nGot:\n" + actualOutput0);
        System.out.println("First one was ok.");

        if (!expectedOutput1.equals(actualOutput1))
            throw new AssertionError("The expectedOutput differed from the actual one. Expected:\n" + expectedOutput1 + "\nGot:\n" + actualOutput1);
        System.out.println("Second one was ok.");
        System.out.println("ok.");
    }
}
