package org.wahlzeit.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.services.DataObject;

public class Flower extends DataObject {
    
    /**
	 * 0 is never returned, first value is 1
	 */
	protected static int lastFlowerId = 0;
	
	/**
	 * 
	 */
	public static int getLastFlowerId() {
		return lastFlowerId;
	}
	
	/**
	 * 
	 */
	public static synchronized void setLastFlowerId(int newId) {
		lastFlowerId = newId;
	}
	
	/**
	 * 
	 */
	public static synchronized int getNextFlowerId() {
		return ++lastFlowerId;
	}
    
    protected FlowerType flowerType = null;
    protected int id;

    public Flower(FlowerType flowerType){
        this.flowerType = flowerType;
        id = getNextFlowerId();
    }

    public Flower(ResultSet rset) throws SQLException {
        if(rset == null) {
            throw new NullPointerException("ResultSet is null.");
        }
        readFrom(rset);
    }

    public FlowerType getType() {
        return flowerType;
    }

    public void setType(FlowerType flowerType){
        this.flowerType = flowerType;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getIdAsString() {
        // TODO Auto-generated method stub
        return String.valueOf(id);
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {
        // TODO Auto-generated method stub
        
    }
}
