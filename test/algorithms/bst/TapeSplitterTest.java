package algorithms.bst;

import junit.framework.TestCase;

/**
 * Created by ribeirob on 11/03/14.
 */
public class TapeSplitterTest extends TestCase {

    public void testSolution() throws Exception {
        int[] a = {3,1,2,4,3};
        assertEquals(1, TapeSplitter.solution(a));
        a = new int[]{0, 2000};
        assertEquals(2000, TapeSplitter.solution(a));
    }
}
