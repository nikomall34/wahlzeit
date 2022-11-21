package org.wahlzeit.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.services.DataObject;

public class Location extends DataObject{

    
    /**
	 * 0 is never returned, first value is 1
	 */
	protected static int lastLocationId = 0;
	
	/**
	 * 
	 */
	public static int getLastLocationId() {
		return lastLocationId;
	}
	
	/**
	 * 
	 */
	public static synchronized void setLastLocationId(int newId) {
		lastLocationId = newId;
	}
	
	/**
	 * 
	 */
	public static synchronized int getNextLocationId() {
		return ++lastLocationId;
	}


    /**
	 * 
	 */
    public Coordinate coordinate;
    protected int id;


    public Location(Coordinate coordinate){
        this.coordinate = coordinate;

        id = getNextLocationId();
    } 

    public int getId(){
        return id;
    }

    @Override
    public String getIdAsString() {
        // TODO Auto-generated method stub
        return String.valueOf(id);
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        id = rset.getInt("id");

        double x = rset.getDouble("x");
        double y = rset.getDouble("y");
        double z = rset.getDouble("z");

        coordinate = new CartesianCoordinate(x, y, z);
        
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateInt("id", id);

        CartesianCoordinate cc = coordinate.asCartesianCoordinate();
        SphericCoordinate sc = coordinate.asSphericCoordinate();
        rset.updateDouble("x", cc.getX());
        rset.updateDouble("y", cc.getY());
        rset.updateDouble("z", cc.getZ());
        
        rset.updateDouble("latitude", sc.getLatitude());
        rset.updateDouble("longitude", sc.getLongitude());
        rset.updateDouble("radius", sc.getRadius());


    }

    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {
        stmt.setInt(pos, id);
    }


    
}