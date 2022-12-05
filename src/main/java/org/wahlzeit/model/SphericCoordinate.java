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

    public void setLatitude(double latitude) {
        assertClassInvariants();
        this.latitude = latitude;
        assertClassInvariants();
    }

    public void setLongitude(double longitude) {
        assertClassInvariants();
        this.longitude = longitude;
        assertClassInvariants();
    }

    public void setRadius(double radius) {
        assertClassInvariants();
        this.radius = radius;
        assertClassInvariants();
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
        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

}
