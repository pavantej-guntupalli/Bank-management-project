
package bankmanagementsystem;
import java.sql.*;


public class Connec 
{
    Connection c;
    Statement stm;
    String url="jdbc:mysql://localhost:3306/bankmanagement";
    Connec(){
        try
        {         
         c=DriverManager.getConnection(url,"root","tiger");
         stm=c.createStatement();
         
         
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
