package algorithms.bst;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Bruno Cardoso on 28/07/2014.
 */

public class BishopMove {
    @Data
    @AllArgsConstructor
    static class Point {
        int x;
        int y;
    }
    public static int howManyMoves(int r1, int c1, int r2, int c2){
        Point start = new Point(r1, c1);
        Point finish = new Point(r2, c2);

        if(start.equals(finish)) return 0;

        boolean xIsEven = Math.abs(start.x - finish.x) % 2 == 0;
        boolean yIsEven = Math.abs(start.y - finish.y) % 2 == 0;

        // Check viability
        if(xIsEven && !yIsEven
                ||!xIsEven && yIsEven) {
            return -1;
        }

        // check if it is on the same line
        if(Math.abs(start.x - finish.x) - Math.abs(start.y - finish.y) == 0) return 1;
        return 2;
    }
}
