package helpers;

import models.Review;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rupesh on 09/02/17.
 */
public class FileReadHelper {
    private static final String FILE_PATH = "./data/finefoods.txt";

    /**
     * This function opens the file from which the data is to be read
     * @return the bufferedreader object after opening the file
     * @throws FileNotFoundException in case of file is not found and the target location
     */
    public static BufferedReader openFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader(FILE_PATH));
    }

    /**
     * Reads all the attributes of a single review from the file
     * @param br used to read the file line by line
     * @return Review which is read from the file
     * @throws IOException
     */
    public static Review readReview(BufferedReader br) throws IOException {
        String productID = readLine(br).split(": ")[1];
        String userID = readLine(br).split(": ")[1];
        String profileName = readLine(br).split(": ")[1];
        int helpfullness = Integer.parseInt(readLine(br).split(": ")[1].split("/")[0]);
        double score = Double.parseDouble(readLine(br).split(": ")[1]);
        long timeStamp = Long.parseLong(readLine(br).split(": ")[1]);
        String summary = readLine(br).split(": ")[1];
        String text = readLine(br).split(": ")[1];
        readLine(br);
        return new Review(productID, userID, profileName, summary, text, helpfullness, score, timeStamp);

    }

    /**
     * Reads a single line from the bufferedreader
     * @param br Bufferedreader used to read from the file desired
     * @return String corresponding to the single line of the file
     * @throws IOException
     */
    private static String readLine(BufferedReader br) throws IOException {
        return br.readLine();
    }
}
