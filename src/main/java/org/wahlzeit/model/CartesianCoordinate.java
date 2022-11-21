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
        return this.x;
    }

    /**
     * 
     */
    public double getY() {
        return this.y;
    }

    /**
     * 
     */
    public double getZ() {
        return this.z;
    }

    /**
     * 
     */
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getDistance(CartesianCoordinate c) {
        double partX = Math.pow((c.x - this.x), 2);
        double partY = Math.pow((c.y - this.y), 2);
        double partZ = Math.pow((c.z - this.z), 2);

        return Math.sqrt(partX + partY + partZ);
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }


    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt((x * x) + (y * y) + (z * z));
        double latitude = Math.acos(z / radius);
        double longitude = Math.atan2(y, x);
        return new SphericCoordinate(latitude, longitude, radius);
    }

    @Override
    public double getCentralAngle(Coordinate c) {
        SphericCoordinate p1 = this.asSphericCoordinate();
        SphericCoordinate p2 = c.asSphericCoordinate();

        return p1.getCentralAngle(p2);
    }

    @Override
    public boolean isEqual(Coordinate c) {
        CartesianCoordinate coordinate = c.asCartesianCoordinate();
        double dx = Math.abs(this.x - coordinate.getX());
        double dy = Math.abs(this.y - coordinate.getY());
        double dz = Math.abs(this.z - coordinate.getZ());

        return dx < TOLERANCE && dy < TOLERANCE && dz < TOLERANCE;
    }

}