/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpoolthreads;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.*;
import java.net.*;
import clientpoolthreads.*;
/**
 *
 * @author Simon
 */
public class FenAppClient extends javax.swing.JFrame {

    /**
     * Creates new form FenAppClient
     */
    
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket cliSocket;
    
    public FenAppClient(Socket s) {
        initComponents();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        this.setLocation((width/2), (height-this.getHeight())/2);
        
        cliSocket = s;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboBox_Requetes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Button_Suivant = new javax.swing.JButton();
        Button_Fermer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComboBox_Requetes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arrivée d'un camion avec réservation", "Arrivée d'un camion sans réservation", "Liste des mouvments", "Déconnexion" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Selectionner une action :");

        Button_Suivant.setText("Suivant");
        Button_Suivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuivantActionPerformed(evt);
            }
        });

        Button_Fermer.setText("Fermer");
        Button_Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FermerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBox_Requetes, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_Suivant, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(Button_Fermer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ComboBox_Requetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Suivant)
                    .addComponent(Button_Fermer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_SuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuivantActionPerformed
        int requestSelected = ComboBox_Requetes.getSelectedIndex();
        
        switch(requestSelected)
        {
            case 0:
                System.out.println(ComboBox_Requetes.getItemAt(requestSelected));
                InputReservationClient irc = new InputReservationClient(this, false, cliSocket);
                irc.setVisible(true);
                break;
            
            case 1:
                System.out.println(ComboBox_Requetes.getItemAt(requestSelected));
                InputClient ic = new InputClient(this, false, cliSocket);
                ic.setVisible(true);
                break;
            
            case 2:
                System.out.println(ComboBox_Requetes.getItemAt(requestSelected));
                SearchMouvement sm = new SearchMouvement(this, false, cliSocket);
                sm.setVisible(true);
                break;
            
            case 3:
                System.out.println(ComboBox_Requetes.getItemAt(requestSelected));
                LogoutClient lc = new LogoutClient(this, true, cliSocket);
                lc.setVisible(true);
                this.dispose();
                break;
        }
        
    }//GEN-LAST:event_Button_SuivantActionPerformed

    private void Button_FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FermerActionPerformed
        try {
            cliSocket.close();
        } catch (IOException e) {
            System.out.println("--- erreur IO = " + e.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_Button_FermerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenAppClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenAppClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenAppClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenAppClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenAppClient(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Fermer;
    private javax.swing.JButton Button_Suivant;
    private javax.swing.JComboBox<String> ComboBox_Requetes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
