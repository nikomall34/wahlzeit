package org.wahlzeit.model;

public class Coordinate {
    /**
	 * 
	 */
    private double x;
    private double y;
    private double z;

    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){
        return this.x;
    }


    public double getY(){
        return this.y;
    }


    public double getZ(){
        return this.z;
    }

    public void setX(double x){
        this.x = x;
    }


    public void setY(double y){
        this.y = y;
    }


    public void setZ(double z){
        this.z = z;
    }

    public double getDistance(Coordinate c){
        double partX = Math.pow((c.x - this.x), 2);
        double partY = Math.pow((c.y - this.y), 2);
        double partZ = Math.pow((c.z - this.z), 2);

        return Math.sqrt(partX + partY + partZ);
    }

    public boolean isEqual(Coordinate c){
        return this.x == c.x && this.y == c.y && this.z == c.z;
    }
}   