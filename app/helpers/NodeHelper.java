package helpers;

import models.Review;
import helpers.ReviewHelper;
import services.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by rupesh on 06/02/17.
 */
public class NodeHelper {

    public static void readFile(String filePath, Node node) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        try {
            StringBuilder sb = new StringBuilder();
            for(int i =  0 ; i < 1; i++) {
                String productID = br.readLine().split(": ")[1];
                String userID = br.readLine().split(": ")[1];
                String profileName = br.readLine().split(": ")[1];
                int helpfullness = 1;//Integer.parseInt(br.readLine().split(":")[1].split("/")[0]);
                br.readLine();
                double score = Double.parseDouble(br.readLine().split(": ")[1]);
                long timeStamp = Long.parseLong(br.readLine().split(": ")[1]);
                String summary = br.readLine().split(": ")[1];
                String text = br.readLine().split(": ")[1];
//                Logger.info("Product Id is" + productID);
//                System.out.println("Product ID is " + productID);
                Review review = new Review(productID, userID, profileName, summary, text, helpfullness, score, timeStamp);

                String words[] = summary.split(" ");

                for(String word: words) {
                    node.addWord(word, review);
//                    if(word.length() > 0 && word.charAt(0) == 'B')System.out.println(node.children.get('B').reviews.size());
                }
//                System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp");

                words = text.split(" ");
                for(String word: words) {
                    node.addWord(word, review);
                }
                br.readLine();
            }
        } finally {
            br.close();
        }
    }


    public static List<ReviewHelper> topReviews(Node node, String []query, int k) {
        HashMap<Review, HashSet<String>> map = new HashMap<>();
        int size = query.length;
//        System.out.print("testing" + node.getChildren().get('g').children.get('o').reviews.size());
        Queue<ReviewHelper> queue = new PriorityQueue<>();
        for(int i = 0 ; i < size; i++) {
            String token = query[i];
            List<Review> reviews = node.getDocuments(token);
//            System.out.println("For query" + query.length + "review size is" + reviews.size());
            for(Review review: reviews) {
                if(!map.containsKey(review)) {
                    map.put(review, new HashSet<>());
                }
                System.out.println(review.product.getProductID() + " " + token);
                map.get(review).add(token);
            }
        }

        for (Map.Entry<Review, HashSet<String>> entry : map.entrySet()) {
            queue.add(new ReviewHelper(entry.getKey(), entry.getValue().size()));

            System.out.println("Key = " + entry.getKey().product.getProductID() + ", Value = " + entry.getValue().size());
        }

        List<ReviewHelper> list = new ArrayList<>();
        int count = 0;
        while(!queue.isEmpty() && count < k) {
            list.add(queue.poll());
        }
        return list;
    }

}
