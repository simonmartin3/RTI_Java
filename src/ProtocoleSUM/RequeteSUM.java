/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtocoleSUM;

import BeanBDAccess.*;
import java.io.*;
import java.util.*;
import java.net.*;
import serveurpoolthreads.*;
import requetepoolthreads.Requete;
/**
 *
 * @author Simon
 */
public class RequeteSUM implements Requete, Serializable{
    
    public static int REQUEST_LOGIN = 1;
    public static int REQUEST_LOGOUT = 2;
    public static int REQUEST_INPUT_LORRY = 3;
    public static int REQUEST_INPUT_LORRY_WITHOUT_RESERVATION = 4;
    public static int REQUEST_LIST_OPERATIONS = 5;
    
    private int type;
    private String chargeUtile;
    private Socket socketClient;
    
    BDBeanImpln impln = new BDBeanImpln();
    
    public RequeteSUM(int t, String chu)
    {
        type = t; setChargeUtile(chu);
    }
    public RequeteSUM(int t, String chu, Socket s)
    {
        type = t; setChargeUtile(chu); socketClient = s;
    }
    
    public Runnable createRunnable (final Socket s, final ConsoleServeur cs)
    {
        if (type==REQUEST_LOGIN)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteLogin(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else if(type==REQUEST_LOGOUT)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteLogout(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else if(type==REQUEST_INPUT_LORRY)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteInputLorry(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else if(type==REQUEST_INPUT_LORRY_WITHOUT_RESERVATION)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteInputLorryWithoutReservation(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else if(type==REQUEST_LIST_OPERATIONS)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteListOperations(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else return null;
    }
    
    private void traiteRequeteLogin(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        String adresseDistante = sock.getRemoteSocketAddress().toString();
        cs.TraceEvenements(adresseDistante+"#Login#"+Thread.currentThread().getName());
        
        FileInputStream in = new FileInputStream("serveur.properties");
        Properties p = new Properties();
        p.load(in);
        
        String csvFile = p.getProperty("PATH_LOGIN");
        String line = "";
        String cvsSplitBy = p.getProperty("SEP_CSV");
        String[] recvLogin = getChargeUtile().split(cvsSplitBy);
        ReponseSUM rep = null;
        boolean find = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] login = line.split(cvsSplitBy);
                if(login[0].equals(recvLogin[0]) && login[1].equals(recvLogin[1]))
                {
                    find = true;
                    break;
                }
                else
                    find = false;
                
                System.out.println("Login [user=" + login[0] + " , pass=" + login[1] + "]");
            }

        } catch (IOException e) {
            System.err.println("Erreur ouverture fichier login ? [" + e.getMessage() + "]");
        }
        
        if(find)
        {
            rep = new ReponseSUM(ReponseSUM.LOGIN_OK, getChargeUtile());
            cs.TraceEvenements(adresseDistante+"#Login OK#"+Thread.currentThread().getName());
        }
        else
        {
            rep = new ReponseSUM(ReponseSUM.LOGIN_FAIL, getChargeUtile());
            cs.TraceEvenements(adresseDistante+"#Login FAIL#"+Thread.currentThread().getName());
        }
        
        // Construction d'une réponse
        ObjectOutputStream oos;
        try
        {
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(rep); oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur réseau ? [" + e.getMessage() + "]");
        }
    }
    
    private void traiteRequeteLogout(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        String adresseDistante = sock.getRemoteSocketAddress().toString();
        cs.TraceEvenements(adresseDistante+"#Logout#"+Thread.currentThread().getName());
        
        FileInputStream in = new FileInputStream("serveur.properties");
        Properties p = new Properties();
        p.load(in);
        
        String csvFile = p.getProperty("PATH_LOGIN");
        String line = "";
        String cvsSplitBy = p.getProperty("SEP_CSV");
        String[] recvLogin = getChargeUtile().split(cvsSplitBy);
        ReponseSUM rep = null;
        boolean find = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] login = line.split(cvsSplitBy);
                if(login[0].equals(recvLogin[0]) && login[1].equals(recvLogin[1]))
                {
                    find = true;
                    break;
                }
                else
                    find = false;
                
                System.out.println("Login [user=" + login[0] + " , pass=" + login[1] + "]");
            }

        } catch (IOException e) {
            System.err.println("Erreur ouverture fichier login ? [" + e.getMessage() + "]");
        }
        
        if(find)
        {
            rep = new ReponseSUM(ReponseSUM.LOGOUT_OK, getChargeUtile());
            cs.TraceEvenements(adresseDistante+"#Logout OK#"+Thread.currentThread().getName());
        }
        else
        {
            rep = new ReponseSUM(ReponseSUM.LOGOUT_FAIL, getChargeUtile());
            cs.TraceEvenements(adresseDistante+"#Logout FAIL#"+Thread.currentThread().getName());
        }
        
        // Construction d'une réponse
        ObjectOutputStream oos;
        try
        {
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(rep); oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur réseau ? [" + e.getMessage() + "]");
        }
    }
    
    private void traiteRequeteInputLorry(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        String adresseDistante = sock.getRemoteSocketAddress().toString();
        cs.TraceEvenements(adresseDistante+"#INPUT_LORRY#"+Thread.currentThread().getName());
        
        Vector param = new Vector();
        StringTokenizer parser = new StringTokenizer(getChargeUtile(),",");
        while (parser.hasMoreTokens())
            param.add(parser.nextToken());
        
        
        System.out.println("Essai de connexion JDBC");
        List<Reservation> reservationList = null;
        List<Societe> societeList = null;
        
        reservationList= impln.getReservations();
        societeList = impln.getSocietes();
        
        ReponseSUM rep = null;
        int i = 0;
        boolean find = false;
        
        if(!reservationList.isEmpty())
        {
            while(i < reservationList.size()) 
            {
                if(reservationList.get(i).getIdReservation().equals(param.get(0)) && reservationList.get(i).getIdContainer().equals(param.get(1)))
                {
                    find = true;
                    break;
                }
                i++;
            }
            
            if(find)
            {
                String msg = getChargeUtile() + "," + reservationList.get(i).getIdTransporteur()+ "," + reservationList.get(i).getIdSociete();
                rep = rep = new ReponseSUM(ReponseSUM.INPUT_LORRY_OK, msg);
                cs.TraceEvenements(adresseDistante+"#INPUT_LORRY OK#"+Thread.currentThread().getName());
            }
        }
        else
        {
            rep = rep = new ReponseSUM(ReponseSUM.INPUT_LORRY_FAIL, "fail");
            cs.TraceEvenements(adresseDistante+"#INPUT_LORRY FAIL#"+Thread.currentThread().getName());
        }
        

        // Construction d'une réponse
        ObjectOutputStream oos;
        try
        {
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(rep); oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur réseau ? [" + e.getMessage() + "]");
        }
    }
    
    private void traiteRequeteInputLorryWithoutReservation(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        
    }
    
    private void traiteRequeteListOperations(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        
    }    

    public String getChargeUtile() { return chargeUtile; }
    
    public void setChargeUtile(String chargeUtile)
    {
        this.chargeUtile = chargeUtile;
    }
    
}
