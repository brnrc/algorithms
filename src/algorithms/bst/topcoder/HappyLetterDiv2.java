package algorithms.bst.topcoder;

import com.google.common.base.CharMatcher;

/**
 * Created by Bruno Cardoso on 08/08/2014.
 */
public class HappyLetterDiv2 {
    public static char getHappyLetter(String letters){
        int top = -1;
        char happy = '.';

        for (int i = 0; i < letters.length(); i++) {
            int count = CharMatcher.is(letters.charAt(i)).countIn(letters);
            if(count > top) {
                top = count;
                happy = letters.charAt(i);
            }
        }
        return (top > letters.length() - top) ?  happy: '.';
    }
}
