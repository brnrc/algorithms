package algorithms.bst.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Bruno Cardoso on 11/09/2014.
 */
public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            String text = scan.next();
            List<Character> chars = new ArrayList<>(text.length());
            for (Character c : text.toCharArray()) chars.add(c);

            int count = 0;
            for (int j = 1; j < chars.size(); j++) {
                char current = chars.get(j);
                if(current == chars.get(j - 1)){
                    chars.remove(j);
                    j--;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
