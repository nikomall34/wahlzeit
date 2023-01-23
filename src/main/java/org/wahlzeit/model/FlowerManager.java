package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

public class FlowerManager extends ObjectManager {
    

    protected static FlowerManager instance = new FlowerManager();

    protected Map<Integer, Flower> flowers = new HashMap<>();
    protected Map<String, FlowerType> flowerTypes = new HashMap<>();

    private FlowerManager(){

    }

    public FlowerManager getInstance(){
        return instance;
    }

    public Flower createFlower(String typeName) {
        assertIsValidFlowerTypeName(typeName);
        FlowerType ft = getFlowerType(typeName);
        Flower result = ft.createInstance();
        flowers.put(result.getId(), result);
        return result;
    }

    private void assertIsValidFlowerTypeName(String typeName) {
        char[] chars = typeName.toCharArray();

        for(char c : chars) {
            assert (!Character.isLetter(c)) : "flowername contains other characters than just letters";
        }
    }

    private FlowerType getFlowerType(String typeName) {
        FlowerType ret = flowerTypes.get(typeName);
        if(ret == null){
            return new FlowerType(typeName);
        }
        return ret;
    }

    @Override
    protected Persistent createObject(ResultSet rset) throws SQLException {
        // TODO Auto-generated method stub
        return new Flower(rset);
    }
}
