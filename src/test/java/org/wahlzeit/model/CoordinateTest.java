package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {

    /**
     * 
     */
    @Test
    public void setterGetterXTest() {
        CartesianCoordinate c = new CartesianCoordinate(4, 5, 7);
        assertEquals(c.getX(), 4, 0);

        CartesianCoordinate newc = c.setX(9);
        assertEquals(newc.getX(), 9, 0);
    }

    @Test
    public void getDistanceTest() {
        CartesianCoordinate c1 = new CartesianCoordinate(6, 9, 10);
        CartesianCoordinate c2 = new CartesianCoordinate(10, 23, 37);

        assertEquals(c1.getDistance(c2), 30.6757233, 0.0000001);

    }

    /**
     * 
     */
    @Test
    public void isEqualTest(){
        CartesianCoordinate c1 = new CartesianCoordinate(6, 9, 10);
        CartesianCoordinate c2 = new CartesianCoordinate(10, 23, 37);
        AbstractCoordinate c3 = new CartesianCoordinate(10, 23, 37);

        SphericCoordinate s1 = new SphericCoordinate(2, 3, 5);
        SphericCoordinate s2 = new SphericCoordinate(2, 3, 5);
        SphericCoordinate s3 = new SphericCoordinate(1, 2, 37);
        AbstractCoordinate s4 = new SphericCoordinate(0.59569430583359, 1.1606689862534, 44.698993277254);
        

        assertTrue(c2.isEqual(c3));
        assertTrue(s1.isEqual(s2));
        assertFalse(c1.isEqual(c3));
        assertFalse(s1.isEqual(s3));
        assertFalse(s3.isEqual(c3));
        assertFalse(c2.isEqual(s3));
        assertTrue(c3.equals(s4));
        assertTrue(s4.equals(c3));
    }

    @Test
    public void asCartesianCoordinateTest() {
        CartesianCoordinate c1 = new CartesianCoordinate(6, 9, 10);
        SphericCoordinate s1 = new SphericCoordinate(1.0457184268647,1.144168833668 ,13.964240043769);

        CartesianCoordinate test1 = c1.asCartesianCoordinate();
        CartesianCoordinate test2 = s1.asCartesianCoordinate();

        assertEquals(test1.getX(), c1.getX(), 0);
        assertEquals(test1.getY(), c1.getY(), 0);
        assertEquals(test1.getZ(), c1.getZ(), 0);

        assertEquals(test2.getX(), 5, 0.0000001);
        assertEquals(test2.getY(), 11, 0.0000001);
        assertEquals(test2.getZ(), 7, 0.0000001);
    }

    @Test
    public void asSphericCoordinateTest() {
        CartesianCoordinate c1 = new CartesianCoordinate(6, 9, 10);
        SphericCoordinate s1 = new SphericCoordinate(2, 3, 5);

        SphericCoordinate test1 = c1.asSphericCoordinate();
        SphericCoordinate test2 = s1.asSphericCoordinate();

        assertEquals(test1.getLongitude(), 0.98279372324733, 0.0000001);
        assertEquals(test1.getRadius(), 14.730919862656, 0.0000001);
        assertEquals(test1.getLatitude(), 0.8246088483254, 0.0000001);

        assertEquals(test2.getLongitude(), s1.getLongitude(), 0.0000001);
        assertEquals(test2.getRadius(), s1.getRadius(), 0.0000001);
        assertEquals(test2.getLatitude(), s1.getLatitude(), 0.0000001);
    }

    @Test
    public void getCentralAngleTest() {

    }

    @Test
    public void assertTest(){
        try{
            SphericCoordinate t1 = new SphericCoordinate(1, 2, 1);
            t1.setRadius(1);
            assertTrue(true);
        }
        catch(AssertionError a){
            assertTrue(false);
        }
        catch(Exception a){
            assertTrue(false);
        }

        try{
            SphericCoordinate t2 = new SphericCoordinate(100, 2, -1);
            t2.setRadius(0);
            assertTrue(false);
        }
        catch(AssertionError a){
            assertTrue(true);
        }
        catch(Exception a){
            assertTrue(true);
        }

        try{
            CartesianCoordinate c = new CartesianCoordinate(Double.NaN, Double.NaN, Double.NaN);
            c.setX(0);
            assertTrue(false);
        }
        catch(AssertionError a){
            assertTrue(true);
        }
        catch(Exception a){
            assertTrue(true);
        }

        try{
            SphericCoordinate t2 = new SphericCoordinate(100, 2, -1);
            t2.setRadius(0);
            assertTrue(false);
        }
        catch(AssertionError a){
            assertTrue(true);
        }
        catch(Exception a){
            assertTrue(true);
        }
    }
}