package algorithms.bst;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Bruno Cardoso on 24/07/2014.
 */
public class BracketExpressions {
    final static String opening = "([{";
    final static String closing = ")]}";
    final static String allBrackets = opening.concat(closing);

    final static Map<Character, Character> bracketsMap = new HashMap<>();
    static {
        for (int i = 0; i < opening.length(); i++) {
            bracketsMap.put(opening.charAt(i), closing.charAt(i));
        }
    }

    public static String ifPossible(String expression){
            return test(expression) ? "possible" : "impossible";
    }

    private static boolean test(String s) {
        Stack<Character> q = new Stack<>();
        if(!s.contains("X")){
            for (char c : s.toCharArray()) {
                if(opening.contains(Character.toString(c))){
                    q.push(c);
                } else if (closing.contains(Character.toString(c))){
                if (!q.empty() && bracketsMap.get(q.peek()) == c) {
                        q.pop();
                    } else {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 0; i < allBrackets.length(); i++) {
                if(test(s.replaceFirst("X", String.valueOf(allBrackets.charAt(i))))){
                    return true;
                }
            }
            return false;
        }

        return q.empty();
    }
}
