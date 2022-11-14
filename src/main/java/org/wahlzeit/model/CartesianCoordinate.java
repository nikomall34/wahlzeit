package org.wahlzeit.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.services.DataObject;

public class CartesianCoordinate extends DataObject implements Coordinate {
    /**
	 * 
	 */
    private double x;
    private double y;
    private double z;

    /**
	 * 
	 */
    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
	 * 
	 */
    public double getX(){
        return this.x;
    }

    /**
	 * 
	 */
    public double getY(){
        return this.y;
    }

    /**
	 * 
	 */
    public double getZ(){
        return this.z;
    }

    /**
	 * 
	 */
    public void setX(double x){
        this.x = x;
    }


    public void setY(double y){
        this.y = y;
    }


    public void setZ(double z){
        this.z = z;
    }

    public double getDistance(CartesianCoordinate c){
        double partX = Math.pow((c.x - this.x), 2);
        double partY = Math.pow((c.y - this.y), 2);
        double partZ = Math.pow((c.z - this.z), 2);

        return Math.sqrt(partX + partY + partZ);
    }

    @Override
    public String getIdAsString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        x = rset.getDouble("x");
        y = rset.getDouble("y");
        z = rset.getDouble("z");
        
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateDouble("x", x);
        rset.updateDouble("y", y);
        rset.updateDouble("z", z);

        
    }

    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate c) {
        return this.getDistance(c.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt((x * x) + (y * y) + (z * z));
        double theta = Math.acos(z / radius);
        double phi = Math.atan2(y, x);
        return new SphericCoordinate(phi, theta, radius);
    }

    @Override
    public double getCentralAngle(Coordinate c) {
        SphericCoordinate p1 = this.asSphericCoordinate();
        SphericCoordinate p2 = c.asSphericCoordinate();

        return p1.getCentralAngle(p2);
    }

    @Override
    public boolean isEqual(Coordinate c) {
        if (c instanceof CartesianCoordinate){
            CartesianCoordinate coordinate = c.asCartesianCoordinate();
            
            return this.x == coordinate.getX() && this.y == coordinate.getY() 
                && this.z == coordinate.getZ();
        } 
        return false;
    }

}   