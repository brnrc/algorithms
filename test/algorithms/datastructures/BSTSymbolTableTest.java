package algorithms.datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTSymbolTableTest {
    private BSTSymbolTable<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        map = new BSTSymbolTable<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("K", 4);
    }

    @Test
    public void testPutAndGet() throws Exception {
        Assert.assertEquals(1, (int) map.get("A"));
        Assert.assertEquals(2, (int) map.get("B"));
        Assert.assertEquals(3, (int) map.get("C"));
        Assert.assertEquals(4, (int) map.get("K"));
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertEquals(true, map.contains("A"));
        Assert.assertEquals(true, map.contains("K"));
        Assert.assertEquals(false, map.contains("Z"));
    }
}