package de.schnick.open;

class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) return 2;
        return super.getFrequentRenterPoints(daysRented);

    }
}
