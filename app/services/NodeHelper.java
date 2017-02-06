package services;

import models.Review;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rupesh on 06/02/17.
 */
public class NodeHelper {

    public static void readFile(String filePath, Node node) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        try {
            StringBuilder sb = new StringBuilder();
            for(int i =  0 ; i < 50000; i++) {
                String productID = br.readLine().split(":")[1];
                String userID = br.readLine().split(":")[1];
                String profileName = br.readLine().split(":")[1];
                int helpfullness = Integer.parseInt(br.readLine().split(":")[1]);
                double score = Double.parseDouble(br.readLine().split(":")[1]);
                long timeStamp = Long.parseLong(br.readLine().split(":")[1]);
                String summary = br.readLine().split(":")[1];
                String text = br.readLine().split(":")[1];

                Review review = new Review(productID, userID, profileName, summary, text, helpfullness, score, timeStamp);

                String words[] = summary.split(" ");

                for(String word: words) {
                    node.addWord(word, review);
                }

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

}
