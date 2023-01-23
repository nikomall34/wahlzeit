package org.wahlzeit.model;


public class SphericCoordinate extends AbstractCoordinate {

    protected double latitude;
    protected double longitude;
    protected double radius;

    public SphericCoordinate(double latitude, double longitude, double radius) {
        
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public SphericCoordinate setLatitude(double latitude) {
        assertClassInvariants();
        SphericCoordinate res = getSphericCoordinate(latitude, this.longitude, this.radius);
        res.assertClassInvariants();
        assertClassInvariants();
        return res;
    }

    public SphericCoordinate setLongitude(double longitude) {
        assertClassInvariants();
        SphericCoordinate res = getSphericCoordinate(this.latitude, longitude, this.radius);
        res.assertClassInvariants();
        assertClassInvariants();
        return res;
    }

    public SphericCoordinate setRadius(double radius) {
        assertClassInvariants();
        SphericCoordinate res = getSphericCoordinate(this.latitude, this.longitude, radius);
        res.assertClassInvariants();
        assertClassInvariants();
        return res;
    }

    public double getLatitude() {
        assertClassInvariants();
        return this.latitude;
    }

    /**
     * 
     */
    public double getLongitude() {
        assertClassInvariants();
        return this.longitude;
    }

    /**
     * 
     */
    public double getRadius() {
        assertClassInvariants();
        return this.radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();
        double x = radius * Math.sin(latitude) * Math.cos(longitude);
        double y = radius * Math.sin(latitude) * Math.sin(longitude);
        double z = radius * Math.cos(latitude);
        CartesianCoordinate erg = getCartesianCoordinate(x, y, z);
        erg.assertClassInvariants();
        return erg;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

}
