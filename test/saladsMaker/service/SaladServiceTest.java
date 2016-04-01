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
import db.saladsMaker.entity.Salad;
import db.saladsMaker.entity.Name;
import db.saladsMaker.entity.Ingredient;

import java.sql.SQLException;
import java.util.List;
import db.saladsMaker.entity.Vegetable;
import db.saladsMaker.entity.Weight;

/**
 *
 * @author Alexey
 */
public class SaladServiceTest {
    
    
    private final String url = "jdbc:sqlite:Vegetables.db";
    
    private Table<Ingredient> is;// = new NameService(url);
    
    private Table<Name> ns;
    
    private Table<Salad> service;
    
    private ConnectionSource source;

    @Before
    public void setUp() throws SQLException {
        source = new JdbcConnectionSource(url);
        
        is = new Table<Ingredient>(url, Ingredient.class);
        
        ns = new Table<Name>(url, Name.class);

        service = new Table<Salad>(url, Salad.class);
    }

    @Test
    public void testGetAll() throws Exception{
        //WeightService service = new WeightService(url);
        List<Salad> salads = service.getAll();

        Assert.assertNotNull(salads);

        for (Salad s : salads) {
            System.out.println(s);
        }
    }

    @Test
    public void testCreate() throws  Exception{
        
        List<Name> names = ns.getAll();
        
        Salad salad = new Salad();
   
        salad.setName(names.get(names.size() - 1));

        //salad.setIngredients(new ForeignCollection<Ingredient>());
        service.create(salad);
    }
    
}
