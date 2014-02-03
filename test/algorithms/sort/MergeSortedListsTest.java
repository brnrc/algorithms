package algorithms.sort;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ribeirob on 03/02/14.
 */
public class MergeSortedListsTest extends TestCase {

    private MergeSortedLists mSortedLists;

    private ArrayList<ArrayList<Integer>> createListOfLists(int lists, int elements){
        ArrayList<Integer> arrayIntegers = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> arrayOfArrays = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i <= elements; i++) arrayIntegers.add(i);  // [1,2]
        for (int i = 0; i < lists; i++) arrayOfArrays.add((ArrayList<Integer>) arrayIntegers.clone());

        return arrayOfArrays;

    }

    public void setUp() throws Exception {
        super.setUp();
        mSortedLists = new MergeSortedLists(createListOfLists(2,2));
    }

    public void testSort() throws Exception {
        List<Integer> arrayIntegers = new ArrayList<Integer>();
        arrayIntegers.add(2);
        arrayIntegers.add(2);
        arrayIntegers.add(1);
        arrayIntegers.add(1);

        Collections.sort(arrayIntegers);

        assertEquals(arrayIntegers, mSortedLists.sort());
    }
}
