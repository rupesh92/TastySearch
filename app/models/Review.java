package models;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rupesh on 06/02/17.
 */
public class Review {
    Product product;
    String userID, profileName, summary, text;
    int helpfullness;
    double score;
    Calendar time;

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

}
