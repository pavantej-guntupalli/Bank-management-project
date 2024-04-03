
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame
{
    String pinnumber;
    MiniStatement(String pinnumber)
    {
        super("MiniStatement");
        this.pinnumber=pinnumber;
        
        setLayout(null);
        JLabel mini=new JLabel();
        mini.setBounds(20,120,400,200);
        add(mini);
        
        JLabel bank= new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);        
        add(card);
        
        JLabel bal=new JLabel();
        int balance=0;
       try{           
           Connec c=new Connec();
           ResultSet rs=c.stm.executeQuery("select * from bank where pin_no='"+pinnumber+"'");
           
           while(rs.next()){
               if(rs.getString("type").equals("deposit"))
               balance += Integer.parseInt(rs.getString("amount"));
               else{                      
                       balance -= Integer.parseInt(rs.getString("amount"));
                       } 
           }
       }catch(Exception e){
           System.out.println(e);
       }
        bal.setBounds(20,340,400,30);
        bal.setText("Your balance is : "+balance);
        add(bal);
        
        try{
            Connec c= new Connec();
            ResultSet rs=c.stm.executeQuery("select * from login where pin_no='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("card_no").substring(0,4)+"-XXXX-XXXX-"+rs.getString("card_no").substring(12));
            }            
        }catch(Exception e){
            System.out.println(e);
        }try{
            Connec c1= new Connec();
            ResultSet rs=c1.stm.executeQuery("select * from bank where pin_no='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>");
                
            }
        }catch(Exception e){
                System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(20,20);        
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
