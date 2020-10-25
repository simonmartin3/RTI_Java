/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanBDAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Simon
 */
public class Mouvement {
    
    private int idMouvement;
    private String idContainer;
    private String idTransporteurIn;
    private String dateArrivee;
    private String idTransporteurOut;
    private int poids;
    private String dateDepart;
    private String destination;
    
    public Mouvement(ResultSet resultSet) throws SQLException
    {
        this.idMouvement = resultSet.getInt(1);
        this.idContainer = resultSet.getString(2);
        this.idTransporteurIn = resultSet.getString(3);
        this.dateArrivee = resultSet.getString(4);
        this.idTransporteurOut = resultSet.getString(5);
        this.poids = resultSet.getInt(6);
        this.dateDepart = resultSet.getString(7);
        this.destination = resultSet.getString(8);
    }
    
    public int getIdMouvement() {
        return idMouvement;
    }

    public void setIdMouvement(int idMouvement) {
        this.idMouvement = idMouvement;
    }

    public String getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(String idContainer) {
        this.idContainer = idContainer;
    }

    public String getIdTransporteurIn() {
        return idTransporteurIn;
    }

    public void setIdTransporteurIn(String idTransporteurIn) {
        this.idTransporteurIn = idTransporteurIn;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(String dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public String getIdTransporteurOut() {
        return idTransporteurOut;
    }

    public void setIdTransporteurOut(String idTransporteurOut) {
        this.idTransporteurOut = idTransporteurOut;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String display()
    {
        String log = idMouvement + "-" + idContainer + "-" + idTransporteurIn + 
        "-" + dateArrivee + "-" + idTransporteurOut + poids + "-" + dateDepart + 
        "-" + destination;
        return log;
    }
}
