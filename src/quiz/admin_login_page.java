/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz;

import java.awt.Dialog;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author ABHISHEK TOMAR
 */
public class admin_login_page extends javax.swing.JFrame {

    /**
     * Creates new form admin_login_page
     */
    public admin_login_page() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uservar = new javax.swing.JTextField();
        passwordvar = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/background_image.png"))); // NOI18N

        jLabel5.setText("jLabel5");

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 200));
        setMinimumSize(new java.awt.Dimension(600, 306));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Admin LOGIN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Admin Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 117, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 171, -1, -1));

        uservar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uservar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uservarKeyPressed(evt);
            }
        });
        getContentPane().add(uservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 114, 249, -1));

        passwordvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordvarActionPerformed(evt);
            }
        });
        passwordvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordvarKeyPressed(evt);
            }
        });
        getContentPane().add(passwordvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 168, 249, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/login-icon.png"))); // NOI18N
        jButton4.setText("login");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 212, -1, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/Clear-icon (1).png"))); // NOI18N
        jButton5.setText("clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/exit.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/background_image.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordvarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String username = "";
        String password = "";
        
        username=uservar.getText();
        password=passwordvar.getText();
        
        if(username.equals("")||password.equals(""))
        {
            JOptionPane pane = new JOptionPane("please fill all details");
            Dialog dialog = pane.createDialog("Warning");
            dialog.setVisible(true);
            dialog.setAlwaysOnTop(true);
        }
        else
        {
            if(username.equals("abhishek")){
                
                if(password.equals("admin1234"))
                    
                {
                    JOptionPane pane = new JOptionPane("Welcome "+username);
                Dialog dialog = pane.createDialog("Message");
                dialog.setVisible(true);
                dialog.setAlwaysOnTop(true);
                
                setVisible(false);
                new Admin_first_page().setVisible(true);
//                new Admin_first_page().setAlwaysOnTop(true);

                }
                else
                {
                 JOptionPane pane = new JOptionPane("Password is incorrect");
                Dialog dialog = pane.createDialog("Warning");
                dialog.setVisible(true);
                dialog.setAlwaysOnTop(true);   
                }
            }
            else
            {
                JOptionPane pane = new JOptionPane("Username is incorrect");
                Dialog dialog = pane.createDialog("Warning");
                dialog.setVisible(true);
                dialog.setAlwaysOnTop(true);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
       
        
        new homepage().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        uservar.setText("");
        passwordvar.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void uservarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uservarKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        String username = uservar.getText();
        int length = username.length();
        
        
        if(Character.isLetter(c) || Character.isISOControl(c) || c>='0' && c<'9')
        {
           
            if(length<=9)
        {
            uservar.setEditable(true);
//            System.out.println(length);
        }
            
             else if(length>9)
        {
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                uservar.setEditable(true);
                
            }
            
            else{
            uservar.setEditable(false);
               JOptionPane p = new JOptionPane("username should be in maximum 10 letter");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
            }
        }
//            uvar.setEditable(true);
            
        }
    }//GEN-LAST:event_uservarKeyPressed

    private void passwordvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordvarKeyPressed
        // TODO add your handling code here:
        String password = passwordvar.getText();
        int length = password.length();
        
        if(length<=9)
        {
            passwordvar.setEditable(true);
        }
        else if(length>9)
        {
            
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                passwordvar.setEditable(true);
                
            }
            else
            {
           passwordvar.setEditable(false);
           JOptionPane d = new JOptionPane("password can be only 10 characters long");
           Dialog p = d.createDialog("warning");
           p.setAlwaysOnTop(true);
           p.setVisible(true);
            }
        }
    }//GEN-LAST:event_passwordvarKeyPressed

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
            java.util.logging.Logger.getLogger(admin_login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_login_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_login_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passwordvar;
    private javax.swing.JTextField uservar;
    // End of variables declaration//GEN-END:variables
}
