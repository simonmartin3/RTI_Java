/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtocoleSUM;

import java.io.*;
import requetepoolthreads.Reponse;
/**
 *
 * @author Simon
 */
public class ReponseSUM implements Reponse, Serializable {
    
    public static int LOGIN_OK = 101;
    public static int LOGIN_FAIL = 102;
    public static int LOGOUT_OK = 201;
    public static int LOGOUT_FAIL = 202;
    private int codeRetour;
    private String chargeUtile;
    
    public ReponseSUM(int c, String chu)
    {
        codeRetour = c; setChargeUtile(chu);
    }
    
    public int getCode() { return codeRetour; }
    
    public String getChargeUtile() { return chargeUtile; }
    
    public void setChargeUtile(String chargeUtile) { this.chargeUtile = chargeUtile; }
}