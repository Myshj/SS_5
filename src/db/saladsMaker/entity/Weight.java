/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.saladsMaker.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Alexey
 */
@DatabaseTable(tableName = "Table_Weight")
public class Weight implements HasId {

    public Weight(int id, Name name, float count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
    
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(columnName = "idMeasurementName", foreign = true, foreignAutoRefresh = true)
    private Name name;
    
    @DatabaseField(columnName = "count")
    private float count;

    public Weight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
    
    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "id=" + id +
                ", name=" + name +
                ", count=" + count +
                '}';
    }
}

