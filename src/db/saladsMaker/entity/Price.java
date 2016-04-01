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
@DatabaseTable(tableName = "Table_Price")
public class Price implements HasId {

    public Price(int id, Cost cost, Weight weight) {
        this.id = id;
        this.cost = cost;
        this.weight = weight;
    }
    
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(columnName = "idCost", foreign = true, foreignAutoRefresh = true)
    private Cost cost;
    
    @DatabaseField(columnName = "idWeight", foreign = true, foreignAutoRefresh = true)
    private Weight weight;
    
    public Price(){
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public Cost getCost(){
        return cost;
    }
    
    public void setCost(Cost cost){
        this.cost = cost;
    }
    
    public Weight getWeight(){
        return weight;
    }
    
    public void setWeight(Weight weight){
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
