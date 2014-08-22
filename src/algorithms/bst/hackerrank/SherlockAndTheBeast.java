package algorithms.bst.hackerrank;

import java.util.Scanner;

/**
 * Complexity:
 *  Time : O(N)
 *  Space: O(N)
 *
 * Created by Bruno Cardoso on 21/08/2014.
 */
public class SherlockAndTheBeast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        String decent;
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            decent = iterativeSearchDecent(N);
            System.out.println(decent);
        }
    }

    private static String iterativeSearchDecent(int n) {
        if (n < 3) return "-1";

        StringBuilder partial = new StringBuilder();
        while (n > 10) {
            partial.append("555");
            n -= 3;
        }

        switch (n) {
            case 3:
                partial.append("555");
                break;
            case 5:
                partial.append("33333");
                break;
            case 6:
                partial.append("555555");
                break;
            case 8:
                partial.append("55533333");
                break;
            case 9:
                partial.append("555555555");
                break;
            case 10:
                partial.append("3333333333");
                break;
            default:
                partial = new StringBuilder();
                partial.append("-1");
        }
        return partial.toString();
    }
}
