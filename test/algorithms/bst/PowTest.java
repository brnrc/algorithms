package algorithms.bst;

import junit.framework.TestCase;

/**
 * Created by ribeirob on 11/03/14.
 */
public class PowTest extends TestCase {
    public void testPow() throws Exception {
        assertEquals(59049, Pow.pow(3,10));
    }

    public void testPow2() throws Exception {
        assertEquals(59049, Pow.pow2(3,10));
    }
}
