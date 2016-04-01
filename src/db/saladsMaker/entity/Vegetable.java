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
@DatabaseTable(tableName = "Table_Vegetables")
public class Vegetable implements HasId {

    public Vegetable(int id, Name name, Price price, EnergeticValue energeticValue) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.energeticValue = energeticValue;
    }
    
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(columnName = "idName", foreign = true, foreignAutoRefresh = true)
    private Name name;
    
    @DatabaseField(columnName = "idPrice", foreign = true, foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 3)
    private Price price;
    
    @DatabaseField(columnName = "idEnergeticValue", foreign = true, foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 3)
    private EnergeticValue energeticValue;
    
    public Vegetable(){}
    
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
    
    public Price getPrice(){
        return price;
    }
    
    public void setPrice(Price price){
        this.price = price;
    }
    
    public EnergeticValue getEnergeticValue(){
        return energeticValue;
    }
    
    public void setEnergeticValue(EnergeticValue energeticValue){
        this.energeticValue = energeticValue;
    }
    
    @Override
    public String toString() {
        return "Vegetable{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", energeticValue=" + energeticValue +
                '}';
    }
    
}
