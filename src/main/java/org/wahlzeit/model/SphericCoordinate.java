package org.wahlzeit.model;


public class SphericCoordinate extends AbstractCoordinate {

    private double latitude;
    private double longitude;
    private double radius;

    public SphericCoordinate(double latitude, double longitude, double radius) {
        
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getLatitude() {
        return this.latitude;
    }

    /**
     * 
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * 
     */
    public double getRadius() {
        return this.radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(latitude) * Math.cos(longitude);
        double y = radius * Math.sin(latitude) * Math.sin(longitude);
        double z = radius * Math.cos(latitude);
        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    /* (non-Javadoc)
     * @see org.wahlzeit.model.Coordinate#getCentralAngle(org.wahlzeit.model.Coordinate)
     */
    @Override
    public double getCentralAngle(Coordinate c) {
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

            return 2 * Math.asin(C / 2);
        }
        throw new ArithmeticException("in getCentralAngle both radii are not equal");
    }

    @Override
    public boolean isEqual(Coordinate c) {
        SphericCoordinate coordinate = c.asSphericCoordinate();
        double dLongitude = Math.abs(this.longitude - coordinate.getLongitude());
        double dLatitude = Math.abs(this.latitude - coordinate.getLatitude());
        double dRadius = Math.abs(this.radius - coordinate.getRadius());
        return dLongitude < TOLERANCE && dLatitude < TOLERANCE && dRadius < TOLERANCE;
    }

}
