package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rupesh on 08/02/17.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * @param word which is to be inserted
     * @param review corresponding to the word to be inserted
     */
    public void insert(String word, Review review) {
        TrieNode rootNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i);
            if(index > 255) return;
            if (rootNode.children[index] == null) {
                TrieNode temp = new TrieNode();
                rootNode.children[index] = temp;
                rootNode = temp;
            } else {
                rootNode = rootNode.children[index];
            }
        }
        rootNode.reviews.add(review);
    }

    /**
     * Searches for a word in the trie and responses with all the reviews containing that word
     *
     * @param word to be searched
     * @return list of reviews containing that word
     */
    public List<Review> search(String word) {
        TrieNode rootNode = root;
        int l = word.length();

        for (int i = 0; i < l; i++) {
            int index = word.charAt(i);

            if (index > 255 || rootNode.children[index] == null) return new ArrayList<>();
            rootNode = rootNode.children[index];
        }

        List<Review> reviews = new ArrayList<>();
        for(Review review: rootNode.reviews) {
            reviews.add(review);
        }
        return reviews;
    }

}
