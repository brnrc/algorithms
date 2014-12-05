package algorithms.datastructures.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static algorithms.datastructures.tree.RedBlackBST.TreeIteratorOrder.*;

public class RedBlackBSTTest {

    @Test
    public void preOrder_iterative() throws Exception {
        RedBlackBST<Character, Character> bst = new RedBlackBST<>();
        bst.put('A', 'A');
        bst.put('B', 'B');
        bst.put('C', 'C');
        bst.put('D', 'D');
        bst.put('E', 'E');
        ArrayList<Character> ans = new ArrayList<>();
        for (Iterator<Character> it = bst.getIterator(); it.hasNext();) {
            ans.add(it.next());
        }

        ArrayList<Character> list = new ArrayList<>();
        String result = "BADCE";
        for (Character c : result.toCharArray()){
            list.add(c);
        }

        Assert.assertEquals(ans.toString(), list.toString());
    }

    @Test
    public void inOrder_iterative() throws Exception {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Iterator<Integer> it = bst.getIterator(IN_ORDER); it.hasNext();) {
            ans.add(it.next());
        }

        ArrayList<Integer> list = new ArrayList<>();
        String result = "12345";
        for (Character c : result.toCharArray()){
            list.add(Character.getNumericValue(c));
        }

        Assert.assertEquals(ans.toString(), list.toString());
    }

    @Test
    public void postOrder_iterative() throws Exception {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Iterator<Integer> it = bst.getIterator(POST_ORDER); it.hasNext();) {
            ans.add(it.next());
        }

        ArrayList<Integer> list = new ArrayList<>();
        String result = "13542";
        for (Character c : result.toCharArray()){
            list.add(Character.getNumericValue(c));
        }

        Assert.assertEquals(ans.toString(), list.toString());
    }

    @Test
    public void zigzagOrder_iterative() throws Exception {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);
        bst.put(6, 6);
        bst.put(7, 7);
        bst.put(8, 8);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Iterator<Integer> it = bst.getIterator(ZIGZAG_ORDER); it.hasNext();) {
            ans.add(it.next());
        }

        ArrayList<Integer> list = new ArrayList<>();
        String result = "42675318";
        for (Character c : result.toCharArray()){
            list.add(Character.getNumericValue(c));
        }

        Assert.assertEquals(list.toString(), ans.toString());
    }

    @Test
    public void levelOrder_iterative() throws Exception {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);
        bst.put(6, 6);
        bst.put(7, 7);
        bst.put(8, 8);
        ArrayList<Integer> actual = new ArrayList<>();
        for (Iterator<Integer> it = bst.getIterator(LEVEL_ORDER); it.hasNext();) {
            actual.add(it.next());
        }

        ArrayList<Integer> expected = new ArrayList<>();
        String result = "42613578";
        for (Character c : result.toCharArray()){
            expected.add(Character.getNumericValue(c));
        }

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void preOrder_recursive() throws Exception {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);

        // walk
        List<Integer> result = bst.walk(PRE_ORDER);

        // get correct data
        ArrayList<Integer> expected = new ArrayList<>();
        String s = "21435";
        for (Character c : s.toCharArray()){
            expected.add(Character.getNumericValue(c));
        }

        // assert
        Assert.assertEquals(expected, result);
    }
    @Test
    public void inOrder_recursive() throws Exception {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);

        // walk
        List<Integer> result = bst.walk(IN_ORDER);

        // get correct data
        ArrayList<Integer> expected = new ArrayList<>();
        String s = "12345";
        for (Character c : s.toCharArray()){
            expected.add(Character.getNumericValue(c));
        }

        // assert
        Assert.assertEquals(expected, result);
    }
    @Test
    public void postOrder_recursive() throws Exception {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);

        // walk
        List<Integer> result = bst.walk(POST_ORDER);

        // get correct data
        ArrayList<Integer> expected = new ArrayList<>();
        String s = "13542";
        for (Character c : s.toCharArray()){
            expected.add(Character.getNumericValue(c));
        }

        // assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void printPostWalk() throws Exception {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST<>();
        bst.put(1, 1);
        bst.put(2, 2);
        bst.put(3, 3);
        bst.put(4, 4);
        bst.put(5, 5);

        // walk
        List<Integer> result = bst.printWalk(POST_ORDER);

        // get correct data
        ArrayList<Integer> expected = new ArrayList<>();
        String s = "13542";
        for (Character c : s.toCharArray()){
            expected.add(Character.getNumericValue(c));
        }

        // assert
        Assert.assertEquals(expected, result);
    }
}