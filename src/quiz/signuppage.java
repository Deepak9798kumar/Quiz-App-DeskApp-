/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz;

import dbconnection.connectionprovider;
import java.awt.Dialog;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ABHISHEK TOMAR
 */
public class signuppage extends javax.swing.JFrame {

    /**
     * Creates new form signuppage
     */
    
    static int a=2;
    public signuppage() {
        initComponents();
                //JFrame.setAlwaysOnTop(true);

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
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        namevar = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        qual = new javax.swing.JComboBox<>();
        usname = new javax.swing.JTextField();
        pword = new javax.swing.JPasswordField();
        cpword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(446, 100));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("GO QUIZ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/exit.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(154, 154, 154)
                .addComponent(jButton3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel2.setText("PERSONAL DETAILS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("NAME");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("LAST NAME");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("AGE");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("GENDER");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("QUALIFICATION");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("USERNMAE");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("PASSWORD");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("CONFIRM PASSWORD");

        namevar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        namevar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namevarKeyPressed(evt);
            }
        });

        lname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lnameKeyPressed(evt);
            }
        });

        age.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        age.setText(" ");
        age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ageKeyPressed(evt);
            }
        });

        gender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", "OTHERS" }));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });

        qual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10TH", "12TH", "GRADUATION", "POST-GRADUATION" }));

        usname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usnameKeyPressed(evt);
            }
        });

        pword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwordKeyPressed(evt);
            }
        });

        cpword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cpword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpwordKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/signup-icon-13.png"))); // NOI18N
        jButton1.setText("SIGN UP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/Clear-icon (1).png"))); // NOI18N
        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(lname)
                    .addComponent(age)
                    .addComponent(usname)
                    .addComponent(pword)
                    .addComponent(cpword)
                    .addComponent(gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namevar))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namevar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(qual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(usname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(pword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cpword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
       a=1;
       quizselection.tvalue(a);
       
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         namevar.setText("");
        lname.setText("");
        age.setText("");
        usname.setText("");
        pword.setText("");
        cpword.setText("");
        gender.setSelectedIndex(0);
        qual.setSelectedIndex(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String finame = namevar.getText();
        String laname = lname.getText();
        String Age = age.getText();
        String sgender = gender.getSelectedItem().toString();
        String qualification = qual.getSelectedItem().toString();
        String username = usname.getText();
        String password = pword.getText();
        String cpassword = cpword.getText();
        
        if(finame.equals("") || laname.equals("") || Age.equals("") || sgender.equals("") ||
                qualification.equals("") || username.equals("") || password.equals("") || cpassword.equals(""))
        {
            JOptionPane p = new JOptionPane("please fill all details");
            Dialog d = p.createDialog("Warning");
            d.setAlwaysOnTop(true);
            d.setVisible(true);
        }
        
        else
        {
            if(password.equals(cpassword))
            {
                try
                {
                    Connection conn = connectionprovider.connector();
                    Statement st = conn.createStatement();
                    
                    ResultSet rs = st.executeQuery("select * from student where uname = '"+username+"'");
                    if(rs.next()==true)
                    {
                        JOptionPane p = new JOptionPane("this username is already taken please choose another username");
                          Dialog d = p.createDialog("Warning");
                          d.setAlwaysOnTop(true);
                          d.setVisible(true); 
                               
                    } 
                    
                    else
                    {
                        PreparedStatement ps = conn.prepareStatement("insert into student(fname, lname, age, gender, qualification, uname, password) values(?,?,?,?,?,?,?)");
                       // ps.setString(1,"");
                        ps.setString(1,finame);
                        ps.setString(2,laname);
                        ps.setString(3,Age);
                        ps.setString(4,sgender);
                        ps.setString(5,qualification);
                        ps.setString(6,username);
                        ps.setString(7,password);
                        ps.executeUpdate();
                       JOptionPane p = new JOptionPane("your account is created successfully");
                         Dialog d = p.createDialog("Message");
                         d.setAlwaysOnTop(true);
                         d.setVisible(true);
                                
                                
                        setVisible(false);
                        a=1;
                        quizselection.tvalue(a);
                        
                        //new loginpage().setVisible(true);
                        
                    }
                   
                } 
                
                catch (Exception e) {
           JOptionPane p = new JOptionPane("sorry we are sorry account cannot be created at this moment");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);

                    System.out.println(e);
                }
            }
            else
            {
            JOptionPane p = new JOptionPane("confirm password must be same as password");
            Dialog d = p.createDialog("Warning");
            d.setAlwaysOnTop(true);
            d.setVisible(true);

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void ageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        int age_length = age.getText().length();
        
        if(evt.getKeyChar()>='1' && evt.getKeyChar()<='9' && age_length<=2)
            
        {
            age.setEditable(true);
        }
        
        
        {
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
                    {
                       age.setEditable(true); 
                    }
            
            else if(age_length>2)
            {
               age.setEditable(false);
           JOptionPane d = new JOptionPane("age should be mentioned in maximum 2 digit only");
           Dialog p = d.createDialog("warning");
           p.setAlwaysOnTop(true);
           p.setVisible(true);
            }
            
            else if(Character.isLetter(c))
            {
                age.setEditable(false);
            }
        }
    }//GEN-LAST:event_ageKeyPressed

    private void namevarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namevarKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        String name = namevar.getText();
        int length = name.length();
        
        
        if(Character.isLetter(c) || Character.isISOControl(c))
        {
            System.out.println(length);
           
            if(length<=9)
        {
            namevar.setEditable(true);
            System.out.println(length);
//            System.out.println(length);
        }
            
             else if(length>9)
        {
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                namevar.setEditable(true);
                            System.out.println(length);

                
            }
            
            else {
            namevar.setEditable(false);
               JOptionPane p = new JOptionPane("name should be in maximum 10 letter");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
            }
        }
//            uvar.setEditable(true);
            
        }
        
        else if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            namevar.setEditable(false);
            JOptionPane p = new JOptionPane("only letter is allowed");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
        }
    }//GEN-LAST:event_namevarKeyPressed

    private void lnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        String lastname = lname.getText();
        int length = lastname.length();
        
        
        if(Character.isLetter(c)|| Character.isISOControl(c))
        {
           
            if(length<=9)
        {
            lname.setEditable(true);
//            System.out.println(length);
        }
            
             else if(length>9)
        {
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                lname.setEditable(true);
                
            }
            
            else{
            lname.setEditable(false);
               JOptionPane p = new JOptionPane("last name should be in maximum 10 letter");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
            }
        }
//            uvar.setEditable(true);
            
        }
        
        else if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9')
        {
            lname.setEditable(false);
            JOptionPane p = new JOptionPane("only letter is allowed");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
        }
    }//GEN-LAST:event_lnameKeyPressed

    private void usnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usnameKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        String username = usname.getText();
        int length = username.length();
        
        
        if(Character.isLetter(c) || Character.isISOControl(c) || c>='0' && c<'9')
        {
           
            if(length<=11)
        {
            usname.setEditable(true);
//            System.out.println(length);
        }
            
             else if(length>11)
        {
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                usname.setEditable(true);
                
            }
            
            else{
            usname.setEditable(false);
               JOptionPane p = new JOptionPane("username should be in maximum 12 character");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
            }
        }
//            uvar.setEditable(true);
            
        }
        
//        else
//        {
//            usname.setEditable(false);
//            JOptionPane p = new JOptionPane("only letter is allowed");
//                  Dialog d = p.createDialog("Warning");
//                  d.setAlwaysOnTop(true);
//                  d.setVisible(true);
//        }
    }//GEN-LAST:event_usnameKeyPressed

    private void pwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwordKeyPressed
        // TODO add your handling code here:
        String password = pword.getText();
        int length = password.length();
        
        if(length<=9)
        {
            pword.setEditable(true);
        }
        else if(length>9)
        {
            
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                pword.setEditable(true);
                
            }
            else
            {
           pword.setEditable(false);
           JOptionPane d = new JOptionPane("password can be only 10 characters long");
           Dialog p = d.createDialog("warning");
           p.setAlwaysOnTop(true);
           p.setVisible(true);
            }
        }
    }//GEN-LAST:event_pwordKeyPressed

    private void cpwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpwordKeyPressed
        // TODO add your handling code here:
         String password = cpword.getText();
        int length = password.length();
        
        if(length<=9)
        {
            cpword.setEditable(true);
        }
        else if(length>9)
        {
            
            if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
            {
                cpword.setEditable(true);
                
            }
            else
            {
           cpword.setEditable(false);
           JOptionPane d = new JOptionPane("password can be only 10 characters long");
           Dialog p = d.createDialog("warning");
           p.setAlwaysOnTop(true);
           p.setVisible(true);
            }
        }
    }//GEN-LAST:event_cpwordKeyPressed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

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
            java.util.logging.Logger.getLogger(signuppage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signuppage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signuppage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signuppage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signuppage().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JPasswordField cpword;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField namevar;
    private javax.swing.JPasswordField pword;
    private javax.swing.JComboBox<String> qual;
    private javax.swing.JTextField usname;
    // End of variables declaration//GEN-END:variables
}
