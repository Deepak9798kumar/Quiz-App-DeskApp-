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

/**
 *
 * @author ABHISHEK TOMAR
 */
public class afterquizpage extends javax.swing.JFrame {

    /**
     * Creates new form afterquizpage
     */
    public afterquizpage(String username, String tsummary) {
        initComponents();
        
        try
        {
            Connection con = connectionprovider.connector();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from "+tsummary+" where username = '"+username+"'");
            
            while(rs.next())
            {
                uvar.setText(username);
                 tvar.setText("20");
                avar.setText(rs.getString(2));
                cvar.setText(rs.getString(3));
                ivar.setText(rs.getString(4));
                uavar.setText(rs.getString(5));
                mvar.setText(rs.getString(6));
            }
            
           
        }
        
        catch(Exception e)
        {
            JOptionPane p = new JOptionPane("sorry some error is occuring in showing marks");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        uvar = new javax.swing.JLabel();
        tvar = new javax.swing.JLabel();
        avar = new javax.swing.JLabel();
        uavar = new javax.swing.JLabel();
        cvar = new javax.swing.JLabel();
        ivar = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mvar = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("GO QUIZ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(1215, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1378, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 144, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("TOTAL QUESTION");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 229, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("ATTEMPTED");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 305, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("UNATTEMPTED");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 392, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("CORRECT");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 476, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("INCORRECT");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 552, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("MARKS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 634, -1, -1));

        uvar.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        uvar.setForeground(new java.awt.Color(242, 242, 242));
        uvar.setText("uname");
        getContentPane().add(uvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, -1, -1));

        tvar.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        tvar.setForeground(new java.awt.Color(242, 242, 242));
        tvar.setText("TQ");
        getContentPane().add(tvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 229, -1, -1));

        avar.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        avar.setForeground(new java.awt.Color(242, 242, 242));
        avar.setText("AT");
        getContentPane().add(avar, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 305, -1, -1));

        uavar.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        uavar.setForeground(new java.awt.Color(242, 242, 242));
        uavar.setText("UA");
        getContentPane().add(uavar, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 392, -1, -1));

        cvar.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        cvar.setForeground(new java.awt.Color(242, 242, 242));
        cvar.setText("C");
        getContentPane().add(cvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 480, -1, -1));

        ivar.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        ivar.setForeground(new java.awt.Color(242, 242, 242));
        ivar.setText("IC");
        getContentPane().add(ivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/homeicon.png"))); // NOI18N
        jButton3.setText("HOME");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 700, -1, -1));

        jLabel16.setForeground(new java.awt.Color(242, 242, 242));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 634, -1, -1));

        mvar.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        mvar.setForeground(new java.awt.Color(242, 242, 242));
        mvar.setText("m");
        getContentPane().add(mvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 640, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/afterpage.png"))); // NOI18N
        jLabel11.setText("\n");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        new firstpage().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(afterquizpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(afterquizpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(afterquizpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(afterquizpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new afterquizpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avar;
    private javax.swing.JLabel cvar;
    private javax.swing.JLabel ivar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mvar;
    private javax.swing.JLabel tvar;
    private javax.swing.JLabel uavar;
    private javax.swing.JLabel uvar;
    // End of variables declaration//GEN-END:variables
}