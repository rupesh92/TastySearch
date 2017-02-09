package helpers;

import models.Review;
/**
 * Created by rupesh on 07/02/17.
 */
public class ReviewHelper implements Comparable<ReviewHelper>{
    Review review;
    double score;

    /**
     * Getter function to get the review
     * @return returs the review object of the object
     */
    public Review getReview() {
        return review;
    }

    /**
     * Getter function to get the score of the review
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * Constructor to instantiate the reviewHelper object
     * @param review
     * @param score
     */
    public ReviewHelper(Review review, double score) {
        this.review = review;
        this.score = score;
    }

    /**
     * This is required to compare two reviewHelper objects
     * @param o
     * @return
     */
    @Override
    public int compareTo(ReviewHelper o) {
        if(this.score == o.score) {
            if(this.getReview().getScore() == o.getReview().getScore()){
                return 0;
            }

            else if(this.review.getScore() > o.review.getScore()){
                return 1;
            }
            return -1;
        }

        if(this.score > o.score) return 1;
        return -1;
    }
}
