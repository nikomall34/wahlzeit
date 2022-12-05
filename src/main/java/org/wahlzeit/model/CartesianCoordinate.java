package org.wahlzeit.model;


public class CartesianCoordinate extends AbstractCoordinate {
    /**
     * 
     */
    private double x;
    private double y;
    private double z;

    /**
     * 
     */
    public CartesianCoordinate(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 
     */
    public double getX() {
        assertClassInvariants();
        return this.x;
    }

    /**
     * 
     */
    public double getY() {
        assertClassInvariants();
        return this.y;
    }

    /**
     * 
     */
    public double getZ() {
        assertClassInvariants();
        return this.z;
    }

    /**
     * 
     */
    public void setX(double x) {
        assertClassInvariants();
        this.x = x;
        assertClassInvariants();
    }

    public void setY(double y) {
        assertClassInvariants();
        this.y = y;
        assertClassInvariants();
    }

    public void setZ(double z) {
        assertClassInvariants();
        this.z = z;
        assertClassInvariants();
    }

    public double getDistance(CartesianCoordinate c) {
        
        double partX = Math.pow((c.x - this.x), 2);
        double partY = Math.pow((c.y - this.y), 2);
        double partZ = Math.pow((c.z - this.z), 2);

        return Math.sqrt(partX + partY + partZ);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();
        return this;
    }


    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt((x * x) + (y * y) + (z * z));
        double latitude = Math.acos(z / radius);
        double longitude = Math.atan2(y, x);
        SphericCoordinate erg = new SphericCoordinate(latitude, longitude, radius);
        erg.assertClassInvariants();
        return erg;
    }


}