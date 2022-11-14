package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{

    private double phi;
    private double theta;
    private double radius;

    public SphericCoordinate(double phi, double theta, double radius){
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    public void setTheta(double phi){
        this.phi = phi;
    }


    public void setPhi(double theta){
        this.theta = theta;
    }


    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getPhi(){
        return this.phi;
    }

    /**
	 * 
	 */
    public double getTheta(){
        return this.theta;
    }

    /**
	 * 
	 */
    public double getRadius(){
        return this.radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);
        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public double getCartesianDistance(Coordinate c) {
        return this.asCartesianCoordinate().getDistance(c.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate c) {
        SphericCoordinate p1 = this.asSphericCoordinate();
        SphericCoordinate p2 = c.asSphericCoordinate();

        if(p1.getRadius() == p2.getRadius()) {
            double longitude1 = p1.getPhi();
            double latitude1 = (Math.PI / 2) - p1.getTheta();
            
            double longitude2 = p2.getPhi();
            double latitude2 = (Math.PI / 2) - p2.getTheta();

            double deltaX = Math.cos(latitude2) * Math.cos(longitude2) - 
                            Math.cos(latitude1) * Math.cos(longitude1);
            double deltaY = Math.cos(latitude2) * Math.sin(longitude2) - 
                            Math.cos(latitude1) * Math.sin(longitude1);
            double deltaZ = Math.sin(latitude2) - Math.sin(latitude1);

            double C = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);

            return 2 * Math.asin(C / 2);
        }
        return -1;
    }

    @Override
    public boolean isEqual(Coordinate c) {
        if (c instanceof SphericCoordinate){
            SphericCoordinate coordinate = c.asSphericCoordinate();
            
            return this.phi == coordinate.getPhi() && this.theta == coordinate.getTheta() 
                && this.radius == coordinate.getRadius();
        } 
        return false;
    }

}
