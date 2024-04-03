
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;




public class Login extends JFrame implements ActionListener{
    
    JButton signin,clear,signup;
    JTextField t1;
    JPasswordField t2;
    
    Login(){
            setTitle("Automated Teller Machine");
            setLayout(null);
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
            Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel label=new JLabel(i3);
            label.setBounds(70,10, 100, 100);
            add(label);
            
            JLabel text=new JLabel("WELCOME TO ATM");
            text.setBounds(200, 10, 400, 100);
            text.setFont(new Font("Osward", Font.BOLD, 38));
            add(text);
            
           JLabel cardno=new JLabel("Card no: ");
            cardno.setBounds(110, 130, 200, 50);
            cardno.setFont(new Font("Osward", Font.BOLD, 28));
            add(cardno);
            
           t1=new JTextField();
            t1.setBounds(330, 140, 300, 30);
            add(t1);
            
            JLabel pin=new JLabel("Pin no : ");
            pin.setBounds(110, 200, 200, 50);
            pin.setFont(new Font("Osward", Font.BOLD, 28));
            add(pin);
            
            t2=new JPasswordField();
            t2.setBounds(330, 210, 300, 30);
            add(t2);
            
           signin=new JButton("SIGN IN");
           signin.setBounds(330,270,100,30);
           signin.setBackground(Color.BLACK);
           signin.setForeground(Color.WHITE);
           signin.addActionListener(this);
           add(signin);
           
           clear=new JButton("CLEAR");
           clear.setBounds(530,270,100,30);
           clear.setBackground(Color.BLACK);
           clear.setForeground(Color.WHITE);
           clear.addActionListener(this);
           add(clear);
           
           signup=new JButton("SIGN UP");
           signup.setBounds(430,340,100,30);
           signup.setBackground(Color.BLACK);
           signup.setForeground(Color.WHITE);
           signup.addActionListener(this);
           add(signup);
           
            
            getContentPane().setBackground(Color.WHITE);
            setSize(800,480);
            setVisible(true);
            setLocation(350,200);
                    
                  
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear)
        {
        t1.setText("");
        t2.setText("");
        }else if(ae.getSource()==signin)
        {
        Connec c1=new Connec(); 
        String cardnumber=t1.getText();
        String pinnumber=String.valueOf(t2.getPassword());
        String query="select * from login where card_no = '"+cardnumber+"' and pin_no = '"+pinnumber+"'";
        try{
            ResultSet rs=c1.stm.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Credentials");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
        
    }
}
