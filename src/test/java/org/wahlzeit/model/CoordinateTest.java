package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class CoordinateTest {
    
    /**
     * 
     */
    @Test
    public void setterGetterXTest(){
        Coordinate c = new Coordinate(4, 5, 7);
        assertEquals(c.getX(), 4, 0);

        c.setX(8);
        assertEquals(c.getX(), 8, 0);
    }
}