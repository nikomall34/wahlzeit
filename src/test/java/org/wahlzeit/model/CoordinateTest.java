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
    public void setterGetterXTest(){
        Coordinate c = new Coordinate(4, 5, 7);
        assertEquals(c.getX(), 4, 0);

        c.setX(9);
        assertEquals(c.getX(), 9, 0);
    }

    @Test
    public void getDistanceTest(){
        Coordinate c1 = new Coordinate(6, 9, 10);
        Coordinate c2 = new Coordinate(10, 23, 37);
        
        assertEquals(c1.getDistance(c2), 30.6757233, 0.0000001);
    }

    @Test
    public void isEqualTest(){
        Coordinate c1 = new Coordinate(6, 9, 10);
        Coordinate c2 = new Coordinate(10, 23, 37);
        Coordinate c3 = new Coordinate(10, 23, 37);

        assertTrue(c2.isEqual(c3));
        assertFalse(c1.isEqual(c3));
    }
}