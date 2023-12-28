/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ABHISHEK TOMAR
 */
public class connectionprovider{
    
     public static Connection connector()
    {
        try
        {
          Class.forName("com.mysql.cj.jdbc.Driver"); 
          
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentquiz","root","9211");
          System.out.println(con+" done");
          return con;
          
        }
        
        catch(Exception e)
        {
            System.out.print(e);
            return null;
            
        }
    }
    
    public static void main(String args[])
    {
        connector();
    }
    
}
