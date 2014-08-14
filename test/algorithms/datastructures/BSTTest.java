package algorithms.datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class BSTTest {
    private BST<String, Integer> map;
    private char[] chars;
    private Random random;

    @Before
    public void setUp() throws Exception {

        chars = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        random = new Random();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[random.nextInt(chars.length)];
        }

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
    public void testInsertion() throws Exception {
        Random randomInt = new Random();
        for (int i = 0; i < 1000; i++) {
            map.put(String.valueOf(chars[random.nextInt(chars.length)]), randomInt.nextInt(10));
        }
    }
}