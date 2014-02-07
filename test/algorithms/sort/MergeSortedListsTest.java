package algorithms.sort;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ribeirob on 03/02/14.
 */
public class MergeSortedListsTest extends TestCase {

    private List<Integer> list1k;
    private List<Integer> list10;
    private List<Integer> list10k;
    private List<Integer> list100k;
    private List<Integer> list100k_50_2k;
    private List<Integer> list10_5_2;
    private List<Integer> list1kk_500_2k;
    private List<Integer> list1kk;
    private MergeSortedLists listOfLists1k;
    private MergeSortedLists listOfLists10k;
    private MergeSortedLists listOfLists100k;
    private MergeSortedLists listOfLists100k_50_2k;
    private MergeSortedLists listOfLists10;
    private MergeSortedLists listOfLists10_5_2;
    private MergeSortedLists listOfLists1kk_500_2k;
    private MergeSortedLists listOfLists1kk;

    public void setUp() throws Exception {
        super.setUp();

        // N = 10
        list10 = createSortedListWith(1, 10);
        listOfLists10 = new MergeSortedLists(createListOfLists(1, 10));
        list10_5_2 = createSortedListWith(5, 2);
        listOfLists10_5_2 = new MergeSortedLists(createListOfLists(5, 2));

        // N = 1k
        list1k = createSortedListWith(10, 100);
        listOfLists1k = new MergeSortedLists(createListOfLists(10, 100));

        // N = 10k
        list10k = createSortedListWith(10, 1000);
        listOfLists10k = new MergeSortedLists(createListOfLists(10,1000));

        // N = 100k
        list100k = createSortedListWith(10,10000);
        listOfLists100k = new MergeSortedLists(createListOfLists(10,10000));
        list100k_50_2k = createSortedListWith(50,2000);
        listOfLists100k_50_2k = new MergeSortedLists(createListOfLists(50, 2000));

        // N = 1kk
//        list1kk = createSortedListWith(10,100000);
//        listOfLists1kk = new MergeSortedLists(createListOfLists(10, 100000));

        list1kk_500_2k = createSortedListWith(500,2000);
        listOfLists1kk_500_2k = new MergeSortedLists(createListOfLists(500, 2000));

    }

    private List<Integer> createSortedListWith(int repetition, int elements) {
        ArrayList<Integer> li = new ArrayList<Integer>();
        for (int j = 1; j <= repetition; j++)
            for (int i = 1; i <= elements ; i++){
                li.add(i);
            }
        Collections.sort(li);
        return li;
    }

    private ArrayList<ArrayList<Integer>> createListOfLists(int lists, int elements){
        ArrayList<Integer> arrayIntegers = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> arrayOfArrays = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i <= elements; i++) arrayIntegers.add(i);  // [1,2]
        for (int i = 0; i < lists; i++) arrayOfArrays.add((ArrayList<Integer>) arrayIntegers.clone());

        return arrayOfArrays;
    }

    public void test10() throws Exception {
        assertEquals(list10, listOfLists10.sort());
    }

    public void test10_5_2() throws Exception {
        assertEquals(list10_5_2, listOfLists10_5_2.sort());
    }

    public void test1k() throws Exception {
        assertEquals(list1k, listOfLists1k.sort());
    }

    public void test10k() throws Exception {
        assertEquals(list10k, listOfLists10k.sort());
    }

    public void test100k() throws Exception {
        assertEquals(list100k, listOfLists100k.sort());
    }

    public void test100k_50_2k() throws Exception {
        assertEquals(list100k_50_2k, listOfLists100k_50_2k.sort());
    }

    public void test1kk_500_2k() throws Exception {
        assertEquals(list1kk_500_2k, listOfLists1kk_500_2k.sort());
    }

//    public void test1kk() throws Exception {
//        assertEquals(list1kk, listOfLists1kk.sort());
//    }
}
