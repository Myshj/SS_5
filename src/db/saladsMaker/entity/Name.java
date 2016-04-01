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
@DatabaseTable(tableName = "Table_Names")
public class Name implements HasId{
    
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(columnName = "name")
    private String name;

    public Name() {
        this(0, null);
    }
    
    public Name(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
