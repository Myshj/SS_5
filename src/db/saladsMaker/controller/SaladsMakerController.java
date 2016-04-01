/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.saladsMaker.controller;

import db.saladsMaker.service.Table;

import db.saladsMaker.entity.*;

/**
 *
 * @author Alexey
 */
public class SaladsMakerController {
    
    private Table<Cost> costService;
    
    private Table<EnergeticValue> energeticValueService;
    
    private Table<Energy> energyService;
    
    private Table<Ingredient> ingredientService;
    
    private Table<Name> nameService;
    
    private Table<Price> priceService;
    
    private Table<Salad> saladService;
    
    private Table<Vegetable> vegetableService;
    
    private Table<Weight> weightService;

    public SaladsMakerController(
            Table<Cost> costService, 
            Table<EnergeticValue> energeticValueService, 
            Table<Energy> energyService, 
            Table<Ingredient> ingredientService, 
            Table<Name> nameService, 
            Table<Price> priceService, 
            Table<Salad> saladService, 
            Table<Vegetable> vegetableService,
            Table<Weight> weightService
    ) {
        this.costService = costService;
        this.energeticValueService = energeticValueService;
        this.energyService = energyService;
        this.ingredientService = ingredientService;
        this.nameService = nameService;
        this.priceService = priceService;
        this.saladService = saladService;
        this.vegetableService = vegetableService;
        this.weightService = weightService;
    }

    public Table<Cost> getCostService() {
        return costService;
    }

    public void setCostService(Table<Cost> costService) {
        this.costService = costService;
    }

    public Table<EnergeticValue> getEnergeticValueService() {
        return energeticValueService;
    }

    public void setEnergeticValueService(Table<EnergeticValue> energeticValueService) {
        this.energeticValueService = energeticValueService;
    }

    public Table<Energy> getEnergyService() {
        return energyService;
    }

    public void setEnergyService(Table<Energy> energyService) {
        this.energyService = energyService;
    }

    public Table<Ingredient> getIngredientService() {
        return ingredientService;
    }

    public void setIngredientService(Table<Ingredient> ingredientService) {
        this.ingredientService = ingredientService;
    }

    public Table<Name> getNameService() {
        return nameService;
    }

    public void setNameService(Table<Name> nameService) {
        this.nameService = nameService;
    }

    public Table<Price> getPriceService() {
        return priceService;
    }

    public void setPriceService(Table<Price> priceService) {
        this.priceService = priceService;
    }

    public Table<Salad> getSaladService() {
        return saladService;
    }

    public void setSaladService(Table<Salad> saladService) {
        this.saladService = saladService;
    }

    public Table<Vegetable> getVegetableService() {
        return vegetableService;
    }

    public void setVegetableService(Table<Vegetable> vegetableService) {
        this.vegetableService = vegetableService;
    }

    public Table<Weight> getWeightService() {
        return weightService;
    }

    public void setWeightService(Table<Weight> weightService) {
        this.weightService = weightService;
    }
}
