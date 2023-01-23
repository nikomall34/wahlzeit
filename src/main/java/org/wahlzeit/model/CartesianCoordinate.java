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
    public CartesianCoordinate setX(double x) {
        assertClassInvariants();
        CartesianCoordinate res = getCartesianCoordinate(x, this.y, this.z);
        res.assertClassInvariants();
        assertClassInvariants();
        return res;
    }

    public CartesianCoordinate setY(double y) {
        assertClassInvariants();
        CartesianCoordinate res = getCartesianCoordinate(this.x, y, this.z);
        res.assertClassInvariants();
        assertClassInvariants();
        return res;
    }

    public CartesianCoordinate setZ(double z) {
        assertClassInvariants();
        CartesianCoordinate res = getCartesianCoordinate(this.x, this.y, z);
        res.assertClassInvariants();
        assertClassInvariants();
        return res;
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
        SphericCoordinate erg = getSphericCoordinate(latitude, longitude, radius);
        erg.assertClassInvariants();
        return erg;
    }


}