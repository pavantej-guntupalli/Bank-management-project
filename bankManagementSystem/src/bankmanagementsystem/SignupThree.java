
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.JLabel;


public class SignupThree extends JFrame implements ActionListener
{
        JRadioButton r1,r2,r3,r4;
        JCheckBox c1,c2,c3,c4,c5,c6,c7;
        JButton b1,b2;
        String formno;
        ButtonGroup bg;
    SignupThree(String formno)
    {         
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(240, 20, 600, 50);
        add(l1);
        
        JLabel l2=new JLabel("Account Type : ");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(100, 100, 200, 30);
        add(l2);
        
        r1=new JRadioButton("Savings account");
        r1.setFont(new Font("Raleway",Font.BOLD,14));        
        r1.setBounds(120, 150, 200, 30);
        add(r1);
        
        r2=new JRadioButton("Current account");
        r2.setFont(new Font("Raleway",Font.BOLD,14));        
        r2.setBounds(340, 150, 200, 30);
        add(r2);
        
        r3=new JRadioButton("Recurrent Account");
        r3.setFont(new Font("Raleway",Font.BOLD,14));       
        r3.setBounds(120, 200, 200, 30);
        add(r3);
        
        r4=new JRadioButton("Fixed Deposit");
        r4.setFont(new Font("Raleway",Font.BOLD,14));        
        r4.setBounds(340, 200, 200, 30);
        add(r4);
        
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        
        JLabel l3=new JLabel("Card No : ");
        l3.setFont(new Font("Raleway",Font.BOLD,22));
        l3.setBounds(100, 250, 300, 30);
        add(l3);
        
        JLabel l4=new JLabel("XXXX-XXXX-XXXX-4434");
        l4.setFont(new Font("Raleway",Font.BOLD,22));
        l4.setBounds(420, 250, 250, 30);
        add(l4);
        
        JLabel cardDetails=new JLabel("This is your 16 digit card number");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100, 290, 250, 20);
        add(cardDetails);
        
        JLabel l5=new JLabel("PIN : ");
        l5.setFont(new Font("Raleway",Font.BOLD,22));
        l5.setBounds(100, 330, 300, 30);
        add(l5);
        
        JLabel pinDetails=new JLabel("Your 4 digit password");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetails.setBounds(100, 370, 200, 20);
        add(pinDetails);
        
        JLabel l6=new JLabel("XXXX");
        l6.setFont(new Font("Raleway",Font.BOLD,22));
        l6.setBounds(420, 330, 200, 30);
        add(l6);
        
        JLabel services=new JLabel("Services Required : ");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,420,300,50);
        add(services);
        
        c1=new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100, 490, 200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(320, 490, 200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100, 540, 200,30);
        add(c3);
        
        c4=new JCheckBox("Email and SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(320, 540, 200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100, 590, 200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(320, 590, 200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declare that the above details are true");
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100, 640, 400,30);
        add(c7);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(520, 640, 100, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(610, 640, 100, 30);
        b2.addActionListener(this);
        add(b2);
                        
        setSize(850,800);
        setLocation(350, 0);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== b1)
        {
            String accountType = null;
            if(r1.isSelected())accountType = "Savings Account";
            else if(r2.isSelected())accountType = "Current Account";
            else if(r3.isSelected())accountType = "Recurrent Account";
            else if(r2.isSelected())accountType = "Fixed Deposit";
            
            Random ran=new Random();
            String cardnumber=""+Math.abs((ran.nextLong()%90000000L)+5040936000000000L);
            
            String pinno=""+Math.abs((ran.nextLong()%9000L)+1000L);
            
            String facility ="";
            if(c1.isSelected())facility=facility+" ATM Card";
            else if(c2.isSelected())facility=facility+" Internet Banking";
            else if(c3.isSelected())facility=facility+" Mobile Banking";
            else if(c4.isSelected())facility=facility+" Mobile and SMS Alerts";
            else if(c5.isSelected())facility=facility+" Cheque book";
            else if(c6.isSelected())facility=facility+" E-statement";
            
            try{
                if(accountType.isEmpty()){
                    JOptionPane.showMessageDialog(null, "account type is empty");
                }else if(c7.isSelected()){
                    Connec conn=new Connec();
                    String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"', '"+pinno+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"', '"+pinno+"')";
                    conn.stm.executeUpdate(query1);
                    conn.stm.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "CARD NUMBER "+cardnumber +"\n pin "+pinno);
                    
                    setVisible(false);
                    new Deposit(pinno).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == b2)
        {
             setVisible(false);
             new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
