
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Withdrawal extends JFrame implements ActionListener
{
    JTextField wdw;
    JButton withdraw,back;
    String pinnumber;
    
    
    Withdrawal(String pinnumber)
    {
       this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0, 0, 900, 800);
       add(image); 
       
       JLabel text=new JLabel("Enter amount you want to withdraw");
       text.setBounds(220, 260, 300, 35);
       text.setForeground(Color.white);
       text.setFont(new Font("SYSTEM",Font.BOLD,16));
       image.add(text);
       
       wdw =new JTextField();
       wdw.setFont(new Font("Raleway",Font.BOLD,25));       
       wdw.setBounds(220,300,250,25);
       image.add(wdw);
       
       withdraw=new JButton("Withdraw");
       withdraw.setBounds(360,430,150,25);
       withdraw.addActionListener(this);
       image.add(withdraw);
       
       back=new JButton("Back");
       back.setBounds(360,460,150,25);
       back.addActionListener(this);
       image.add(back);
       
       setSize(900,800);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    { 
        try{
        if(ae.getSource()== withdraw)
        {
            String number = wdw.getText();
            Date date= new Date();
            String querydep="insert into bank values('"+pinnumber+"', '"+date+"', 'withdraw', '"+number+"')";
            if(number.equals("")){JOptionPane.showMessageDialog(null, "Please enter amount");}
            else{
                
                    Connec con2=new Connec();                
                    con2.stm.executeUpdate(querydep); 
                    JOptionPane.showMessageDialog(null, "Rs "+number+" withdrawn succesfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
               
                
            }
            
        }else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
         }catch(Exception e){
                    System.out.println(e);
                }
    }
    public static void main(String[] args) {
        new Withdrawal("").setVisible(true);
    }
}
