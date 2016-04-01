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
@DatabaseTable(tableName = "Table_EnergeticValue")
public class EnergeticValue implements HasId {

    public EnergeticValue(int id, Energy energy, Weight weight) {
        this.id = id;
        this.energy = energy;
        this.weight = weight;
    }
    
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField(columnName = "idEnergy", foreign = true, foreignAutoRefresh = true)
    private Energy energy;
    
    @DatabaseField(columnName = "idWeight", foreign = true, foreignAutoRefresh = true)
    private Weight weight;
    
    public EnergeticValue(){
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public Energy getEnergy(){
        return energy;
    }
    
    public void setEnergy(Energy energy){
        this.energy = energy;
    }
    
    public Weight getWeight(){
        return weight;
    }
    
    public void setWeight(Weight weight){
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return "EnergeticValue{" +
                "id=" + id +
                ", energy=" + energy +
                ", weight=" + weight +
                '}';
    }
}
