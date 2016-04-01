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
import db.saladsMaker.entity.Cost;
import db.saladsMaker.entity.Weight;
import db.saladsMaker.entity.Price;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Alexey
 */
public class PriceServiceTest {
    
    
    private final String url = "jdbc:sqlite:Vegetables.db";
    
    private Table<Cost> cs;// = new NameService(url);
    
    private Table<Weight> ws;// = new NameService(url);
    
    private Table<Price> service;// = new WeightService(url);
    
    private ConnectionSource source;
    private Dao<Cost, String> dao;

    @Before
    public void setUp() throws SQLException {
        source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, Cost.class);
        
        cs = new Table<Cost>(url, Cost.class);
        ws = new Table<Weight>(url, Weight.class);
        service = new Table<Price>(url, Price.class);
    }

    @Test
    public void testGetAll() throws Exception{
        //WeightService service = new WeightService(url);
        List<Price> prices = service.getAll();

        Assert.assertNotNull(prices);

        for (Price p : prices) {
            System.out.println(p);
        }
    }

    @Test
    public void testCreate() throws  Exception{
        
        Price price = new Price();
        
        List<Cost> costs = cs.getAll();
        List<Weight> weights = ws.getAll();

        price.setCost(costs.get(costs.size() - 1));
        price.setWeight(weights.get(weights.size() - 1));
        service.create(price);
    }
    
}
