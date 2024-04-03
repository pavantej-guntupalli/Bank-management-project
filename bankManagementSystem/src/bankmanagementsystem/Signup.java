package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.Random;


public class Signup extends JFrame implements ActionListener{
    JTextField namef,fnamef,emailf,addressf,cityf,statef,pincodef;
    JDateChooser dobf;
    JRadioButton b1,b2,m1,m2;
    JButton next;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);
    
    Signup()
    {
        setLayout(null);
         

        JLabel formno= new JLabel("APPLICATION FORM");
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(200,20,600,40);
        add(formno);
        
        JLabel details= new JLabel("PERSONAL DETAILS");
        details.setFont(new Font("Raleway",Font.BOLD,22));
        details.setBounds(240,80,600,40);
        add(details);
        
        JLabel name= new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        namef=new JTextField();
        namef.setFont(new Font("Raleway",Font.BOLD,14));
        namef.setBounds(320,140 , 300, 30);
        add(namef);
        
        JLabel fname=new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnamef=new JTextField();
        fnamef.setFont(new Font("Raleway",Font.BOLD,14));
        fnamef.setBounds(320,190 , 300, 30);
        add(fnamef);
        
        JLabel dob=new JLabel("Date of birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dobf=new JDateChooser();
        dobf.setFont(new Font("Raleway",Font.BOLD,14));
        dobf.setBounds(320, 240, 300, 30);
        add(dobf);
        
        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        b1=new JRadioButton("Male");
        b1.setBackground(Color.white);
        b1.setBounds(320, 290, 100, 30);
        add(b1);
        
        b2=new JRadioButton("Female");
        b2.setBackground(Color.white);
        b2.setBounds(440, 290, 100, 30);
        add(b2);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        
        
        JLabel email=new JLabel("Email Id : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailf=new JTextField();
        emailf.setFont(new Font("Raleway",Font.BOLD,14));
        emailf.setBounds(320, 340 , 300, 30);
        add(emailf);
        
        JLabel mar=new JLabel("Marital status : ");
        mar.setFont(new Font("Raleway",Font.BOLD,20));
        mar.setBounds(100,390,200,30);
        add(mar);
        
        m1=new JRadioButton("Married");
        m1.setBackground(Color.white);
        m1.setBounds(320, 390, 100, 30);
        add(m1);
        
        m2=new JRadioButton("Unmarried");
        m2.setBackground(Color.white);
        m2.setBounds(440, 390, 100, 30);
        add(m2);
        
        ButtonGroup mg=new ButtonGroup();
        mg.add(m1);
        mg.add(m2);
        
        JLabel address=new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressf=new JTextField();
        addressf.setFont(new Font("Raleway",Font.BOLD,14));
        addressf.setBounds(320, 440 , 300, 30);
        add(addressf);
        
        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityf=new JTextField();
        cityf.setFont(new Font("Raleway",Font.BOLD,14));
        cityf.setBounds(320, 490 , 300, 30);
        add(cityf);
        
        JLabel state=new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        statef=new JTextField();
        statef.setFont(new Font("Raleway",Font.BOLD,14));
        statef.setBounds(320, 540 , 300, 30);
        add(statef);
        
        JLabel pincode=new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pincodef=new JTextField();
        pincodef.setFont(new Font("Raleway",Font.BOLD,14));
        pincodef.setBounds(320, 590 , 300, 30);
        add(pincodef);
        
        next=new JButton("NEXT");
        next.setBounds(520, 640, 100, 30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        String formno=first;
        String name=namef.getText();
        String fname=fnamef.getText();
        String dob=((JTextField) dobf.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(b1.isSelected()) { gender="Male";}
        if(b2.isSelected()) { gender="Female";}
        String email=emailf.getText();
       
        String marital=null;
        if(m1.isSelected()) { marital="Married";}
        if(m2.isSelected()) { marital="Unmarried";}
        
        String address=addressf.getText();
        String city=cityf.getText();
        String state=statef.getText();
        String pincode=pincodef.getText();
        
        try
        {
           if(name.equals(""))
           {JOptionPane.showMessageDialog(null, "Name is Required");}
           else 
           {
           Connec c=new Connec();
           String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
           c.stm.executeUpdate(query);
               setVisible(false);
               new SignupTwo(formno).setVisible(true);
           }
        }catch(Exception e)
        {
            System.out.println(e); 
        }
       
        
    }
    
    public static void main(String []args){
        
        new Signup();
    }
}
