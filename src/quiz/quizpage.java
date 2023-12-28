/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz;

import dbconnection.connectionprovider;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author ABHISHEK TOMAR
 */
public class quizpage extends javax.swing.JFrame {

    /**
     * Creates new form quizpage
     */
  
    
    int no =1;
     int sec =60;
     float marks=0;
     int atques=0, cques=0, iques=0, uaques=0;
     String tmarks="";
     String tquestion="";
     String tsummary="";


     public void showques(int no)
           {
               if(no==20)
               {
                   subvar.setVisible(true);
                   snvar.setVisible(false);
               }
               
               else
               {
                   subvar.setVisible(false);
                   snvar.setVisible(true);
               }
               try
               {
                   Connection con = connectionprovider.connector();
                   Statement st  = con.createStatement();
                   
                   ResultSet rs = st.executeQuery("select * from "+tquestion+" where sno='"+no+"'");
                   
                  while(rs.next())
                  {
                   qno.setText("QUESTION "+rs.getString(1));
                   qvar.setText(rs.getString(2));
                   option1.setText(rs.getString(3));
                   option2.setText(rs.getString(4));
                   option3.setText(rs.getString(5));
                   option4.setText(rs.getString(6));
                  }
                  
                   
                   
               }
               
               catch(Exception e)
               {
                   JOptionPane p = new JOptionPane("error occuring please check your network");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
                   System.out.println(e);
               }
           }
     public void submit(String username)
     {
        try
        {
            Connection con = connectionprovider.connector();
           // Statement st = con.createStatement();
            answercheck();
            float mark = marks;
           int attempt=cques+iques;
           //int attempt = atques;
           int unattempt = uaques;
           int correct = cques;
           int incorrect = iques;
           
            //String mark = String.valueOf(marks);
           
            
            
            PreparedStatement p2 = con.prepareStatement("insert into "+tsummary+" values(?,?,?,?,?,?)");
            p2.setString(1,username);
            p2.setInt(2,attempt);
            p2.setInt(3,correct);
            p2.setInt(4,incorrect);
            p2.setInt(5,unattempt);
            p2.setFloat(6,mark);
            p2.executeUpdate();
            
            sortmarks(mark, username);

            
            new afterquizpage(username, tsummary).setVisible(true);
            setVisible(false);
        }
        
        catch(Exception e)
        {
            JOptionPane p = new JOptionPane("sorry there is problem in submitting the quiz");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
            System.out.println(e);
        }
     }
     
     public void sortmarks(Float mark, String username)
     {
         
        //int pos;
       // int arr[]= new int[50 ];
                Float temp = 0f, tempnext = 0f, ser = 0f, firstindexmarks=0f, lastindexmarks=0f;
                String tempuser="", tempusernext="";
                int numrow=0;
        try
        {
            Connection con = connectionprovider.connector();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select marks from "+tmarks+"");
            
            while(rs.next())
            {
                numrow=numrow+1;
                //temp=rs.getint(1);
            }
            
            
          int userindex=0;
          float  swapindexmarks=0f, swapindexmarks2=0f, useroldmarks=0f, userabovemarks=0f, userbelowmarks=0f;
          String firstindexusername="", swapindexusername="", swapindexusername2="", lastindexusername="", useraboveusername="", userbelowusername="";
          int firstindex=0, lastindex=0, useraboveindex=0, userbelowindex=0, swapindex=0;
          
          // if username is already taken the exam.
            
            
            ResultSet r2 = st.executeQuery("select * from "+tmarks+" where position=1");//for first index
            
            while(r2.next())
            {
                firstindex=r2.getInt(1);
               firstindexmarks=r2.getFloat(3);
               firstindexusername=r2.getString(2);
            }
            
            ResultSet r4 = st.executeQuery("select * from "+tmarks+" where position='"+numrow+"'");//for last index
            
            while(r4.next())
            {
                lastindex=r4.getInt(1);
               lastindexmarks=r4.getFloat(3);
               lastindexusername=r4.getString(2);
            }
            ResultSet r=st.executeQuery("select * from "+tmarks+" where username='"+username+"'");
            if(r.next()==true)
            {
                ResultSet r3 = st.executeQuery("select * from "+tmarks+" where username='"+username+"'"); 
                while(r3.next())
                {
                    userindex = r3.getInt(1);
                    useroldmarks = r3.getFloat(3);
                }
                
//                ResultSet r5 = st.executeQuery("select * from "+tmarks+" where position='"+(userindex-1)+"'"); 
//                while(r5.next())
//                {
//                    useraboveindex = r5.getInt(1);
//                    userabovemarks = r5.getFloat(3);
//                    useraboveusername = r5.getString(2);
//                }
                
//                 ResultSet r6 = st.executeQuery("select * from "+tmarks+" where position='"+(userindex+1)+"'"); 
//                while(r6.next())
//                {
//                    userbelowindex = r6.getInt(1);
//                    userbelowmarks = r6.getFloat(3);
//                    userbelowusername = r6.getString(2);
//                }
                
                
               /* if(mark==useroldmarks)//-------> first condition
                {
                    PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"' where username='"+username+"'");
                    p.executeUpdate();
                }//-----> end of first condition
                
                else if(userindex==firstindex)//-------> second condition
                {
                    if(mark>useroldmarks)
                    {
                   PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"' where username='"+username+"'");
                    p.executeUpdate();
                    }
                    
                    else if(mark<useroldmarks && mark>=userbelowmarks)
                    {
                       PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"' where username='"+username+"'");
                         p.executeUpdate(); 
                    }
                }//--------> end of second index
                
                
                else if(userindex==lastindex)//---------> third condition
                {
                    
                    if(mark<useroldmarks)
                    {
                        PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"' where username='"+username+"'");
                         p.executeUpdate();
                    }
                    
                    else if(mark>useroldmarks && marks<=userabovemarks)//
                    {
                        PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"' where username='"+username+"'");
                         p.executeUpdate();
                    }
                    
                }//----------------> end of third condition
                
                else if(userabovemarks>mark && userbelowmarks<mark)//------>fourth condition
                {
                     PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"' where username='"+username+"'");
                         p.executeUpdate();
                }
                
                else if(mark>firstindexmarks)//--------> fifth condition
                {
                                ResultSet r7 = st.executeQuery("select * from "+tmarks+" where position ='"+firstindex+"'");
                               while(r7.next())
                                {
                                    swapindexmarks=r7.getFloat(3);
                                    swapindexusername=r7.getString(2);
                                    
                                }
                               PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"' username='"+username+"' where position='"+firstindex+"'");
                                p.executeUpdate();
                                
                                for(int i=(firstindex+1); i<=userindex; i++)
                                    
                                {//-----> for loop initializtion
                                    if(i==userindex)
                                    {
                                        PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"' username='"+swapindexusername+"' where position='"+i+"'");
                                        p2.executeUpdate();
                                    }
                                    
                                    else
                                    {
                                        ResultSet r8 = st.executeQuery("select * from "+tmarks+" where position ='"+i+"'");
                               while(r8.next())
                                {
                                    swapindexmarks2=r8.getFloat(3);
                                    swapindexusername2=r8.getString(2);
                                    
                                }
                               
                               PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"' username='"+swapindexusername+"' where position='"+i+"'");
                                        p2.executeUpdate();
                               
                               
                                        swapindexmarks=swapindexmarks2;
                                        swapindexusername=swapindexusername2;
                                        
                                    }
                                }//-------> for loop termination
                }//-----> else if termination of username greater than firstindex marks
                
                else if(mark<lastindexmarks)//-------> sixth condition
                {
                                ResultSet r7 = st.executeQuery("select * from "+tmarks+" where position ='"+lastindex+"'");
                               while(r7.next())
                                {
                                    swapindexmarks=r7.getFloat(3);
                                    swapindexusername=r7.getString(2);
                                    
                                }
                               
                               PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"', username='"+username+"' where position='"+lastindex+"'");
                                p.executeUpdate();
                                
                                for(int i=(lastindex-1); i>=userindex; i--)
                                {
                                    if(i==userindex)
                                    {
                                         PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"' username='"+swapindexusername+"' where position='"+i+"'");
                                        p2.executeUpdate();
                                    }
                                    
                                    else
                                    {
                                         ResultSet r8 = st.executeQuery("select * from "+tmarks+" where position ='"+i+"'");
                               while(r8.next())
                                {
                                    swapindexmarks2=r8.getFloat(3);
                                    swapindexusername2=r8.getString(2);
                                    
                                }
                               
                               PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+i+"'");
                                        p2.executeUpdate();
                               
                               
                                        swapindexmarks=swapindexmarks2;
                                        swapindexusername=swapindexusername2;
                                    }
                                }//------> for loop termination
                }//-----------------> end of sixth condition
                
                else if(mark>useroldmarks)//------------> seventh condition
                {
                   for(int i=(userindex-1); i>=1; i--)
                   {
                                ResultSet r9 = st.executeQuery("select * from "+tmarks+" where position ='"+i+"'");
                               while(r9.next())
                                {
                                    swapindexmarks=r9.getFloat(3);
                                    swapindexusername=r9.getString(2);
                                    swapindex=r9.getInt(1);
                                                               
                                }
                               
                               if(swapindexmarks>=mark)
                               {//---------> if condition beginning
                                ResultSet r10 = st.executeQuery("select * from "+tmarks+" where position ='"+(i+1)+"'");
                               while(r10.next())
                                {
                                    swapindexmarks=r10.getFloat(3);
                                    swapindexusername=r10.getString(2);
                                    swapindex=r10.getInt(1);
                                                               
                                }
                                   
                                   PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"', username='"+username+"' where position='"+(i+1)+"'");
                                        p2.executeUpdate();
                                        
                                        for(int j=(i+2); j<=userindex; j++)
                                        {
                                            if(j==userindex)
                                            {
                                                 PreparedStatement p3 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+(j)+"'");
                                                    p3.executeUpdate();
                                            }
                                            
                                             ResultSet r11 = st.executeQuery("select * from "+tmarks+" where position ='"+(j)+"'");
                                        while(r11.next())
                                {
                                    swapindexmarks2=r11.getFloat(3);
                                    swapindexusername2=r11.getString(2);
                                    //swapindex=r11.getInt(1);
                                                               
                                }
                                        
                                        PreparedStatement p3 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+(j)+"'");
                                                    p3.executeUpdate();
                                                    
                                                    
                                            swapindexmarks=swapindexmarks2;
                                        swapindexusername=swapindexusername2;
                                            
                                        }//for loop termination through j
                               }//------->  if termination
                               i=1;
                   }//------> for loop termination through i
                }//-----> end of seventh condition
                
                
                else if(mark<useroldmarks)//------------> eigth condition
                {
                   for(int i=(userindex+1); i<=lastindex; i++)
                   {
                                ResultSet r9 = st.executeQuery("select * from "+tmarks+" where position ='"+i+"'");
                               while(r9.next())
                                {
                                    swapindexmarks=r9.getFloat(3);
                                    swapindexusername=r9.getString(2);
                                    swapindex=r9.getInt(1);
                                                               
                                }
                               
                               if(swapindexmarks<=mark)
                               {//---------> if condition beginning
                                ResultSet r10 = st.executeQuery("select * from "+tmarks+" where position ='"+(i-1)+"'");
                               while(r10.next())
                                {
                                    swapindexmarks=r10.getFloat(3);
                                    swapindexusername=r10.getString(2);
                                    swapindex=r10.getInt(1);
                                                               
                                }
                                   
                                   PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"', username='"+username+"' where position='"+(i-1)+"'");
                                        p2.executeUpdate();
                                        
                                        for(int j=(i-2); j>=userindex; j--)
                                        {
                                            if(j==userindex)
                                            {
                                                 PreparedStatement p3 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+(j)+"'");
                                                    p3.executeUpdate();
                                            }
                                            
                                             ResultSet r11 = st.executeQuery("select * from "+tmarks+" where position ='"+(j)+"'");
                                        while(r11.next())
                                {
                                    swapindexmarks2=r11.getFloat(3);
                                    swapindexusername2=r11.getString(2);
                                    //swapindex=r11.getInt(1);
                                                               
                                }
                                        
                                        PreparedStatement p3 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+(j)+"'");
                                                    p3.executeUpdate();
                                                    
                                                    
                                            swapindexmarks=swapindexmarks2;
                                        swapindexusername=swapindexusername2;
                                            
                                        }//for loop termination through j
                               }//------->  if termination
                               i=1;
                   }//------> for loop termination through i
                }//-----> end of eigth condition
                */
                
            
                
                
               if(mark>useroldmarks)
                {
                  
                    if(userindex==1)
                    {
                        
                        PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"' where username='"+username+"'");
                        p.executeUpdate(); 
                    }//----->userindex==1
                    
                    else if(mark>firstindexmarks)
                    {
                        swapindexmarks=firstindexmarks;
                        swapindexusername=firstindexusername;
                        
                        PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"', username='"+username+"' where position=1");
                        p.executeUpdate();
                        
                        for(int i=2; i<=userindex; i++)
                        {
                            if(i==userindex)
                            {
                            PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+i+"'");
                            p2.executeUpdate();
                            }
                            
                            else
                            {
                               //Float swapindexmarks2=0f;
                               
                               //String swapindexusername2="";
                               
                               ResultSet r5 = st.executeQuery("select * from "+tmarks+" where position ='"+i+"'");
                               while(r5.next())
                                {
                                    swapindexmarks2=r5.getFloat(3);
                                    swapindexusername2=r5.getString(2);
                                    
                                }
                                PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+i+"'");
                                    p2.executeUpdate();
                                    
                                     
                               
                                swapindexmarks=swapindexmarks2;
                                swapindexusername=swapindexusername2;
                                
                            }//-->else termination       here
                        }//--->for loop termination
                        
                    }//--->elseif termination of new marks greater than first rank page
                    
                    else
                    {
                        
                        for(int i =(userindex-1); i>=1; i--)
                        {
                            ResultSet r5 = st.executeQuery("select * from "+tmarks+" where position ='"+i+"'");
                               while(r5.next())
                                {
                                    swapindexmarks=r5.getFloat(3);
                                                               
                                }
                               
                               if(mark<=swapindexmarks)
                               {
                                   //Float swapindexmarks2=0f;
                               
                              // String swapindexusername2="";
                               
                                   ResultSet r6 = st.executeQuery("select * from "+tmarks+" where position ='"+(i+1)+"'");
                               while(r6.next())
                                {
                                    swapindexmarks=r6.getFloat(3);
                                    swapindexusername=r6.getString(2);
                                      
                                }
                               PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"', username='"+username+"' where position='"+(i+1)+"'");
                            p2.executeUpdate();
                            
                            for(int j=(i+2); j<=userindex; j++)
                            {
                              if(j==userindex)
                              {
                                  PreparedStatement p3 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+j+"'");
                                   p3.executeUpdate();
                              }// here
                              
                              else
                              {
                                  ResultSet r7 = st.executeQuery("select * from "+tmarks+" where position ='"+j+"'");
                               while(r7.next())
                                {
                                    swapindexmarks2=r7.getFloat(3);
                                    swapindexusername2=r7.getString(2);
                                    
                                }
                                PreparedStatement p3 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+j+"'");
                                p3.executeUpdate();
                                    
                                     
                               
                                swapindexmarks=swapindexmarks2;
                                swapindexusername=swapindexusername2;
                              }
                              
                            }//----->for loop termination iterating through j
                               
                                   i=1;
                               }//----->if termination of new marks less than to any given index
                        }//--->for loop termination iterating through i
                    }//-->else termination // here
                    
                    
                }//------>elseif termination of new marks greater than old marks
            
                
                else if(mark<useroldmarks)
                {
                     if(userindex==numrow)
                    {
                        
                        PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"' where username='"+username+"'");
                        p.executeUpdate(); 
                    }//----->userindex==1
                     
                     else if(mark<lastindexmarks)
                     {
                         swapindexmarks=lastindexmarks;
                        swapindexusername=lastindexusername;
                        
                        PreparedStatement p = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"', username='"+username+"' where position='"+numrow+"'");
                        p.executeUpdate();
                        
                        
                        for(int i=(numrow-1); i>=userindex; i--)
                        {
                            if(i==userindex)
                            {
                            PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+i+"'");
                            p2.executeUpdate();
                            }
                            
                            else
                            {
                               //Float swapindexmarks2=0f;
                               
                               //String swapindexusername2="";
                               
                               ResultSet r5 = st.executeQuery("select * from "+tmarks+" where position ='"+i+"'");
                               while(r5.next())
                                {
                                    swapindexmarks2=r5.getFloat(3);
                                    swapindexusername2=r5.getString(2);
                                    
                                }
                                PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+i+"'");
                                    p2.executeUpdate();
                                    
                                     
                               
                                swapindexmarks=swapindexmarks2;
                                swapindexusername=swapindexusername2;
                                
                            }//-->else termination
                        }//-----> for loop termination 
                       
                     }//------>else if termination of new marks less than lastindexmarks
                     
                     else
                     {
                         
                         for(int i=(userindex+1); i<=numrow; i++)
                         {
                             ResultSet r8 = st.executeQuery("select * from "+tmarks+" where position='"+i+"'");
                             while(r8.next())
                             {
                                 swapindexmarks=r8.getFloat(3);
                                // swapindexusername=r8.getString(2);
                             }
                             
                             if(mark>=swapindexmarks)
                             {
                                 ResultSet r9 = st.executeQuery("select * from "+tmarks+" where position='"+(i-1)+"'");
                             while(r9.next())
                             {
                                 swapindexmarks=r9.getFloat(3);
                                swapindexusername=r9.getString(2);
                             }
                             
                             PreparedStatement p2 = con.prepareStatement("update "+tmarks+" set marks= '"+mark+"', username='"+username+"' where position='"+(i-1)+"'");
                             p2.executeUpdate();
                             
                             for(int j=(i-2); j>=userindex; j--)
                             {
                                 if(j==userindex)
                                 {
                                     PreparedStatement p3 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+j+"'");
                                      p3.executeUpdate();
                                 }
                                 
                                 else
                                 {
                                     
                                     //Float swapindexmarks2=0f;
                               
                              // String swapindexusername2="";
                                     ResultSet r7 = st.executeQuery("select * from "+tmarks+" where position ='"+j+"'");
                               while(r7.next())
                                {
                                    swapindexmarks2=r7.getFloat(3);
                                    swapindexusername2=r7.getString(2);
                                    
                                }
                                PreparedStatement p3 = con.prepareStatement("update "+tmarks+" set marks= '"+swapindexmarks+"', username='"+swapindexusername+"' where position='"+j+"'");
                                p3.executeUpdate();
                                    
                                     
                               
                                swapindexmarks=swapindexmarks2;
                                swapindexusername=swapindexusername2;
                                     
                                 }
                                 
                             }//------->for loop termination iterating through j 
                                 
                               i=numrow;  
                             }//------->if termination of new marks greater than given index marks
                             
                         }//--------> for loop termination
                         
                     }//--->else termination
                     
                     
                }//------->elseif termination of new marks less than old marks
                
            
            }//---->Ist if termination
            
                
            
                else
            {
           
            for(int i =1; i<=numrow; i++)
            {
                 ResultSet rs2  = st.executeQuery("select marks from "+tmarks+" where position='"+i+"'");
                 while(rs2.next())
                 {
                     ser=rs2.getFloat(1);
                 }
                 if(mark>ser)
                 {
                     if(i==numrow)
                     { 
                         ResultSet rs3 = st.executeQuery("select * from "+tmarks+" where position='"+i+"'");
                         while(rs3.next())
                         {
                             temp=rs3.getFloat(3);
                             tempuser = rs3.getString(2);
                         }
                         
                         PreparedStatement p1=con.prepareStatement("update "+tmarks+" set marks='"+mark+"', username='"+username+"' where position='"+i+"'");
                         p1.executeUpdate();
                         
                         PreparedStatement p2=con.prepareStatement("insert into "+tmarks+"(username,marks) values('"+tempuser+"','"+temp+"')");
                         p2.executeUpdate();
                         i=numrow+1;
                     }
                     
                     else if(i==(numrow-1))
                             {
                                  ResultSet rs3 = st.executeQuery("select * from "+tmarks+" where position='"+i+"'");
                         while(rs3.next())
                         {
                             temp=rs3.getFloat(3);
                             tempuser = rs3.getString(2);
                         }
                         PreparedStatement p1=con.prepareStatement("update "+tmarks+" set marks='"+mark+"', username='"+username+"' where position='"+i+"'");
                         p1.executeUpdate();
                         
                          ResultSet rs4 = st.executeQuery("select * from "+tmarks+" where position='"+(i+1)+"'");
                         while(rs4.next())
                         {
                             tempnext=rs4.getFloat(3);
                             tempusernext = rs4.getString(2);       
                         }
                         
                         PreparedStatement p2=con.prepareStatement("update "+tmarks+" set marks='"+temp+"', username='"+tempuser+"' where position='"+(i+1)+"'");
                         p2.executeUpdate();
                         
                         PreparedStatement p3=con.prepareStatement("insert into "+tmarks+"(username,marks) values('"+tempusernext+"','"+tempnext+"')");
                         p3.executeUpdate();
                         i=numrow+1;
                             }
                
                     else
                     {
                          ResultSet rs3 = st.executeQuery("select * from "+tmarks+" where position='"+i+"'");
                         while(rs3.next())
                         {
                             temp=rs3.getFloat(3);
                             tempuser = rs3.getString(2);
                         }
                         
                         PreparedStatement p1=con.prepareStatement("update "+tmarks+" set marks='"+mark+"', username='"+username+"' where position='"+i+"'");
                         p1.executeUpdate();
                         
                         ResultSet rs4 = st.executeQuery("select * from "+tmarks+" where position='"+(i+1)+"'");
                         while(rs4.next())
                         {
                             tempnext=rs4.getFloat(3);
                             tempusernext = rs4.getString(2);

                         }
                         System.out.print(tempnext);
                         
                          PreparedStatement p2=con.prepareStatement("update "+tmarks+" set marks='"+temp+"', username='"+tempuser+"' where position='"+(i+1)+"'");
                         p2.executeUpdate();
                         
                         for(int j=(i+2); j<=numrow; j++)
                         {
                             if(j==numrow)
                             {
                                  ResultSet rs5 = st.executeQuery("select * from "+tmarks+" where position='"+j+"'");
                                    while(rs5.next())
                                     {
                                        temp=rs5.getFloat(3);
                                        tempuser = rs5.getString(2);

                                      }
                                    PreparedStatement p3=con.prepareStatement("update "+tmarks+" set marks='"+tempnext+"', username='"+tempusernext+"' where position='"+j+"'");
                                       p3.executeUpdate();
                                       
                                       PreparedStatement p4=con.prepareStatement("insert into "+tmarks+"(username,marks) values('"+tempuser+"','"+temp+"')");
                                        p4.executeUpdate();
                                        i=numrow+1;
                                        j=numrow+1;
                             }
                             
                             else if(j==(numrow-1))
                             {
                                  ResultSet rs5 = st.executeQuery("select * from "+tmarks+" where position='"+j+"'");
                         while(rs5.next())
                         {
                             temp=rs5.getFloat(3);
                             tempuser = rs5.getString(2);
                         }
                         PreparedStatement p3=con.prepareStatement("update "+tmarks+" set marks='"+tempnext+"', username='"+tempusernext+"' where position='"+j+"'");
                         p3.executeUpdate();
                         
                          ResultSet rs6 = st.executeQuery("select * from "+tmarks+" where position='"+(j+1)+"'");
                         while(rs6.next())
                         {
                             tempnext=rs6.getFloat(3);
                             tempusernext = rs6.getString(2);
                         }
                         
                         PreparedStatement p4=con.prepareStatement("update "+tmarks+" set marks='"+temp+"', username='"+tempuser+"' where position='"+(j+1)+"'");
                         p4.executeUpdate();
                         
                         PreparedStatement p5=con.prepareStatement("insert into "+tmarks+"(username,marks) values('"+tempusernext+"','"+tempnext+"')");
                         p5.executeUpdate();
                         i=numrow+1;
                         j=numrow+1;
                             }
                             
                             else
                             {
                              ResultSet rs5 = st.executeQuery("select * from "+tmarks+" where position='"+j+"'");
                         while(rs5.next())
                         {
                             temp=rs5.getFloat(3);
                             tempuser = rs5.getString(2);
                         }
                         PreparedStatement p3=con.prepareStatement("update "+tmarks+" set marks='"+tempnext+"', username='"+tempusernext+"' where position='"+j+"'");
                         p3.executeUpdate();
                         
                          ResultSet rs6 = st.executeQuery("select * from "+tmarks+" where position='"+(j+1)+"'");
                         while(rs6.next())
                         {
                             tempnext=rs6.getFloat(3);
                             tempusernext = rs6.getString(2);
                         }
                         
                         
                         
                         PreparedStatement p4=con.prepareStatement("update "+tmarks+" set marks='"+temp+"', username='"+tempuser+"' where position='"+(j+1)+"'");
                         p4.executeUpdate();
                             }
                         
                             
                         }
                         
                     }
                     
                 }
            

                 else
                 {
                     if(i==numrow)
                     {
                         //int mark2=mark;
                         PreparedStatement p5=con.prepareStatement("insert into "+tmarks+"(username,marks) values('"+username+"','"+mark+"')");
                         p5.executeUpdate();
                     }
                 }
                     
            }//  try close
        }
        }
        
                
            
            
    
        
        catch(Exception e)
        {
            JOptionPane p = new JOptionPane("sorry some unknown error is occuring");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
            System.out.print(e);
        }
     }
     public void answercheck()
     {
              String answer="";

       if(option1.isSelected())
       {
          answer = option1.getText();
       }
       else if(option2.isSelected())
       {
          answer = option2.getText();
       }
       else if(option3.isSelected())
       {
          answer = option3.getText();
       }
       else if(option4.isSelected())
       {
          answer = option4.getText();
       }
       
       else
       {
           answer="";
       }
       
       
       try
       {
           Connection con = connectionprovider.connector();
           Statement st = con.createStatement();
           
           ResultSet rs = st.executeQuery("select * from "+tquestion+" where sno='"+no+"'");
           while(rs.next())
           {
           if(answer.equals(rs.getString(7)))
           {
               marks=marks+1;
               cques=cques+1;
           }
           else if(answer.equals(""))
           {
               marks=marks+0;
               uaques=uaques+1;
           }
           
           else
           {
               marks=marks-(.25f);
               iques=iques+1;
           }
           
           }
       }
       
       catch(Exception e)
       {
           JOptionPane p = new JOptionPane("sorry there is some problem in processing further");
                  Dialog d = p.createDialog("Warning");
                  d.setAlwaysOnTop(true);
                  d.setVisible(true);
           System.out.println(e);
       }
       
     }
                  Timer time;
                  
    
   // public int min =2;
    public quizpage(String username, String name, String tname) {
        initComponents();
        
        tmarks=tname;
        if(tname.equals("cppmarks"))
        {
            tsummary="cppquizsummary";
            tquestion="cppquestion";
        }
        
        if(tname.equals("dbmsmarks"))
        {
            tsummary="dbmsquizsummary";
            tquestion="dbmsquestion";
        }
        
        if(tname.equals("javamarks"))
        {
            tsummary="javaquizsummary";
            tquestion="javaquestion";
        }
        
        if(tname.equals("cmarks"))
        {
            tsummary="cquizsummary";
            tquestion="cquestion";
        }
         String user = username;
        uservar.setText(username);
        namevar.setText(name);
        showques(no);
       
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        //Date date = dFormat.format(new Date());
        
       // fdate.setText(dFormat.format(date));
       // showques(no);
        
            setLocationRelativeTo(this);
            
            time = new Timer(1000, new ActionListener()
                    {
                        @Override
                      public void actionPerformed(ActionEvent e)
                    {
                    //fmin.setText(String.valueOf(min)+" Min");
                    fsec.setText(String.valueOf(sec)+" sec");
                    
                    if(sec==0 && no==20)
                    {    time.stop();
                        //answercheck();
                        submit(username);
                    }
                    
                    else if(sec==0 && no!=20)
                    {    answercheck();
                        no= no+1;
                        sec=60;
                        showques(no);
                        option1.setSelected(false);
                        option2.setSelected(false);
                        option3.setSelected(false);
                        option4.setSelected(false);

                    }
                    
                    sec--;
                    
                    }
                    });
            time.start();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namevar = new javax.swing.JLabel();
        uservar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fsec = new javax.swing.JLabel();
        qno = new javax.swing.JLabel();
        qvar = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        snvar = new javax.swing.JButton();
        subvar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1378, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("GO QUIZ");

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(598, 100));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("NAME");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("USERNAME");

        namevar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        namevar.setForeground(new java.awt.Color(242, 242, 242));
        namevar.setText("NAME");

        uservar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uservar.setForeground(new java.awt.Color(242, 242, 242));
        uservar.setText("UNAME");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("TOTAL TIME");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("REMAINING TIME");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("1MIN/QUES");

        fsec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fsec.setForeground(new java.awt.Color(242, 242, 242));
        fsec.setText("60 SEC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namevar)
                    .addComponent(uservar))
                .addGap(117, 117, 117)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(fsec))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namevar)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(uservar)
                    .addComponent(jLabel7)
                    .addComponent(fsec))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 607, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        qno.setFont(new java.awt.Font("Segoe UI", 3, 25)); // NOI18N
        qno.setForeground(new java.awt.Color(242, 242, 242));
        qno.setText("QUESTION");
        getContentPane().add(qno, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 132, -1, -1));

        qvar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        qvar.setForeground(new java.awt.Color(242, 242, 242));
        qvar.setText("QUESTION");
        getContentPane().add(qvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 213, -1, -1));

        option1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        option1.setForeground(new java.awt.Color(242, 242, 242));
        option1.setText("option1");
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });
        getContentPane().add(option1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 299, -1, -1));

        option2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        option2.setForeground(new java.awt.Color(242, 242, 242));
        option2.setText("option 2");
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });
        getContentPane().add(option2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 402, -1, -1));

        option3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        option3.setForeground(new java.awt.Color(242, 242, 242));
        option3.setText("option 3");
        option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ActionPerformed(evt);
            }
        });
        getContentPane().add(option3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 492, -1, -1));

        option4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        option4.setForeground(new java.awt.Color(242, 242, 242));
        option4.setText("option 4");
        option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ActionPerformed(evt);
            }
        });
        getContentPane().add(option4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 584, -1, -1));

        snvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        snvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/save&next.png"))); // NOI18N
        snvar.setText("SAVE & NEXT");
        snvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snvarActionPerformed(evt);
            }
        });
        getContentPane().add(snvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 691, -1, -1));

        subvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        subvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/submit.png"))); // NOI18N
        subvar.setText("SUBMIT");
        subvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subvarActionPerformed(evt);
            }
        });
        getContentPane().add(subvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 691, -1, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/cancel.png"))); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1157, 691, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quiz/afterpage.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        // TODO add your handling code here:
       if(option2.isSelected())
        {
            option1.setSelected(false);
            option3.setSelected(false);
            option4.setSelected(false);
        }
    }//GEN-LAST:event_option2ActionPerformed

    private void snvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snvarActionPerformed
        // TODO add your handling code here:
        answercheck();
        no =no+1;
        sec=60;
        showques(no);
        option1.setSelected(false);
        option2.setSelected(false);
        option3.setSelected(false);
        option4.setSelected(false);
    }//GEN-LAST:event_snvarActionPerformed

    private void subvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subvarActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Sure? You want to submit the quiz?", "Message",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
            time.stop();
            String username = uservar.getText();
            submit(username);
        }
    }//GEN-LAST:event_subvarActionPerformed

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        // TODO add your handling code here:
         if(option1.isSelected())
        {
            option2.setSelected(false);
            option3.setSelected(false);
            option4.setSelected(false);
        }
    }//GEN-LAST:event_option1ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed
        // TODO add your handling code here:
         if(option3.isSelected())
        {
            option2.setSelected(false);
            option1.setSelected(false);
            option4.setSelected(false);
        }
    }//GEN-LAST:event_option3ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed
        // TODO add your handling code here:
        if(option4.isSelected())
        {
            option2.setSelected(false);
            option3.setSelected(false);
            option1.setSelected(false);
        }
    }//GEN-LAST:event_option4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null,"Sure? You want to cancel the quiz?", "Warning",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
             
             new firstpage().setVisible(true);
             setVisible(false);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(quizpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quizpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quizpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quizpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new quizpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fsec;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel namevar;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JLabel qno;
    private javax.swing.JLabel qvar;
    private javax.swing.JButton snvar;
    private javax.swing.JButton subvar;
    private javax.swing.JLabel uservar;
    // End of variables declaration//GEN-END:variables
}
