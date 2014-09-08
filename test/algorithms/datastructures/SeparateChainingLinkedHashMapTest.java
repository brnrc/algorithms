package algorithms.datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeparateChainingLinkedHashMapTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void separateChainingHashMap_withSize3() throws Exception {
        SeparateChainingLinkedHashMap<String, Integer> map = new SeparateChainingLinkedHashMap<>(3);
        map.put("A", 1);
        map.put("B", 1);
        map.put("C", 1);
        map.put("D", 1);
        map.get("A");

        Assert.assertEquals("A", map.iterator().next());
    }
}