package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener{
    JTextField occu,pan,aadh;
    JRadioButton b1,b2,m1,m2;
    JComboBox religionc,categoryc,incomec,eduf;
    JButton next;
    String formno;
    
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE - 2");
        
        
        JLabel additionalDetails= new JLabel("ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(240,80,600,40);
        add(additionalDetails);
        
        JLabel religion= new JLabel("Religion : ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String rel[]={"Hindu","Christian","Muslim","Sikh","Jain","other"};
        religionc= new JComboBox(rel);
        religionc.setBackground(Color.white);
        religionc.setBounds(320,140 , 300, 30);
        add(religionc);
                       
        JLabel category=new JLabel("Category : ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String cat[]={"General","BC","SC","ST"};
        categoryc= new JComboBox(cat);
        categoryc.setBackground(Color.white);
        categoryc.setBounds(320,190 , 300, 30);
        add(categoryc);
        
        JLabel income=new JLabel("Income : ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String inc[]={"none","1,00,000-2,00,000","2,00,000-3,00,000",">3,00,000"};
        incomec= new JComboBox(inc);
        incomec.setBackground(Color.white);
        incomec.setBounds(320, 240, 300, 30);
        add(incomec);
        
        JLabel edu=new JLabel("Educational ");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,300,200,30);
        add(edu);
                
        JLabel qua=new JLabel("Qualification : ");
        qua.setFont(new Font("Raleway",Font.BOLD,20));
        qua.setBounds(100,330,200,30);
        add(qua);
        
        String quas[]={"Tenth","Intermediate","Graduation","Post Graduation"};
        eduf=new JComboBox(quas);
        eduf.setBackground(Color.white);
        eduf.setBounds(320, 315 , 300, 30);
        add(eduf);
        
        JLabel occul=new JLabel("Occupation : ");
        occul.setFont(new Font("Raleway",Font.BOLD,20));
        occul.setBounds(100,390,200,30);
        add(occul);
        
        occu=new JTextField();
        occu.setFont(new Font("Raleway",Font.BOLD,14));
        occu.setBounds(320, 390 , 300, 30);
        add(occu);
                                      
        JLabel panl=new JLabel("PAN No : ");
        panl.setFont(new Font("Raleway",Font.BOLD,20));
        panl.setBounds(100,440,200,30);
        add(panl);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(320, 440 , 300, 30);
        add(pan);
        
        JLabel aad=new JLabel("Aadhar No : ");
        aad.setFont(new Font("Raleway",Font.BOLD,20));
        aad.setBounds(100,490,200,30);
        add(aad);
        
        aadh=new JTextField();
        aadh.setFont(new Font("Raleway",Font.BOLD,14));
        aadh.setBounds(320, 490 , 300, 30);
        add(aadh);
        
        JLabel state=new JLabel("Senior Citizen : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        b1=new JRadioButton("Yes");
        b1.setBackground(Color.white);
        b1.setBounds(320, 540, 100, 30);
        add(b1);
        
        b2=new JRadioButton("No");
        b2.setBackground(Color.white);
        b2.setBounds(440, 540, 100, 30);
        add(b2);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        
        
        JLabel pincode=new JLabel("Existing Customer : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        m1=new JRadioButton("Yes");
        m1.setBackground(Color.white);
        m1.setBounds(320, 590, 100, 30);
        add(m1);
        
        m2=new JRadioButton("No");
        m2.setBackground(Color.white);
        m2.setBounds(440, 590, 100, 30);
        add(m2);
        
        ButtonGroup mg=new ButtonGroup();
        mg.add(m1);
        mg.add(m2);
                        
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
        String sreligion=(String)religionc.getSelectedItem();
        String scategory=(String)categoryc.getSelectedItem();
        String sincome=(String)incomec.getSelectedItem();
        String sedu=(String)eduf.getSelectedItem();
        String soccupation=occu.getText();
        String span=pan.getText();
        String saadh=aadh.getText();
        String senior=null;
        if(b1.isSelected()) { senior="Yes";}
        if(b2.isSelected()) { senior="No";}
        
       
        String exist=null;
        if(m1.isSelected()) { exist="Yes";}
        if(m2.isSelected()) { exist="No";}
        
        
        
        try
        {
           
           Connec c=new Connec();
           String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+sedu+"','"+soccupation+"','"+span+"','"+saadh+"','"+senior+"','"+exist+"')";
           c.stm.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true); 
         
        }catch(Exception e)
        {
            System.out.println(e); 
        }
       
        
    }
    
    public static void main(String []args){
        
        new SignupTwo("");
    }
}
