
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener
{
    JButton d1,d2,d3,d4,d5,d6,d7;
    String pinnumber;
   FastCash(String pinnumber)
   {
       this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0, 0, 900, 800);
       add(image);
       
       JLabel text=new JLabel("Select Withdrawal Amount");
       text.setBounds(235, 260, 700, 35);
       text.setForeground(Color.white);
       text.setFont(new Font("SYSTEM",Font.BOLD,16));
       image.add(text);
       
       d1=new JButton("Rs 100");
       d1.setBounds(160,370,150,25);
       d1.addActionListener(this);
       image.add(d1);
       
       d2=new JButton("RS 500");
       d2.setBounds(360,370,150,25);
       d2.addActionListener(this);
       image.add(d2);
       
       d3=new JButton("Rs 1000");
       d3.setBounds(160,400,150,25);
       d3.addActionListener(this);
       image.add(d3);
       
       d4=new JButton("Rs 2000");
       d4.setBounds(360,400,150,25);
       d4.addActionListener(this);
       image.add(d4);
       
       d5=new JButton("Rs 5000");
       d5.setBounds(160,430,150,25);
       d5.addActionListener(this);
       image.add(d5);
       
       d6=new JButton("Rs 10000");
       d6.setBounds(360,430,150,25);
       d6.addActionListener(this);
       image.add(d6);
       
       d7=new JButton("Back");
       d7.setBounds(360,460,150,25);
       d7.addActionListener(this);
       image.add(d7);
       
       setSize(900,800);
       setLocation(300, 0);  
       setUndecorated(true);
       setVisible(true);
       
       
   }
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==d7){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }
       else {
            try{
           String amount= ((JButton)ae.getSource()).getText().substring(3);
           Connec c=new Connec();
           ResultSet rs=c.stm.executeQuery("select * from bank where pin_no='"+pinnumber+"'");
               int balance=0;
           while(rs.next()){
               if(rs.getString("type").equals("deposit"))
               balance += Integer.parseInt(rs.getString("amount"));
               else{
                      
                       balance -= Integer.parseInt(rs.getString("amount"));
                       } 
           }
           if(ae.getSource() != d7 && balance < Integer.parseInt(amount)){
               JOptionPane.showMessageDialog(null,"Insufficient Funds");
               return;
           }
           Date date= new Date();           
           String query="insert into bank values('"+pinnumber+"', '"+date+"', 'withdraw', '"+amount+"')";
           c.stm.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Rs "+amount+" withdrawn successfully");
           
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
   }catch(Exception e){
               System.out.println(e);
       }
   }
   }
    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
    
