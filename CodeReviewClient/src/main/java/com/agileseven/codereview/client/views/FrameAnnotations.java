/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.agileseven.codereview.client.views;

import com.agileseven.codereview.client.DTO.CodeDTO;
import com.agileseven.codereview.client.DTO.ReviewAnnotationDTO;
import com.agileseven.codereview.client.DTO.ReviewDTO;
import com.agileseven.codereview.client.DTO.UserDTO;
import com.agileseven.codereview.client.DTO.UserstoryDTO;
import com.agileseven.codereview.client.ServiceConsumer;
import com.agileseven.codereview.client.Session;
import com.agileseven.codereview.client.Utils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Jin Xutong
 * view codes with annotations
 */
public class FrameAnnotations extends javax.swing.JFrame {
    
    private final ServiceConsumer service = new ServiceConsumer();
    private final ArrayList<ReviewDTO> reviewList;

    /** Creates new form FrameAnnotations */
    public FrameAnnotations() {
        initComponents();
        jLabel2.setText(Session.currentUser.getFirstName() + " " + Session.currentUser.getLastName());
        reviewList = service.getReviewList(Session.currentUser.getUserId(), Session.currentProject.getProjectId());
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTable1.getColumnModel().getColumn(0).setMaxWidth(75);
        
        jTable2.getColumnModel().getColumn(0).setMaxWidth(75);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(75);
        
        ColorRenderer cr=new ColorRenderer();
        for (int i=0;i<5;i++) jTable1.getColumn(jTable1.getColumnName(i)).setCellRenderer(cr);

        for (int i=0;i<3;i++) jTable2.getColumn(jTable2.getColumnName(i)).setCellRenderer(cr);


        
        if(reviewList != null && reviewList.size() > 0){
            
            for(ReviewDTO review : reviewList) {
                
                UserDTO user = review.getReviewer();
                CodeDTO code = review.getCode();
                UserstoryDTO userStory = code.getUserStory();
                
                
                
                
                model.addRow(new Object[]{
                    code.getCodeId(),
                    code.getUserStoryId() + " " + userStory.getTitle(),
                    user.getFirstName()+ " " + user.getLastName(),
                    review.getSubmitTime(),
                    (review.getApproved() == 1 ? "Approved" : "Rejected")
                });
 
            }
 
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 102));

        jPanel2.setBackground(new java.awt.Color(248, 238, 231));

        jPanel1.setBackground(new java.awt.Color(73, 39, 74));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("My Reviewed Codes");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/back.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addGap(376, 376, 376)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24))))
        );

        jTable1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code Id", "User Story", "Reviewer", "Review Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(40);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTable2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line No", "Rule No", "Annotation"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setRowHeight(40);
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int selectedIndex = jTable1.getSelectedRow();
         ReviewDTO review = reviewList.get(selectedIndex);
         
         if(review.getAnnotationList() == null){
            review.setAnnotationList(service.getAnnotationsByReviewId(review.getReviewId()));
         }
         
         jTextArea1.setText(Utils.addLineNumbersToCodeString(review.getCode().getCodeText()));
         
         ArrayList<ReviewAnnotationDTO> annotationList = review.getAnnotationList();
         
        
         DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
         
         int rows = model.getRowCount();
  
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
         
          if(annotationList != null && annotationList.size() > 0){
            
            for(ReviewAnnotationDTO annotation : annotationList) {
                
                    model.addRow(new Object[]{
                    annotation.getLineNumber(),
                    annotation.getRuleId(),
                    annotation.getAnnotText()
                });
            }
          }

         
         
         
    }//GEN-LAST:event_jTable1MouseClicked

    private void BackClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackClicked
        // TODO add your handling code here
        this.setVisible(false);
        new FrameHomePage().setVisible(true);
    }//GEN-LAST:event_BackClicked

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
            java.util.logging.Logger.getLogger(FrameAnnotations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAnnotations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAnnotations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAnnotations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
    
     class ColorRenderer extends JLabel implements TableCellRenderer
    {
        public ColorRenderer()
        {
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column)
            {


           setText(value !=null ? value.toString() : "");
           setForeground(java.awt.Color.BLACK);        
           setFont(new Font("Arial", Font.PLAIN, 18));
           table.setSelectionBackground(Color.red);
           table.setShowGrid(true);
           
        
           if(row%2 != 0){
               setBackground(new Color(255, 249, 230));
           }
           else{
               setBackground(java.awt.Color.WHITE);
           }
           
           if(column==4){
               
                if (reviewList.get(row).getApproved() == 1) {
                     setBackground(new Color(147, 234, 173));
                }
                else {
                     setBackground(new Color(255, 121,121));
                }
           }
           
           if(isSelected){
               setBackground(new Color(255, 207, 51));
           }

            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
