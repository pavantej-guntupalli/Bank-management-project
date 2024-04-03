
package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    JLabel t1;
    BalanceEnquiry( String pinnumber)
    {
       this.pinnumber=pinnumber;
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0, 0, 900, 800);
       add(image);
       
       back=new JButton("Back");
       back.setBounds(360,460,150,25);
       back.addActionListener(this);
       image.add(back);
       
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
       
       t1=new JLabel();
       t1.setText("Your account balance is : Rs "+balance);
       t1.setForeground(Color.white);
       t1.setBounds(160,260,300,30);
       t1.setFont(new Font("Raleway",Font.BOLD,14));
       image.add(t1);
       
       setSize(900,800);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
