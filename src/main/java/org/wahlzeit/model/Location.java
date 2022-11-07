package org.wahlzeit.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.services.DataObject;

public class Location extends DataObject{

    /**
	 * 
	 */
    public Coordinate coordinate;

    @Override
    public String getIdAsString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        // TODO Auto-generated method stub
        String[] coordinate_str = rset.getString("coordinate").split("\\s+");
        coordinate.setX(Double.parseDouble(coordinate_str[0]));
        coordinate.setY(Double.parseDouble(coordinate_str[1]));
        coordinate.setZ(Double.parseDouble(coordinate_str[2]));
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        // TODO Auto-generated method stub
        String coordinate_str = "";
        coordinate_str += String.valueOf(coordinate.getX());
        coordinate_str += " " + String.valueOf(coordinate.getY());
        coordinate_str += " " + String.valueOf(coordinate.getZ());
        rset.updateString("coordinate", coordinate_str);
    }

    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {
        // TODO Auto-generated method stub
        
    }


    
}