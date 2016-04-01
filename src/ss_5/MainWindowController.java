/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss_5;

import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


//import models.Name;

import db.saladsMaker.controller.SaladsMakerController;
import db.saladsMaker.service.Table;
import db.saladsMaker.entity.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

//import saladsMaker.Tables.*;

/**
 *
 * @author Alexey
 */
public class MainWindowController implements Initializable {
    
    private final String URL = "jdbc:sqlite:Vegetables.db";
       
    private SaladsMakerController saladsMakerController;
    
    @FXML
    TextArea namesText;   
    @FXML
    TextArea weightsText;    
    @FXML
    TextArea energiesText;  
    @FXML
    TextArea costsText;    
    @FXML
    TextArea pricesText;   
    @FXML
    TextArea energeticValuesText; 
    @FXML
    TextArea vegetablesText;   
    @FXML
    TextArea saladsText;   
    @FXML
    TextArea ingredientsText;
    
    
    @FXML
    TextField createNameId;   
    @FXML
    TextField createNameName;
    
    
    
    @FXML
    TextField createWeightId;    
    @FXML
    TextField createWeightCount;
    @FXML
    TextField createWeightNameId;
    
    
    @FXML
    TextField createEnergyId;    
    @FXML
    TextField createEnergyCount;
    @FXML
    TextField createEnergyNameId;
    
    @FXML
    TextField createCostId;    
    @FXML
    TextField createCostCount;
    @FXML
    TextField createCostNameId;
    
    @FXML
    TextField createPriceId;
    @FXML
    TextField createPriceCostId;
    @FXML
    TextField createPriceWeightId;
    
    @FXML
    TextField createEnergeticValueId;
    @FXML
    TextField createEnergeticValueEnergyId;
    @FXML
    TextField createEnergeticValueWeightId;
    
    @FXML
    TextField createVegetableId;    
    @FXML
    TextField createVegetableNameId;
    @FXML
    TextField createVegetablePriceId;
    @FXML
    TextField createVegetableEnergeticValueId;
    
    @FXML
    TextField createSaladId;
    @FXML
    TextField createSaladNameId;
    
    @FXML
    TextField createIngredientId;    
    @FXML
    TextField createIngredientVegetableId;
    @FXML
    TextField createIngredientWeightId;
    @FXML
    TextField createIngredientSaladId;
    
    
    @FXML
    TextField deleteNameId;
    @FXML
    TextField deleteWeightId;
    @FXML
    TextField deleteEnergyId;
    @FXML
    TextField deleteCostId;
    @FXML
    TextField deletePriceId;
    @FXML
    TextField deleteEnergeticValueId;
    @FXML
    TextField deleteVegetableId;
    @FXML
    TextField deleteSaladId;
    @FXML
    TextField deleteIngredientId;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        saladsMakerController = new SaladsMakerController(
                new Table<Cost>(URL, Cost.class),
                new Table<EnergeticValue>(URL, EnergeticValue.class),
                new Table<Energy>(URL, Energy.class),
                new Table<Ingredient>(URL, Ingredient.class),
                new Table<Name>(URL, Name.class),
                new Table<Price>(URL, Price.class),
                new Table<Salad>(URL, Salad.class),
                new Table<Vegetable>(URL, Vegetable.class),
                new Table<Weight>(URL, Weight.class)
        );
        }catch(Exception ex){
            System.out.println("Something went wrong! Exiting...");
            System.exit(1);
        }
    }  
    
    @FXML
    public void viewAllNamesClicked(){
        try{
            namesText.setText(saladsMakerController.getNameService().getStringRepresentation());
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
    }
    
    @FXML
    public void viewAllWeightsClicked(){
        try{
            weightsText.setText(saladsMakerController.getWeightService().getStringRepresentation());
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
    }
    
    @FXML
    public void viewAllEnergiesClicked(){
        try{
            energiesText.setText(saladsMakerController.getEnergyService().getStringRepresentation());
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
    }
    
    @FXML
    public void viewAllCostsClicked(){
        try{
            costsText.setText(saladsMakerController.getCostService().getStringRepresentation());
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
    }
    
    @FXML
    public void viewAllPricesClicked(){
        try{
            pricesText.setText(saladsMakerController.getPriceService().getStringRepresentation());
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
    }
    
    @FXML
    public void viewAllEnergeticValuesClicked(){
        try{
            energeticValuesText.setText(saladsMakerController.getEnergeticValueService().getStringRepresentation());
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
    }
    
    @FXML
    public void viewAllVegetablesClicked(){
        try{
            vegetablesText.setText(saladsMakerController.getVegetableService().getStringRepresentation());
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
    }
    
    @FXML
    public void viewAllSaladsClicked(){
        try{
            saladsText.setText(saladsMakerController.getSaladService().getStringRepresentation());
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
    }
    
    @FXML
    public void viewAllIngredientsClicked(){
        try{
            ingredientsText.setText(saladsMakerController.getIngredientService().getStringRepresentation());
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
    }
    
    @FXML
    public void createNameClicked(){
        try{
            saladsMakerController.getNameService().createOrUpdate(new Name(Integer.parseInt(createNameId.getText()), createNameName.getText()));
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllNamesClicked();
    }
    
    @FXML
    public void createWeightClicked(){
        try{
            saladsMakerController.getWeightService().createOrUpdate(
                    new Weight(
                            Integer.parseInt(createWeightId.getText()),                          
                            saladsMakerController.getNameService().getById(Integer.parseInt(createWeightNameId.getText())),
                            Float.parseFloat(createWeightCount.getText())
                    ));
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllWeightsClicked();
    }
    
    @FXML
    public void createEnergyClicked(){
        try{
            saladsMakerController.getEnergyService().createOrUpdate(
                    new Energy(
                            Integer.parseInt(createEnergyId.getText()),                          
                            saladsMakerController.getNameService().getById(Integer.parseInt(createEnergyNameId.getText())),
                            Float.parseFloat(createEnergyCount.getText())
                    ));
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllEnergiesClicked();
    }
    
    @FXML
    public void createCostClicked(){
        try{
            saladsMakerController.getCostService().createOrUpdate(
                    new Cost(
                            Integer.parseInt(createCostId.getText()),                          
                            saladsMakerController.getNameService().getById(Integer.parseInt(createCostNameId.getText())),
                            Float.parseFloat(createCostCount.getText())
                    ));
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllCostsClicked();
    }
    
    @FXML
    public void createPriceClicked(){
        try{
            saladsMakerController.getPriceService().createOrUpdate(
                    new Price(
                            Integer.parseInt(createPriceId.getText()),
                            saladsMakerController.getCostService().getById(Integer.parseInt(createPriceCostId.getText())),
                            saladsMakerController.getWeightService().getById(Integer.parseInt(createPriceWeightId.getText()))
                    ));
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllPricesClicked();
    }
    
    @FXML
    public void createEnergeticValueClicked(){
        try{
            saladsMakerController.getEnergeticValueService().createOrUpdate(
                    new EnergeticValue(
                            Integer.parseInt(createEnergeticValueId.getText()),
                            saladsMakerController.getEnergyService().getById(Integer.parseInt(createEnergeticValueEnergyId.getText())),
                            saladsMakerController.getWeightService().getById(Integer.parseInt(createEnergeticValueWeightId.getText()))
                    ));
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllEnergeticValuesClicked();
    }
    
    @FXML
    public void createVegetableClicked(){
        try{
            saladsMakerController.getVegetableService().createOrUpdate(
                    new Vegetable(
                            Integer.parseInt(createVegetableId.getText()),
                            saladsMakerController.getNameService().getById(Integer.parseInt(createVegetableNameId.getText())),
                            saladsMakerController.getPriceService().getById(Integer.parseInt(createVegetablePriceId.getText())),
                            saladsMakerController.getEnergeticValueService().getById(Integer.parseInt(createVegetableEnergeticValueId.getText()))
                    ));
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllVegetablesClicked();
    }
    
    @FXML
    public void createSaladClicked(){
        try{
            saladsMakerController.getSaladService().createOrUpdate(
                    new Salad(
                            Integer.parseInt(createSaladId.getText()),                          
                            saladsMakerController.getNameService().getById(Integer.parseInt(createSaladNameId.getText()))
                    ));
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllSaladsClicked();
    }
    
    @FXML
    public void createIngredientClicked(){
        try{
            saladsMakerController.getIngredientService().createOrUpdate(
                    new Ingredient(
                            Integer.parseInt(createIngredientId.getText()),
                            saladsMakerController.getVegetableService().getById(Integer.parseInt(createIngredientVegetableId.getText())),
                            saladsMakerController.getWeightService().getById(Integer.parseInt(createIngredientWeightId.getText())),
                            saladsMakerController.getSaladService().getById(Integer.parseInt(createIngredientSaladId.getText()))
                    ));
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllIngredientsClicked();
    }
    
    @FXML
    public void deleteNameClicked(){
        try{
            Name toDelete = new Name();
            toDelete.setId(Integer.parseInt(deleteNameId.getText()));
            saladsMakerController.getNameService().delete(toDelete);
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllNamesClicked();
    }
    
    @FXML
    public void deleteWeightClicked(){
        try{
            Weight toDelete = new Weight();
            toDelete.setId(Integer.parseInt(deleteWeightId.getText()));
            saladsMakerController.getWeightService().delete(toDelete);
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllWeightsClicked();
    }
    
    @FXML
    public void deleteEnergyClicked(){
        try{
            Energy toDelete = new Energy();
            toDelete.setId(Integer.parseInt(deleteEnergyId.getText()));
            saladsMakerController.getEnergyService().delete(toDelete);
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllEnergiesClicked();
    }
    
    @FXML
    public void deleteCostClicked(){
        try{
            Cost toDelete = new Cost();
            toDelete.setId(Integer.parseInt(deleteCostId.getText()));
            saladsMakerController.getCostService().delete(toDelete);
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllCostsClicked();
    }
    
    @FXML
    public void deletePriceClicked(){
        try{
            Price toDelete = new Price();
            toDelete.setId(Integer.parseInt(deletePriceId.getText()));
            saladsMakerController.getPriceService().delete(toDelete);
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllPricesClicked();
    }
    
    @FXML
    public void deleteEnergeticValueClicked(){
        try{
            EnergeticValue toDelete = new EnergeticValue();
            toDelete.setId(Integer.parseInt(deleteEnergeticValueId.getText()));
            saladsMakerController.getEnergeticValueService().delete(toDelete);
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllEnergeticValuesClicked();
    }
    
    @FXML
    public void deleteVegetableClicked(){
        try{
            Vegetable toDelete = new Vegetable();
            toDelete.setId(Integer.parseInt(deleteVegetableId.getText()));
            saladsMakerController.getVegetableService().delete(toDelete);
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllVegetablesClicked();
    }
    
    @FXML
    public void deleteSaladClicked(){
        try{
            Salad toDelete = new Salad();
            toDelete.setId(Integer.parseInt(deleteSaladId.getText()));
            saladsMakerController.getSaladService().delete(toDelete);
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllSaladsClicked();
    }
    
    @FXML
    public void deleteIngredientClicked(){
        try{
            Ingredient toDelete = new Ingredient();
            toDelete.setId(Integer.parseInt(deleteIngredientId.getText()));
            saladsMakerController.getIngredientService().delete(toDelete);
        }catch(Exception ex){
            System.out.println("Something went wrong!");
        }
        
        viewAllIngredientsClicked();
    }
}
