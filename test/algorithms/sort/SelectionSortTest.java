package algorithms.sort;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Bruno
 * Date: 10/1/13
 * Time: 1:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class SelectionSortTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void testSort() throws Exception {
        Integer[] list = new Integer[5];
        list[0] = 7;
        list[1] = 623;
        list[2] = 16;
        list[3] = 36;
        list[4] = 62;
        SelectionSort.sort(list);

        String s[] = {
            new String("D4"),
            new String("C3"),
            new String("B2"),
            new String("A12")
        };
//        SelectionSort.sort(s);
//        Collections.sort(s);

        List<String> listString = new LinkedList<String>();
        listString.add("A1");
        listString.add("A5");
        listString.add("A3");
        listString.add("B1");
        //SelectionSort.sort(listString);
    }
}
