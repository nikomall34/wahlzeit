package org.wahlzeit.model;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractCoordinate implements Coordinate {

    protected static final double TOLERANCE = 0.000001;
    protected static List<CartesianCoordinate> allCartesianCoordinates = new LinkedList<>();
    protected static List<SphericCoordinate> allSphericCoordinates = new LinkedList<>();

    @Override
    public double getCartesianDistance(Coordinate c) {
        assertClassInvariants();
        assertIsNonNullArgument(c);
        ((AbstractCoordinate) c).assertClassInvariants();

        double erg = this.asCartesianCoordinate().getDistance(c.asCartesianCoordinate());
        
        ((AbstractCoordinate) c).assertClassInvariants();
        assertClassInvariants();
        return erg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Coordinate)) {
            return false;
        }

        return this.isEqual((Coordinate) o);
    }

    @Override
    public double getCentralAngle(Coordinate c) {
        assertClassInvariants();
        assertIsNonNullArgument(c);
        ((AbstractCoordinate) c).assertClassInvariants();

        SphericCoordinate p1 = this.asSphericCoordinate();
        SphericCoordinate p2 = c.asSphericCoordinate();

        if (p1.getRadius() == p2.getRadius()) {
            double longitude1 = p1.getLongitude();
            double latitude1 = (Math.PI / 2) - p1.getLatitude();

            double longitude2 = p2.getLongitude();
            double latitude2 = (Math.PI / 2) - p2.getLatitude();

            double deltaX = Math.cos(latitude2) * Math.cos(longitude2) -
                    Math.cos(latitude1) * Math.cos(longitude1);
            double deltaY = Math.cos(latitude2) * Math.sin(longitude2) -
                    Math.cos(latitude1) * Math.sin(longitude1);
            double deltaZ = Math.sin(latitude2) - Math.sin(latitude1);

            double C = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

            double erg = 2 * Math.asin(C / 2);
            ((AbstractCoordinate) c).assertClassInvariants();
            assertClassInvariants();
            return erg;
        }
        throw new ArithmeticException("in getCentralAngle both radii are not equal");
    }

    @Override
    public boolean isEqual(Coordinate c) {
        assertClassInvariants();
        assertIsNonNullArgument(c);
        ((AbstractCoordinate) c).assertClassInvariants();

        boolean erg = this.getCartesianDistance(c) < TOLERANCE;

        ((AbstractCoordinate) c).assertClassInvariants();
        assertClassInvariants();
        return erg;
    }

    protected void assertClassInvariants() {
        SphericCoordinate s = this.asSphericCoordinate();
        double longitude = s.longitude;
        double latitude = s.latitude;
        double radius = s.radius;

        assert !Double.isNaN(radius) && !Double.isNaN(longitude) && !Double.isNaN(latitude);
        assert (longitude >= -1 * Math.PI) && (longitude <= Math.PI);
        assert latitude >= 0 && latitude <= Math.PI;
        assert radius >= 0;
    }

    protected void assertIsNonNullArgument(Coordinate c) {
        assert c != null;
    }

    //TODO maybe add class Invariants
    protected CartesianCoordinate getCartesianCoordinate(double x, double y, double z){
        for(CartesianCoordinate c : allCartesianCoordinates){
            if(c.getX() == x && c.getY() == y && c.getZ() == z){
                return c;
            }
        }
        return new CartesianCoordinate(x, y, z);
    }

    protected SphericCoordinate getSphericCoordinate(double latitude, double longitude, double radius){
        for (SphericCoordinate s : allSphericCoordinates){
            if(s.getLatitude() == latitude && s.getLongitude() == longitude && s.getRadius() == radius){
                return s;
            }
        }
        return new SphericCoordinate(latitude, longitude, radius);
    }
}
