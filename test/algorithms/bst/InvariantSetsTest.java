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

    @Test
    public void testCountBigSet() throws Exception {
        Assert.assertEquals(70368744177664L, InvariantSets.countSets(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 27, 26, 25, 28, 29, 30, 31, 32, 35, 34, 37, 36, 33, 38, 39, 40, 41, 48, 43, 44, 45, 46, 47, 42, 49}));
    }
}