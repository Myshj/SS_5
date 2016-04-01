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

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Alexey
 */
public class NameServiceTest {
    
    
    private final String url = "jdbc:sqlite:Vegetables.db";
    private ConnectionSource source;
    private Dao<Name, String> dao;
    
    Table<Name> service;

    @Before
    public void setUp() throws SQLException {
        source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, Name.class);
        service = new Table<Name>(url, Name.class);
    }

    @Test
    public void testGetAll() throws Exception{
        
        List<Name> names = service.getAll();

        Assert.assertNotNull(names);

        for (Name n : names) {
            System.out.println(n);
        }
    }

    @Test
    public void testCreate() throws  Exception{
        Name name = new Name();
        name.setName("Maus");
        service.create(name);
    }
    
}
