/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saladsMaker.service;

import db.saladsMaker.service.Table;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import db.saladsMaker.entity.Vegetable;
import db.saladsMaker.entity.Weight;
import db.saladsMaker.entity.Ingredient;
import db.saladsMaker.entity.Salad;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Alexey
 */
public class IngredientServiceTest {
    
    
    private final String url = "jdbc:sqlite:Vegetables.db";
    
    private Table<Vegetable> vs;// = new NameService(url);
    
    private Table<Weight> ws;// = new NameService(url);
    
    private Table<Salad> ss;
    
    private Table<Ingredient> service;// = new WeightService(url);
    
    private ConnectionSource source;

    @Before
    public void setUp() throws SQLException {
        source = new JdbcConnectionSource(url);
        
        vs = new Table<Vegetable>(url, Vegetable.class);
        ws = new Table<Weight>(url, Weight.class);
        
        ss = new Table<Salad>(url, Salad.class);
        
        service = new Table<Ingredient>(url, Ingredient.class);
    }

    @Test
    public void testGetAll() throws Exception{
        //WeightService service = new WeightService(url);
        List<Ingredient> ingredients = service.getAll();

        Assert.assertNotNull(ingredients);

        for (Ingredient p : ingredients) {
            System.out.println(p);
        }
    }

    @Test
    public void testCreate() throws  Exception{
        
        Ingredient ingredient = new Ingredient();
        
        List<Vegetable> vegetables = vs.getAll();
        List<Weight> weights = ws.getAll();
        Salad s = ss.getAll().get(0);

        ingredient.setVegetable(vegetables.get(vegetables.size() - 1));
        ingredient.setWeight(weights.get(weights.size() - 1));
        ingredient.setSalad(s);
        service.create(ingredient);
    }
    
}
