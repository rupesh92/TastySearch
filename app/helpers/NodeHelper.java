package helpers;

import models.Review;
import models.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by rupesh on 06/02/17.
 */
public class NodeHelper {
    private static final int NUMBER_OF_REVIEWS = 5000;

    /**
     * this function reads review from the file and stores it in the trie.
     * @param trie in which the review is to be stored
     * @throws IOException
     */
    public static void updateData(Trie trie) throws IOException {
        BufferedReader br = FileReadHelper.openFile();

        try {
            for(int i =  0 ; i < NUMBER_OF_REVIEWS; i++) {

                Review review = FileReadHelper.readReview(br);

                String words[] = review.getSummary().split(" ");
                insertWords(trie, words, review);

                words = review.getText().split(" ");
                insertWords(trie, words, review);
            }
        } finally {
            br.close();
        }
    }

    /**
     * This is a helper function for updateData which stores data in the trie
     * @param trie in which the words are to be stored
     * @param words array of string to be stored in the trie
     * @param review review which contains all the mentioned words
     */
    public static void insertWords(Trie trie, String []words, Review review) {
        for(String word: words) {
            trie.insert(word, review);
        }
    }


    /**
     * Tis function helps in getting the top desired number of reviews which satisfy the maximum occurrence condition
     * @param trie from which the reviews are to be fetched
     * @param query Array of string results for which are desired
     * @param k number of results demanded by the user
     * @return list of reviewHelpers objects in the order of their match
     */
    public static List<ReviewHelper> getTopReviews( Trie trie, String []query, int k) {
        HashMap<Review, HashSet<String>> map = populateMap(query, trie);
        Queue<ReviewHelper> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        int numOfWords = query.length;

        for (Map.Entry<Review, HashSet<String>> entry : map.entrySet()) {

            double score = ((double)entry.getValue().size())/numOfWords;
            score = Math.round(score * 100);
            score = score/100;
            queue.add(new ReviewHelper(entry.getKey(), score));
        }

        List<ReviewHelper> list = new ArrayList<>();

        int count = 0;
        while(!queue.isEmpty() && count < k) {
            list.add(queue.poll());
            count++;
        }
        return list;
    }

    /**
     * This is used to populate the map containing review mapped to a pool of string contained in it and requested by the user
     * @param query Array of string occurrence of which in the reviews is requested by the user
     * @param trie in which the reviews are to be searched
     * @return
     */
    private static HashMap<Review, HashSet<String>> populateMap(String query[], Trie trie) {
        HashMap<Review, HashSet<String>> map = new HashMap<>();
        int size = query.length;
        for(int i = 0 ; i < size; i++) {
            String token = query[i];
            List<Review> reviews = trie.search(token);
            for(Review review: reviews) {
                if(!map.containsKey(review)) {
                    map.put(review, new HashSet<>());
                }
                map.get(review).add(token);
            }
        }
        return map;
    }

}
