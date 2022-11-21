package org.wahlzeit.model;


public abstract class AbstractCoordinate implements Coordinate{

    protected static final double TOLERANCE = 0.000001;

    @Override
    public double getCartesianDistance(Coordinate c) {
        return this.asCartesianCoordinate().getDistance(c.asCartesianCoordinate());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        if(o == null){
            return false;
        }
        if(!(o instanceof Coordinate)){
            return false;
        }
        
        return this.isEqual((Coordinate) o);
    }
    
}
