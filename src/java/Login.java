import java.sql.*;  
  
public class Login {  
public static boolean validate(String name,String pass){  
boolean status=false;  
try{  
//Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Carrent","root","root");  
      
PreparedStatement ps=con.prepareStatement("select * from ROOT.REGISTER where username=? and password=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(SQLException e){System.out.println(e);}  
return status;  
}  
}  