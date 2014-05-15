import java.io.*;
import java.util.*;
import javax.swing.*;

public class Wc {

    private Map<String, Integer> wordCounts;

    public Wc(File file) throws FileNotFoundException {
        wordCounts = new HashMap<String, Integer>();
        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNext()) {
            String curWord = fileReader.next();
            int curWordCount = (wordCounts.get(curWord) == null) ? 0
                : wordCounts.get(curWord);
            wordCounts.put(curWord, curWordCount + 1);
        }        
    }

    public Map<String, Integer> getWordCounts() {
        return wordCounts;
    }

    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        Wc wc = new Wc(file);
        Map<String, Integer> wordCounts = wc.getWordCounts();
        for (String word: wordCounts.keySet()) {
            System.out.printf("%s: %d%n", word, wordCounts.get(word));
        }
    }
}
