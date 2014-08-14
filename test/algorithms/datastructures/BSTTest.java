package algorithms.datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {
    private BST<String, Integer> map;
    private BST<String, Integer> mapForDeletion;

    @Before
    public void setUp() throws Exception {
        mapForDeletion = new BST<>();
        mapForDeletion.put("S", 1);
        mapForDeletion.put("X", 2);
        mapForDeletion.put("E", 3);
        mapForDeletion.put("A", 3);
        mapForDeletion.put("C", 3);
        mapForDeletion.put("R", 3);
        mapForDeletion.put("H", 3);
        mapForDeletion.put("M", 3);

        map = new BST<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("K", 4);
    }

    @Test
    public void testGet() throws Exception {
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

    @Test
    public void testFloor() throws Exception {
        Assert.assertEquals("A", map.floor("A"));
        Assert.assertEquals("B", map.floor("B"));
        Assert.assertEquals("C", map.floor("D"));
        Assert.assertEquals("C", map.floor("F"));
        Assert.assertEquals("K", map.floor("Z"));
    }

    @Test
    public void testCeiling() throws Exception {
        Assert.assertEquals("A", map.ceiling("A"));
        Assert.assertEquals("B", map.ceiling("B"));
        Assert.assertEquals("K", map.ceiling("D"));
        Assert.assertEquals("K", map.ceiling("F"));
        Assert.assertEquals(null, map.ceiling("Z"));
    }

    @Test
    public void testDeletion() throws Exception {
        Assert.assertEquals(true, mapForDeletion.contains("H"));
        mapForDeletion.delete("H");
        Assert.assertEquals(false, mapForDeletion.contains("H"));

    }
}