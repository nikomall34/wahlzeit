package org.wahlzeit.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class FlowerType extends DataObject {
    
    protected FlowerType superType = null;
    protected Set<FlowerType> subTypes = new HashSet<FlowerType>();
    protected String name;


    public FlowerType(String name) {
        this.name = name;
    }

    public FlowerType getSuperType() {
        return superType;
    }

    public Iterator<FlowerType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(FlowerType ft) {
        assert (ft != null) : "tried to set null sub-type";
        ft.setSuperType(this);
        subTypes.add(ft);
    }

    public void setSuperType(FlowerType ft){
        this.superType = ft;
    }
    
    public Flower createInstance() {
        return new Flower(this);
    }

    public boolean hasInstance(Flower flower) {
        assert (flower != null) : "asked about null object";

        if (flower.getType() == this) {
            return true;
        }

        for (FlowerType type : subTypes) {
            if (type.hasInstance(flower)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubtype(){
        return superType != null;
    }

    @Override
    public String getIdAsString() {
        // TODO Auto-generated method stub
        return null;
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
