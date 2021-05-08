package de.schnick.open;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private final String title;
    private Price priceCode;


    public Movie(String newtitle, int priceCodeValue) {
        title = newtitle;
        setPriceCode(priceCodeValue);
    }

    public void setPriceCode(int priceCodeValue) {
        switch (priceCodeValue) {
            case REGULAR:
                priceCode = new RegularPrice();
                break;
            case CHILDREN:
                priceCode = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                priceCode = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Bad price code used.");
        }
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return priceCode.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return priceCode.getFrequentRenterPoints(daysRented);
    }
}
