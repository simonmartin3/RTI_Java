/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanBDAccess;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class BDBeanImpln implements BDBean {
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException 
    {
        Class leDriver = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_mouvements?serverTimezone=Europe/Brussels", "root","root");
        
        return connection;
    }
    
    public List<Container> getContainers() 
    {
        List<Container> returnValue = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
          try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM containers")) {
                    while(resultSet.next()) {
                        returnValue.add(new Container(resultSet));
                    }
                }
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Societe> getSocietes() 
    {
        List<Societe> returnValue = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
          try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM societes")) {
                    while(resultSet.next()) {
                        returnValue.add(new Societe(resultSet));
                    }
                }
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Parc> getParc() 
    {
        List<Parc> returnValue = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
          try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM parc")) {
                    while(resultSet.next()) {
                        returnValue.add(new Parc(resultSet));
                    }
                }
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Mouvement> getMouvements() 
    {
        List<Mouvement> returnValue = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
          try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM parc")) {
                    while(resultSet.next()) {
                        returnValue.add(new Mouvement(resultSet));
                    }
                }
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Destination> getDestinations() 
    {
        List<Destination> returnValue = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
          try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM parc")) {
                    while(resultSet.next()) {
                        returnValue.add(new Destination(resultSet));
                    }
                }
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Transporteur> getTransporteurs() 
    {
        List<Transporteur> returnValue = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
          try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM parc")) {
                    while(resultSet.next()) {
                        returnValue.add(new Transporteur(resultSet));
                    }
                }
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
}
