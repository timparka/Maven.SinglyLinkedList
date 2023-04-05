package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList<String> list;

    @Before
    public void before() {
        list = new SinglyLinkedList<String>();
    }

    @Test
    public void testAdd() {
        String expected = "Tim";

        list.add(expected);

        Assert.assertTrue(list.contains(expected));
    }
    @Test
    public void testRemove() {
        String expected = "Tim";
        String actual = "Park";

        list.add(expected);
        list.add(actual);
        list.remove(actual);

        Assert.assertFalse(list.contains(actual));
    }
    @Test
    public void testContains() {
        String expected = "Tim";

        list.add(expected);

        Assert.assertTrue(list.contains(expected));
    }
    @Test
    public void testFind() {
        int expected = 0;

        list.add("Tim");

        Assert.assertEquals(expected, list.find("Tim"));
    }
    @Test
    public void testFind1() {
        int expected = -1;

        list.add("Tim");
        list.add("Park");

        int actual = list.find("Park");

        Assert.assertNotEquals(expected, actual);
    }
    @Test
    public void testSize() {
        int expected = 3;
        list.add("");
        list.add("");
        list.add("");

        int actual = list.size();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGet() {
        String expected = "Tim";
        list.add("");
        list.add(expected);

        int actual = list.get(1).value;

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testCopy() {
        list.add("Tim");
        SinglyLinkedList<String> expected = list.copy();

        Assert.assertNotEquals(list.toString(), expected.toString());
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i).value, expected.get(i).value);
        }
    }
    @Test
    public void testSort() {
        list.add("Tim");
        list.add("Park");
        list.add("Ace");

        list.sort();

        Assert.assertEquals(list.get(0).value, "Ace");
        Assert.assertEquals(list.get(1).value, "Tim");
        Assert.assertEquals(list.get(2).value, "Parm");


    }

}
