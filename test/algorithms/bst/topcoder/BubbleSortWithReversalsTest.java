package algorithms.bst.topcoder;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortWithReversalsTest {

    @Test
    public void testGetMinSwaps() throws Exception {
//        Assert.assertEquals(0, new BubbleSortWithReversals().getMinSwaps(new int[]{6,8,8,7,7}, 1));
//        Assert.assertEquals(3, new BubbleSortWithReversals().getMinSwaps(new int[]{7,2,2,13,5,5,2}, 2));
        Assert.assertEquals(12, new BubbleSortWithReversals().getMinSwaps(new int[]{12,5,1,10,12,6,6,10,6,8}, 2));
    }

    @Test
    public void testSwap() throws Exception {

    }

    @Test
    public void testReverse() throws Exception {
        Assert.assertArrayEquals(new int[]{0,1,2}, new BubbleSortWithReversals().reverse(new int[]{2,1,0}, 0, 2));
        Assert.assertArrayEquals(new int[]{1,1,0,1,2}, new BubbleSortWithReversals().reverse(new int[]{0,1,1,1,2}, 0, 2));
        Assert.assertArrayEquals(new int[]{2,1,0,3,4}, new BubbleSortWithReversals().reverse(new int[]{0,1,2,3,4}, 0, 2));
        Assert.assertArrayEquals(new int[]{0,1,2,3,4}, new BubbleSortWithReversals().reverse(new int[]{4,3,2,1,0}, 0, 4));
        Assert.assertArrayEquals(new int[]{0,1,2,3}, new BubbleSortWithReversals().reverse(new int[]{3,2,1,0}, 0, 3));
        Assert.assertArrayEquals(new int[]{3,0,1,2}, new BubbleSortWithReversals().reverse(new int[]{3,2,1,0}, 1, 3));
    }
}