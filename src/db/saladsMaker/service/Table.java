/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.saladsMaker.service;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import db.saladsMaker.entity.HasId;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alexey
 */
public class Table<T extends HasId> {
    
    private String url = ""; //"jdbc:sqlite:Vegetables.db";
    private ConnectionSource source;
    private Dao<T, String> dao;
    
    public Table(String url, Class<T> cls) throws SQLException {
        this.url = url;
        source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, cls);
    }

    public List<T> getAll() throws SQLException {
        return dao.queryForAll();
    }
    
    public T getById(int id) throws SQLException{
        List<T> objects = getAll();
        
        for(T obj : objects){
            if (obj.getId() == id){
                return obj;
            }
        }
        
        return null;
    }
    
    public String getStringRepresentation() throws SQLException{
        List<T> objects = getAll();
        
        String ret = "";
        
        for(T obj : objects){
            ret += obj.toString();
            ret += "\n";
        }
        
        return ret;
    }

    public void delete(T obj) throws SQLException {
        dao.delete(obj);
    }

    public int update(T obj) throws SQLException {
        return dao.update(obj);
    }

    public int create(T obj) throws SQLException {
        return dao.create(obj);
    }
    
    public Dao.CreateOrUpdateStatus createOrUpdate(T obj) throws SQLException{
        return dao.createOrUpdate(obj);
    }
    
}
