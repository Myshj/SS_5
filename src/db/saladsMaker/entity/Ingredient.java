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
@DatabaseTable(tableName = "Table_Ingredients")
public class Ingredient implements HasId {

    public Ingredient(int id, Vegetable vegetable, Weight weight, Salad salad) {
        this.id = id;
        this.vegetable = vegetable;
        this.weight = weight;
        this.salad = salad;
    }
    
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(columnName = "idVegetable", foreign = true, foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 4)
    private Vegetable vegetable;
    
    @DatabaseField(columnName = "idWeight", foreign = true, foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 4)
    private Weight weight;
    
    @DatabaseField(columnName = "idSalad", foreign = true, foreignAutoRefresh = true)
    private Salad salad;
    
    public Ingredient(){
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public Vegetable getVegetable(){
        return vegetable;
    }
    
    public void setVegetable(Vegetable vegetable){
        this.vegetable = vegetable;
    }
    
    public Weight getWeight(){
        return weight;
    }
    
    public void setWeight(Weight weight){
        this.weight = weight;
    }
    
    public Salad getSalad(){
        return salad;
    }
    
    public void setSalad(Salad salad){
        this.salad = salad;
    }
    
    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", vegetable=" + vegetable +
                ", weight=" + weight +
                ", salad=" + salad +
                '}';
    }
}
