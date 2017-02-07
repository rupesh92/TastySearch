package helpers;

import models.Review;
/**
 * Created by rupesh on 07/02/17.
 */
public class ReviewHelper implements Comparable<ReviewHelper>{
    Review review;


    int score;

    public Review getReview() {
        return review;
    }

    public int getScore() {
        return score;
    }

    public void setReview(Review review) {
        this.review = review;
    }


    public ReviewHelper(Review review, int score) {
        this.review = review;
        this.score = score;
    }

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
