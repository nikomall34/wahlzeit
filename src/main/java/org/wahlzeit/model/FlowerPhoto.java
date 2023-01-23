package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlowerPhoto extends Photo {
    public FlowerPhoto() {
        super();
    }

    public FlowerPhoto(PhotoId id){
        super(id);
        if (id == null){
            throw new NullPointerException("PhotoId is null.");
        }
    }

    public FlowerPhoto(ResultSet rs) throws SQLException{
        super(rs);
        if (rs == null){
            throw new NullPointerException("ResultSet is null.");
        }
    }
}
