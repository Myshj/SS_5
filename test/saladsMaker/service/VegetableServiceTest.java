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
import db.saladsMaker.entity.Name;
import db.saladsMaker.entity.Price;
import db.saladsMaker.entity.EnergeticValue;
import db.saladsMaker.entity.Vegetable;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Alexey
 */
public class VegetableServiceTest {
    
    
    private final String url = "jdbc:sqlite:Vegetables.db";
    
    private Table<EnergeticValue> evs;// = new NameService(url);
    
    private Table<Price> ps;// = new NameService(url);
    
    private Table<Name> ns;// = new WeightService(url);
    
    private Table<Vegetable> service;
    
    private ConnectionSource source;

    @Before
    public void setUp() throws SQLException {
        source = new JdbcConnectionSource(url);
        
        evs = new Table<EnergeticValue>(url, EnergeticValue.class);
        ps = new Table<Price>(url, Price.class);
        ns = new Table<Name>(url, Name.class);
        service = new Table<Vegetable>(url, Vegetable.class);
    }

    @Test
    public void testGetAll() throws Exception{
        //WeightService service = new WeightService(url);
        List<Vegetable> vegetables = service.getAll();

        Assert.assertNotNull(vegetables);

        for (Vegetable veg : vegetables) {
            System.out.println(veg);
        }
    }

    @Test
    public void testCreate() throws  Exception{
        
        Vegetable vegetable = new Vegetable();
        
        List<Name> names = ns.getAll();
        List<Price> prices = ps.getAll();
        List<EnergeticValue> energeticValues = evs.getAll();

        vegetable.setEnergeticValue(energeticValues.get(energeticValues.size() - 1));
        vegetable.setName(names.get(names.size() - 1));
        vegetable.setPrice(prices.get(prices.size() - 1));
        service.create(vegetable);
    }
    
}
