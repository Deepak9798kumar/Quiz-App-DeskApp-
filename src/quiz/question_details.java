/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz;

import dbconnection.connectionprovider;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ABHISHEK TOMAR
 */
public class question_details extends javax.swing.JFrame {

    /**
     * Creates new form question_details
     */
     static int open=0;
      
    public question_details() {
        initComponents();
        
       
        
//      DefaultTableModel tablemodel = new DefaultTableModel()
//              {
//                  @Override
//                  public boolean isCellEditable(int row, int column)
//              {
//                  return false;
//              }
//              };
//      
//      tablevar.setModel(tablemodel);
      
//      tablevar table =new tablevar();
      tablevar.setEnabled(false);
        
        try
        {
           
            Connection con = connectionprovider.connector();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from cppquestion");
            
            tablevar.setAutoResizeMode(tablevar.AUTO_RESIZE_OFF);
            tablevar.setModel(DbUtils.resultSetToTableModel(rs));
        }
            
             catch(Exception e)
    {
        JOptionPane p = new JOptionPane("there is some problem please check your internet");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
        System.out.println(e);
    }
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
        jLabel1 = new javax.swing.JLabel();
        examvar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablevar = new javax.swing.JTable();
        editvar = new javax.swing.JButton();
        cancelvar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1378, 768));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1378, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("GO QUIZ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(659, 659, 659)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, -1));

        examvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examvar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C++", "Java", "Dbms", "C#" }));
        examvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examvarActionPerformed(evt);
            }
        });
        getContentPane().add(examvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        tablevar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        )

    );
    tablevar.setMinimumSize(new java.awt.Dimension(1330, 524));
    tablevar.setPreferredSize(new java.awt.Dimension(1330, 524));
    jScrollPane1.setViewportView(tablevar);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1344, 524));

    editvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    editvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/edit.png"))); // NOI18N
    editvar.setText("EDIT");
    editvar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            editvarActionPerformed(evt);
        }
    });
    getContentPane().add(editvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 690, -1, -1));

    cancelvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    cancelvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/cancel.png"))); // NOI18N
    cancelvar.setText("CANCEL");
    cancelvar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelvarActionPerformed(evt);
        }
    });
    getContentPane().add(cancelvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 690, -1, -1));

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/afterpage.png"))); // NOI18N
    getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelvarActionPerformed
        // TODO add your handling code here:
        if(open==0){
        
        new Admin_first_page().setVisible(true);
        setVisible(false);
        }
        
        else
        {
                     JOptionPane p = new JOptionPane("please first close the opened box");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
        }
    }//GEN-LAST:event_cancelvarActionPerformed

    private void editvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editvarActionPerformed
        // TODO add your handling code here:
        
        String exam = (String) examvar.getSelectedItem();
        question_append question = new question_append(exam);
                question.setVisible(true);
                question.setAlwaysOnTop(true);
                open=1;
    }//GEN-LAST:event_editvarActionPerformed

    private void examvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examvarActionPerformed
        // TODO add your handling code here:
        String exam="";
        if(examvar.getSelectedItem().equals("C++"))
        {
            exam = "cppquestion";
        }
        
        if(examvar.getSelectedItem().equals("Java"))
        {
            exam = "javaquestion";
        }
        
        if(examvar.getSelectedItem().equals("Dbms"))
        {
            exam = "dbmsquestion";
        }
        
        if(examvar.getSelectedItem().equals("C#"))
        {
            exam = "cquestion";
        }
        
        try
        {
            Connection con = connectionprovider.connector();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from "+exam+"");
            
            tablevar.setAutoResizeMode(tablevar.AUTO_RESIZE_OFF);
            tablevar.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        catch(Exception e)
        {
                    JOptionPane p = new JOptionPane("there is some problem please check your internet");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
                     System.out.println(e);
        }
    }//GEN-LAST:event_examvarActionPerformed

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
            java.util.logging.Logger.getLogger(question_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(question_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(question_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(question_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new question_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelvar;
    private javax.swing.JButton editvar;
    private javax.swing.JComboBox<String> examvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablevar;
    // End of variables declaration//GEN-END:variables
}
