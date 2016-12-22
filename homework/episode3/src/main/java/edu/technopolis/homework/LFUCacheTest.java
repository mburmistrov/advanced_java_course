package edu.technopolis.homework;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import java.util.Random;

import static org.junit.Assert.assertEquals;
/**
 * Created by mmb on 22.12.16.
 */
public class LFUCacheTest {

    LFUCache cache;
    Random random;
    int initSize = 100;

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Before
    public void init() {
        cache = new LFUCache();
        random = new Random();
    }

    @Test
    public void testFill() {
        for (int i = 0; i < initSize; i++) {
            cache.addNode(i, String.valueOf(random.nextInt(100)));
        }
    }

    @Test
    public void testGetSet() {
        cache.addNode(2,"2");
        assertEquals("2", cache.getNode(2));
        assertEquals("2", cache.getNode(2));
        cache.addNode(1,"1");
        assertEquals("1", cache.getNode(1));
        assertEquals("2", cache.getNode(2));
    }

    @Test
    public void testIntegerMaxValueKey() {
         cache.addNode(Integer.MAX_VALUE, String.valueOf(Integer.MAX_VALUE));
         assertEquals(String.valueOf(Integer.MAX_VALUE), cache.getNode(Integer.MAX_VALUE));
    }

    @Test
    public void testIntegerMaxValuePlusIntKey() {
         cache.addNode(Integer.MAX_VALUE + 1, String.valueOf(Integer.MAX_VALUE+1));
         assertEquals(String.valueOf(Integer.MAX_VALUE + 1), cache.getNode(Integer.MAX_VALUE + 1));
    }

    @Test
    public void testIntegerMinValueKey() {
        cache.addNode(Integer.MIN_VALUE, String.valueOf(Integer.MIN_VALUE));
        assertEquals(String.valueOf(Integer.MIN_VALUE), cache.getNode(Integer.MIN_VALUE));
    }

    @Test
    public void testIntegerMinValueMinusIntKey() {
        cache.addNode(Integer.MIN_VALUE - 1, String.valueOf(Integer.MIN_VALUE - 1));
        assertEquals(String.valueOf(Integer.MIN_VALUE - 1), cache.getNode(Integer.MIN_VALUE - 1));
    }

}
