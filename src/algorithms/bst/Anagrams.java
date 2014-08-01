package algorithms.bst;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Bruno on 5/16/2014.
 */
public class Anagrams {
    public static List<String> solve(String w) {
        List<String> result = new ArrayList<>();

        File in = new File("C:\\Users\\Bruno\\Dropbox\\code\\git\\algorithms\\src\\algorithms\\bst\\wl.txt");
        try {
            FileInputStream fi = new FileInputStream(in);
            Scanner scanner = new Scanner(fi);

            //add all words to hash
            // <length, List<words>>
            HashMap<Integer, List<String>> hashWords = new HashMap<>();
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                List<String> match = hashWords.get(word.length());
                if (match == null) {
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.add(word);
                    hashWords.put(word.length(), tmp);
                } else {
                    match.add(word);
                    hashWords.put(word.length(), match);
                }
            }
            int wordLength = w.length();

            List<String> possibleResults = hashWords.get(wordLength);
            for (String word : possibleResults) {
                if (shouldAdd(word, w.toCharArray())) result.add(word);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static boolean shouldAdd(String word, char[] want) {
        char[] wordChars = word.toCharArray();
        boolean ok = false;
        Set<Integer> used = new HashSet<>();
        for (char wordChar : wordChars) {
            for (int j = 0; j < wordChars.length; j++) {
                if (wordChar == want[j] && used.add(j)) {
                    ok = true;
                    break;
                }
            }
            if (!ok) return false;
            ok = false;
        }
        return true;
    }
}
