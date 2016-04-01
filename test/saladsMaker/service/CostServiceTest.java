/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saladsMaker.service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import db.saladsMaker.entity.Name;
import db.saladsMaker.entity.Cost;

import db.saladsMaker.service.Table;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Alexey
 */
public class CostServiceTest {
    
    
    private final String url = "jdbc:sqlite:Vegetables.db";
    
    private Table<Name> ns;// = new NameService(url);
    
    private /*CostService*/Table<Cost> service;// = new WeightService(url);
    
    private ConnectionSource source;
    private Dao<Cost, String> dao;

    @Before
    public void setUp() throws SQLException {
        source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, Cost.class);
        
        ns = new Table<Name>(url, Name.class);
        service = new Table<Cost>(url, Cost.class);
    }

    @Test
    public void testGetAll() throws Exception{
        //WeightService service = new WeightService(url);
        List<Cost> costs = service.getAll();

        Assert.assertNotNull(costs);

        for (Cost c : costs) {
            System.out.println(c);
        }
    }

    @Test
    public void testCreate() throws  Exception{
        
        Cost cost = new Cost();
        
        List<Name> names = ns.getAll();

        cost.setName(names.get(names.size() - 1));
        cost.setCount(names.size());
        service.create(cost);
    }
    
}
