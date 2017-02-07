package services;

import models.Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rupesh on 06/02/17.
 */

public class Node {

    public List<Node> children;

    public List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node(){

        children = new ArrayList<>(Collections.nCopies(256, null));
        reviews = new ArrayList<>();
    }

//    private void addChar(Node node, String word, int index, Review review){
//        if(word.length() == index) {
//            return;
//        }
//
//        int charPosition = word.charAt(index);
//        if(charPosition > 255){
//            System.out.println(word);
//            return;
//        }
//
//        if(node.getChildren().get(charPosition) == null) {
//            node.getChildren().add(charPosition, new Node());
//            System.out.println(index + " " + word);
//        }
//
//        if(index == word.length() - 1) {
//            node.getChildren().get(charPosition).getReviews().add(review);
//        }
//
//        addChar(node.getChildren().get(charPosition), word, index + 1, review);
//        return;
//
//    }

    public void addWord(String word, Review review){
//        addChar(this, word, 0, review);

        Node root = this;
        int l = word.length();
        for(int i = 0 ; i < l ; i++){
            if(word.charAt(i) > 255) return;
//            if(root.children.get(word.charAt(i)) == null)
            if(root.children.get(word.charAt(i)) == null){
                root.children.add(word.charAt(i), new Node());
            }
            root = root.children.get(word.charAt(i));
        }
        root.reviews.add(review);
        System.out.println(word + " " + root.reviews.size());
    }

    public List<Review> getDocuments(String word) {
//        return searchDocuments(this, word, 0);
        int l = word.length();
        Node root = this;
        for(int i = 0 ; i < l ; i++){
            if(root.children.get(word.charAt(i)) == null) return new ArrayList<>();
            root = root.children.get(word.charAt(i));
        }
//        System.out.println(word + " " + "Trying to fetch");
        return root.reviews;

    }

//    private List<Review> searchDocuments(Node n, String s, int index) {
//        if(index == s.length()) {
//            return n.getReviews();
//        }
//
//        int charPosition = s.charAt(index);
//        if(n.children.get(charPosition) == null) return new ArrayList<>();
//
//        return searchDocuments(n.children.get(charPosition), s, index + 1);
//    }
}
