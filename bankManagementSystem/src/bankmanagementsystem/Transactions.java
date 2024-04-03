
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener
{
    JButton deposit,withdrawal,fastcash,ministm,pinchange,balanceenq,exit;
    String pinnumber;
   Transactions(String pinnumber)
   {
       this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0, 0, 900, 800);
       add(image);
       
       JLabel text=new JLabel("Please select your transaction");
       text.setBounds(235, 260, 700, 35);
       text.setForeground(Color.white);
       text.setFont(new Font("SYSTEM",Font.BOLD,16));
       image.add(text);
       
       deposit=new JButton("Deposit");
       deposit.setBounds(160,370,150,25);
       deposit.addActionListener(this);
       image.add(deposit);
       
       withdrawal=new JButton("Cash Withdrawal");
       withdrawal.setBounds(360,370,150,25);
       withdrawal.addActionListener(this);
       image.add(withdrawal);
       
       fastcash=new JButton("Fast Cash");
       fastcash.setBounds(160,400,150,25);
       fastcash.addActionListener(this);
       image.add(fastcash);
       
       ministm=new JButton("Mini Statement");
       ministm.setBounds(360,400,150,25);
       ministm.addActionListener(this);
       image.add(ministm);
       
       pinchange=new JButton("Pin change");
       pinchange.setBounds(160,430,150,25);
       pinchange.addActionListener(this);
       image.add(pinchange);
       
       balanceenq=new JButton("Balance Enquiry");
       balanceenq.setBounds(360,430,150,25);
       balanceenq.addActionListener(this);
       image.add(balanceenq);
       
       exit=new JButton("Exit");
       exit.setBounds(360,460,150,25);
       exit.addActionListener(this);
       image.add(exit);
       
       setSize(900,800);
       setLocation(300, 0);  
       setUndecorated(true);
       setVisible(true);
       
       
   }
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==exit){System.exit(0);}
       else if(ae.getSource() == deposit)
       {
           setVisible(false);
           new Deposit(pinnumber).setVisible(true);
           
       }else if(ae.getSource() == withdrawal){
           setVisible(false);
           new Withdrawal(pinnumber).setVisible(true);
       }else if(ae.getSource()==fastcash){
           setVisible(false);
           new FastCash(pinnumber).setVisible(true);
       }else if(ae.getSource()==pinchange){
           setVisible(false);
           new PinChange(pinnumber).setVisible(true);
       }else if(ae.getSource() == balanceenq){
           setVisible(false);
           new BalanceEnquiry(pinnumber).setVisible(true);
       }else if(ae.getSource()== ministm){
           
           new MiniStatement(pinnumber).setVisible(true);
       }
   }
    public static void main(String[] args) {
        new Transactions("");
    }
}
