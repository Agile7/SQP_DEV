/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agileseven.codereview.client.views;

import com.agileseven.codereview.client.DTO.CodeDTO;
import com.agileseven.codereview.client.DTO.UserDTO;
import com.agileseven.codereview.client.ServiceConsumer;
import com.agileseven.codereview.client.listeners.CodeListMouseListener;
import com.agileseven.codereview.client.utils;
import com.agileseven.codereview.client.DTO.UserstoryDTO;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vilosh_na
 */
public class UnreadCodeList extends javax.swing.JFrame {
    
    ServiceConsumer service = new ServiceConsumer();
    

    /**
     * Creates new form UnreadCodeList
     */
    public UnreadCodeList() {
        
        initComponents();
        GridLayout layout = new GridLayout(1,1);
        this.setLayout(layout);
        this.setBackground(new java.awt.Color(255, 255, 255));
        
      
        
        ArrayList<CodeDTO> codeList = service.getUnreadCodes();
        
        if(codeList != null && codeList.size() > 0){
            
            GridLayout listLayout = new GridLayout(codeList.size()*4,1,0,20);
            jPanel1.setLayout(listLayout);
            Date currentDate = new Date();
            codeList.stream().map((code) -> {
                
                UserDTO user = code.getUser();
                UserstoryDTO userStory = code.getUserStory();
                
                Label title = new Label(code.getCodeId() + " - " +code.getUserStoryId() + " " + userStory.getTitle());
                Label comment = new Label(code.getComment());
                Label description = new Label("Pushed by " + user.getFirstName()+ " " + user.getLastName() + " "+ utils.dateDiff(code.getPushDate(),currentDate));
                
                title.addMouseListener(new CodeListMouseListener(code.getCodeId(), this));                
                title.setFont(new Font("Arial", Font.BOLD, 32));
                title.setForeground(new java.awt.Color(51, 153, 255));
                
                comment.setFont(new Font("Arial", Font.PLAIN, 24));
                description.setFont(new Font("Arial", Font.PLAIN, 16));
                
                jPanel1.add(title);
                jPanel1.add(comment);
                jPanel1.add(description);
                
                return code;
            }).forEachOrdered((_item) -> {
                jPanel1.add(new Label());
                
                
                //jPanel1.add(panel);
            });
             
            
            
        }
        else{
            
            GridLayout listLayout = new GridLayout(1,1);
            jPanel1.setLayout(listLayout);
            
            Label info = new Label("No pending unreviewed code.");
            info.setFont(new Font("Arial", Font.PLAIN, 24));
            info.setForeground(new java.awt.Color(0,187,85));
            this.add(info);
        }
        
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnreadCodeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            UnreadCodeList win =  new UnreadCodeList();
            win.setVisible(true);
            win.setSize(1200, 800);
        });
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentX(0);
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
