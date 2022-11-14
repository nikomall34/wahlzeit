package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlowerPhoto extends Photo{
    public FlowerPhoto() {
        super();
        
    }

    public FlowerPhoto(PhotoId id){
        super(id);
    }

    public FlowerPhoto(ResultSet rs) throws SQLException{
        super(rs);
    }
}
