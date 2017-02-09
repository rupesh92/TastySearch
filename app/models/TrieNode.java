package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by rupesh on 08/02/17.
 */
public class TrieNode {
    TrieNode[] children;
    HashSet<Review> reviews;

    /**
     * Constructor function to instantiate the TrieNode object
     */
    public TrieNode() {
        children = new TrieNode[256];
        reviews = new HashSet<>();
    }
}
