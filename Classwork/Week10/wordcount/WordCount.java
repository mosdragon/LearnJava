import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    private Map<String, Integer> wordCounts;
    public WordCount(String filename) throws FileNotFoundException{
        wordCounts = new HashMap<>();
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNext()) {
            
            String temp = fileScanner.next().trim().toLowerCase();
            String word = temp.replaceAll("[][(){},.;!?<>%]", "");
            if ( wordCounts.containsKey(word)) {
                int val = wordCounts.get(word);
                wordCounts.put(word, ++val);
            } else {
                wordCounts.put(word, 1);
            }
        }
    }
    public String toString() {
        String msg = "";
        for (String word: wordCounts.keySet()) {
            msg += "Count of " + word + " is " + wordCounts.get(word) + "\n";
        }
        return msg;
    }
    public static void main(String[] args) throws FileNotFoundException {
        WordCount wc = new WordCount(args[0]);
        System.out.println(wc);

    }
}