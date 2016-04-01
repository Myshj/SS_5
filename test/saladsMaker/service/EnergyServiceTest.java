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
import db.saladsMaker.entity.Energy;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Alexey
 */
public class EnergyServiceTest {
    
    
    private final String url = "jdbc:sqlite:Vegetables.db";
    
    private Table<Name> ns;// = new NameService(url);
    
    private Table<Energy> service;// = new WeightService(url);
    
    private ConnectionSource source;
    private Dao<Energy, String> dao;

    @Before
    public void setUp() throws SQLException {
        source = new JdbcConnectionSource(url);
        
        ns = new Table<Name>(url, Name.class);
        service = new Table<Energy>(url, Energy.class);
    }

    @Test
    public void testGetAll() throws Exception{
        //WeightService service = new WeightService(url);
        List<Energy> energies = service.getAll();

        Assert.assertNotNull(energies);

        for (Energy e : energies) {
            System.out.println(e);
        }
    }

    @Test
    public void testCreate() throws  Exception{
        
        Energy energy = new Energy();
        
        List<Name> names = ns.getAll();

        energy.setName(names.get(names.size() - 1));
        energy.setCount(names.size());
        service.create(energy);
    }
    
}
