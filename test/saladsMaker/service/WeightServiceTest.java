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
import db.saladsMaker.entity.Weight;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Alexey
 */
public class WeightServiceTest {
    
    
    private final String url = "jdbc:sqlite:Vegetables.db";
    
    private Table<Name> ns;// = new NameService(url);
    
    private Table<Weight> service;// = new WeightService(url);
    
    private ConnectionSource source;
    private Dao<Weight, String> dao;

    @Before
    public void setUp() throws SQLException {
        source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, Weight.class);
        
        ns = new Table<Name>(url, Name.class);
        service = new Table<Weight>(url, Weight.class);
    }

    @Test
    public void testGetAll() throws Exception{
        //WeightService service = new WeightService(url);
        List<Weight> weights = service.getAll();

        Assert.assertNotNull(weights);

        for (Weight w : weights) {
            System.out.println(w);
        }
    }

    @Test
    public void testCreate() throws  Exception{
        
        Weight weight = new Weight();
        
        List<Name> names = ns.getAll();

        weight.setName(names.get(names.size() - 1));
        weight.setCount(names.size());
        service.create(weight);
    }
    
}
