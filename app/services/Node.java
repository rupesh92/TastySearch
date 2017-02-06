package services;

import models.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rupesh on 06/02/17.
 */
public class Node {
    public List<Node> children;
    public List<Review> reviews;

    public Node(){
        children = new ArrayList<>(256);
        reviews = new ArrayList<>();
    }

    public Node(ArrayList<Node> children, ArrayList<Review> reviews){
        this.children = children;
        this.reviews = reviews;
    }


    private void addChar(Node node, String word, int index, Review reviews){
        if(word.length() == index) return;

        int charPosition = word.charAt(index);
        if(node.children.get(charPosition) == null) {
            node.children.add(charPosition, new Node());
        }

        Node n = this.children.get(word.charAt(index));
        if(index == word.length() - 1) {
            n.reviews.add(reviews);
        }

        addChar(n.children.get(charPosition), word, index + 1, reviews);
        return;

    }

    public void addWord(String word, Review reviews){
        addChar(this, word, 0, reviews);
    }

    public List<Review> getDocuments(String word) {
        return searchDocuments(this, word, 0);
    }

    private List<Review> searchDocuments(Node n, String s, int index) {
        if(index == s.length()) {
            return n.reviews;
        }

        int charPosition = s.charAt(index);
        if(n.children.get(charPosition) == null) return new ArrayList<>();

        return searchDocuments(n.children.get(charPosition), s, index + 1);
    }
}
