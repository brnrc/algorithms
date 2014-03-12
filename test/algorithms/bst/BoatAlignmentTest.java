package algorithms.bst;

import junit.framework.TestCase;

/**
 * Created by ribeirob on 12/03/14.
 */
public class BoatAlignmentTest extends TestCase {
    public void test1() throws Exception {
        assertEquals(3, BoatAlignment.solution(new int[]{1, 3, 14}, 2, 16));
    }

    public void test2() throws Exception {
        assertEquals(3, BoatAlignment.solution(new int[]{4, 7, 9, 11, 14, 21, 21, 22, 22, 23}, 1, 37));
    }
}
