package algorithms.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumSubarrayTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testKadane1D() throws Exception {
        Assert.assertEquals(3, MaximumSubarray.kadane(new int[]{1, -2, 2, 1}));
        Assert.assertEquals(3, MaximumSubarray.kadane(new int[]{1, 1, -1, 1, 1, -2}));
        Assert.assertEquals(6, MaximumSubarray.kadane(new int[]{1, 1, -1, 1, 1, -2, 5}));
        Assert.assertEquals(2, MaximumSubarray.kadane(new int[]{-2, -1, 0, -5, 2}));
        Assert.assertEquals(0, MaximumSubarray.kadane(new int[]{0}));
        Assert.assertEquals(1, MaximumSubarray.kadane(new int[]{0, 1}));
    }

    @Test
    public void testKadane2D() throws Exception {
        int result = MaximumSubarray.kadane2D(
                new int[][]{
                        { 1,  2, -1},
                        {-3, -1, -4},
                        { 1, -5,  2}
                });
        Assert.assertEquals(3, result); // [1,2]

        result = MaximumSubarray.kadane2D(
                new int[][]{
                        { 1,  2, -1},
                        { 9, 3,  -5}
                });
        Assert.assertEquals(15, result);

    }
}