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

    /**
     * Getter function to get the UserID of the review object
     * @return the UserID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Getter function to get the product of the review object
     * @return the product on which the review was done
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Constructor to instantiate the review object
     * @param productID indicates the productID of the product on which the review was done
     * @param userID indicates the user who made the comment
     * @param profileName indicates the profilename
     * @param summary indicates the summarized version of the review made
     * @param text indicates the exact text of the review made
     * @param helpfullness indicates the helpfullnaess score of the review
     * @param score indicates the score of the review
     * @param timeStamp time at which the review was made
     */
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

    /**
     * Getter function to get the score of the review object
     * @return the score of the review object
     */
    public double getScore() {
        return score;
    }

    /**
     * Getter function to get the text of the review object
     * @return the text of the review made
     */
    public String getText() {
        return text;
    }

    /**
     * this is required to get the hashcode, a unique identifier to compare to objects. We have used timestamp as the
     * identifier as of now
     * @return the integer hashcode
     */
    public int hashCode(){
        return (int) time/1000;
    }

    /**
     * getter function to get the summary of the review object
     * @return
     */
    public String getSummary() {
        return summary;
    }

    /**
     * This is required to compare two objects and check if they are same or not
     * @param obj with which the currect review os to be compared
     * @return boolean corresponding to if the reviews are same or not
     */
    public boolean equals(Object obj){
        if (obj instanceof Review) {
            Review review = (Review) obj;
            if(this.userID.equals(review.userID) && this.product.getProductID().equals(review.product.getProductID())
                    && this.time == time) return true;
        }

        return false;
    }
}
