package models;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rupesh on 06/02/17.
 */
public class Review implements Comparable<Review>{
    public Product product;

    String userID, profileName, summary, text;
    int helpfullness;
    double score;
    Calendar time;

    public double getScore() {
        return score;
    }

    public String getText() {
        return text;
    }


    public Review(String productID, String userID, String profileName, String summary, String text, int helpfullness,
                  double score, long timeStamp) {
        this.product = new Product(productID);
        this.userID = userID;
        this.profileName = profileName;
        this.helpfullness = helpfullness;
        this.score = score;
        this.time = Calendar.getInstance();
        this.summary = summary;
        this.text = text;
        time.setTimeInMillis(timeStamp * 1000);

    }

    @Override
    public int compareTo(Review r) {
        if(this.userID.equals(r.userID) && this.product.getProductID().equals(r.product.getProductID()) && this.time.equals(r.time)) {
            return 0;
        }
        return 1;
    }
}
