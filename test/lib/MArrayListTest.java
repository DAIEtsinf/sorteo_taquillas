package lib;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MArrayListTest {
    
    public MArrayListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of clone method, of class MArrayList.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        MArrayList instance = new MArrayList();
        instance.add("hola");
        instance.add(null);
        instance.add(new AssertionError());
        
        MArrayList result = instance.clone();
        assertEquals(instance, result);
    }

    /**
     * Test of randomize method, of class MArrayList.
     */
    @Test
    public void testRandomize() {
        System.out.println("randomize");
        MArrayList instance = new MArrayList();
        instance.add("");
        instance.add(null);
        instance.add(new Exception());
        instance.add("1");
        instance.add(new AbstractMethodError());
        instance.add("1231");
        
        MArrayList result = instance.randomize();
        
        try{
            assertEquals(instance, result);
            fail("instance y result dan lo mismo");
        }catch(AssertionError ae){}
    }

    /**
     * Test of removeDuplicates method, of class MArrayList.
     */
    @Test
    public void testRemoveDuplicates() {
        System.out.println("removeDuplicates");
        MArrayList instance = new MArrayList();
        MArrayList expResult = null;
        
        String h = "hola";
        instance.add(h);
        instance.add("hey");
        instance.add(null);
        instance.add("hello world");
        expResult = instance.clone();
        instance.add(h);
        instance.add("hey");
        instance.add(null);
        
        MArrayList result = instance.removeDuplicates();
        assertEquals(expResult, result);
    }

    /**
     * Test of difference method, of class MArrayList.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        MList l = new MArrayList();
        MArrayList instance = new MArrayList();
        
        String h = "Hola";
        String a = "a";
        String uno = "1";
        
        l.add(h);
        l.add(h);
        l.add(null);
        l.add(a);
        
        instance.add(h);   
        instance.add(null);
        instance.add(uno);
        
        
        MList expResult = new MArrayList();
        expResult.add(a);
        expResult.add(uno);
        
        MList result = instance.difference(l);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of removeElements method, of class MArrayList.
     */
    @Test
    public void testRemoveElements() {
        System.out.println("removeElements");
        MList l = new MArrayList();
        MArrayList instance = new MArrayList();
        
        String h = "Hola";
        String a = "a";
        String uno = "1";
        
        instance.add(h);
        instance.add(h);
        instance.add(null);
        instance.add(uno);
        
        l.add(h);
        l.add(null);
        l.add(a);
        
        
        MList expResult = new MArrayList();
        expResult.add(uno);
        
        MList result = instance.removeElements(l);
        assertEquals(expResult, result);
    }
    
}
