package algorithms.bst.topcoder;

import org.junit.Assert;
import org.junit.Test;

public class ManySquaresTest {

    @Test
    public void testHowManySquares() throws Exception {
        Assert.assertEquals(1, ManySquares.howManySquares(new int[]{1,1,2,2,1,1,2}));
        Assert.assertEquals(1, ManySquares.howManySquares(new int[]{3, 1, 4, 4, 4, 10, 10, 10, 10}));
        Assert.assertEquals(3, ManySquares.howManySquares(new int[]{1,2,3,4,1,2,3,4,1,2,3,1,2,3,4,1,2,3,3,3}));
        Assert.assertEquals(0, ManySquares.howManySquares(new int[]{1,1,1,2,2,2,3,3,3,4,4,4}));
        Assert.assertEquals(2, ManySquares.howManySquares(new int[]{1,1,1,2,1,1,1,3,1,1,1}));
        Assert.assertEquals(0, ManySquares.howManySquares(new int[]{2,2,4,4,8,8}));
    }
}