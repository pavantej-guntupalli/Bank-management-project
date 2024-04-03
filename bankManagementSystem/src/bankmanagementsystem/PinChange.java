
package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener
{
    String pinnumber;
    JPasswordField newPin,reNewPin;
    JButton changePin,cancel;
    PinChange(String pinnumber)
    {
       this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0, 0, 900, 800);
       add(image);
       
       JLabel text=new JLabel("Change your PIN");
       text.setBounds(270, 260, 300, 35);
       text.setForeground(Color.white);
       text.setFont(new Font("SYSTEM",Font.BOLD,16));
       image.add(text);
       
       JLabel pin=new JLabel("Enter new PIN : ");
       pin.setBounds(160, 305, 200, 30);
       pin.setForeground(Color.white);
       pin.setFont(new Font("SYSTEM",Font.BOLD,14));
       image.add(pin);
       
       newPin=new JPasswordField();
       newPin.setBounds(360,305,150,30);       
       newPin.setFont(new Font("SYSTEM",Font.BOLD,14));
       image.add(newPin);
       
       JLabel reenter=new JLabel("Re-Enter new PIN : ");
       reenter.setBounds(160, 340, 200, 30);
       reenter.setForeground(Color.white);
       reenter.setFont(new Font("SYSTEM",Font.BOLD,14));
       image.add(reenter);
       
       reNewPin=new JPasswordField();
       reNewPin.setBounds(360,340,150,30);       
       reNewPin.setFont(new Font("SYSTEM",Font.BOLD,14));
       image.add(reNewPin);
       
       changePin=new JButton("Change PIN");
       changePin.setBounds(360,430,150,25);
       changePin.addActionListener(this);
       image.add(changePin);
       
        cancel=new JButton("Back");
        cancel.setBounds(360,460,150,25);
        cancel.addActionListener(this);
        image.add(cancel);
       
       setSize(900,800);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try{
            String npin=String.valueOf(newPin.getPassword());
            String rpin=String.valueOf(reNewPin.getPassword());
        if(ae.getSource()==cancel){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else if(ae.getSource()==changePin){
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Fields doesn't Match");
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Pin cannot be empty");
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "COnfirm new PIN is empty");
            }
            Connec c=new Connec();
            String q1="update bank set pin_no='"+npin+"' where pin_no='"+pinnumber+"'";
            String q2="update login set pin_no='"+npin+"' where pin_no='"+pinnumber+"'";
            String q3="update signupthree set pin_no='"+npin+"' where pin_no='"+pinnumber+"'";
            
            c.stm.executeUpdate(q1);
            c.stm.executeUpdate(q2);
            c.stm.executeUpdate(q3);
            JOptionPane.showMessageDialog(null, "PIN change succesfull");
            setVisible(false);
            new Transactions(npin).setVisible(true);
            
        }
    }catch(Exception e){
            System.out.println(e);
    }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
