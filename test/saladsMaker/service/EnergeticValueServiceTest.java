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
import db.saladsMaker.entity.Energy;
import db.saladsMaker.entity.Weight;
import db.saladsMaker.entity.EnergeticValue;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Alexey
 */
public class EnergeticValueServiceTest {
    
    
    private final String url = "jdbc:sqlite:Vegetables.db";
    
    private Table<Energy> es;// = new NameService(url);
    
    private Table<Weight> ws;// = new NameService(url);
    
    private Table<EnergeticValue> service;// = new WeightService(url);
    
    private ConnectionSource source;

    @Before
    public void setUp() throws SQLException {
        source = new JdbcConnectionSource(url);
        
        es = new Table<Energy>(url, Energy.class);
        ws = new Table<Weight>(url, Weight.class);
        service = new Table<EnergeticValue>(url, EnergeticValue.class);
    }

    @Test
    public void testGetAll() throws Exception{
        //WeightService service = new WeightService(url);
        List<EnergeticValue> energeticValues = service.getAll();

        Assert.assertNotNull(energeticValues);

        for (EnergeticValue ev : energeticValues) {
            System.out.println(ev);
        }
    }

    @Test
    public void testCreate() throws  Exception{
        
        EnergeticValue energeticValue = new EnergeticValue();
        
        List<Energy> energies = es.getAll();
        List<Weight> weights = ws.getAll();

        energeticValue.setEnergy(energies.get(energies.size() - 1));
        energeticValue.setWeight(weights.get(weights.size() - 1));
        service.create(energeticValue);
    }
    
}
