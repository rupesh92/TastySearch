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

    // Inserts a word into the trie.
    public void insert(String word, Review review) {
        TrieNode rootNode = root;
        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i);
            if (rootNode.children[index] == null){
                TrieNode temp = new TrieNode();
                rootNode.children[index] = temp;
                rootNode = temp;
            } else{
                rootNode = rootNode.children[index];
            }
        }
        rootNode.reviews.add(review);
    }

    public List<Review> search(String word) {
        TrieNode rootNode = root;
        int l = word.length();

        for(int i = 0 ; i  < l ; i++) {
            int index = word.charAt(i);

            if(rootNode.children[index] == null) return new ArrayList<>();
            rootNode = rootNode.children[index];
        }
        return root.reviews;
    }

}
