/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.saladsMaker.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.dao.ForeignCollection;
/**
 *
 * @author Alexey
 */
@DatabaseTable(tableName = "Table_Salads")
public class Salad implements HasId {
    
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(columnName = "idName", foreign = true, foreignAutoRefresh = true)
    private Name name;
    public Salad(){
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public Name getName(){
        return name;
    }
    
    public void setName(Name name){
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Salad{" +
                "id=" + id +
                ",name=" + name +
                "}";
    }

    public Salad(int id, Name name) {
        this.id = id;
        this.name = name;
    }
}
