package algorithms.bst.topcoder;

import org.junit.Assert;
import org.junit.Test;

public class MountainRangesTest {

    @Test
    public void testCountPeaks() throws Exception {
        Assert.assertEquals(2, MountainRanges.countPeaks(new int[]{5,6,2,4}));
        Assert.assertEquals(0, MountainRanges.countPeaks(new int[]{1,1,1,1,1,1,1}));
        Assert.assertEquals(1, MountainRanges.countPeaks(new int[]{2,1}));
        Assert.assertEquals(4, MountainRanges.countPeaks(new int[]{2,5,3,7,2,8,1,3,1}));
        Assert.assertEquals(1, MountainRanges.countPeaks(new int[]{1}));
        Assert.assertEquals(0, MountainRanges.countPeaks(new int[]{1,2,3,4,4,3,2,1}));
    }
}