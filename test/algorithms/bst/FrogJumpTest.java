package algorithms.bst;

import junit.framework.TestCase;

/**
 * Created by ribeirob on 11/03/14.
 */
public class FrogJumpTest extends TestCase {
    public void testSolution() throws Exception {
        assertEquals(3, FrogJump.solution(10,85,30));
        assertEquals(2, FrogJump.solution(10,70,30));
        assertEquals(1, FrogJump.solution(10,20,30));
        assertEquals(1, FrogJump.solution(10,10000000,1000000000));

    }
}
