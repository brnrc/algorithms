package algorithms.bst;

import org.junit.Assert;
import org.junit.Test;

public class InvariantSetsTest {

    @Test
    public void testCountSets() throws Exception {
        Assert.assertEquals(5, InvariantSets.countSets(new int[]{1, 0, 0, 0}));
        Assert.assertEquals(2, InvariantSets.countSets(new int[]{1, 2, 0}));
        Assert.assertEquals(5, InvariantSets.countSets(new int[]{0, 0, 1, 2}));
        Assert.assertEquals(90, InvariantSets.countSets(new int[]{12, 10, 0, 4, 0, 6, 3, 8, 9, 14, 1, 5, 6, 12, 5}));
        Assert.assertEquals(143, InvariantSets.countSets(new int[]{0, 7, 5, 13, 9, 3, 8, 9, 1, 5, 0, 4, 0, 10, 10}));
    }
}