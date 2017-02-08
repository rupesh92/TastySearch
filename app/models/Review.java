package models;

import java.util.Calendar;

/**
 * Created by rupesh on 06/02/17.
 */
//Lombok.jar
//@AllArgs
//@NoArgs
//@Data
public class Review{

    Product product;
    String userID;
    String profileName;
    String summary;
    String text;
    int helpfullness;
    double score;
    long time;

    public String getUserID() {
        return userID;
    }

    public Product getProduct() {
        return product;
    }

    public Review(String productID, String userID, String profileName, String summary, String text, int helpfullness,
                  double score, long timeStamp) {
        this.product = new Product(productID);
        this.userID = userID;
        this.profileName = profileName;
        this.helpfullness = helpfullness;
        this.score = score;
        this.time = timeStamp;
        this.summary = summary;
        this.text = text;
    }

    public double getScore() {
        return score;
    }

    public String getText() {
        return text;
    }

    public int hashCode(){
        return (int) time/1000;
    }

    public boolean equals(Object obj){
        if (obj instanceof Review) {
            Review review = (Review) obj;
            if(this.userID.equals(review.userID) && this.product.getProductID().equals(review.product.getProductID())
                    && this.time == time) return true;
        }

        return false;
    }
}
