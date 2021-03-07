<%-- 
    Document   : AdminDeleteData
    Created on : Oct 15, 2020, 10:36:29 PM
    Author     : girish_nai
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try
            {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Carrent", "root", "root");
                  
                  // String password=request.getParameter("password");
                    String username=request.getParameter("username");
                   con.setAutoCommit(false);
                   
                   String str1="delete from ROOT.REGISTER where username=?";
                 PreparedStatement pst=con.prepareStatement(str1);
                 //pst.setString(1,  password);
                  pst.setString(1, username);
                  pst.executeUpdate();
                  //out.print("dh");
                   out.println("<img src='Images/done.png' height=500 weight=100 style='margin-left:500px;'>");
                 
                 out.println("<br/>");
                 out.println("<a href='login.html' class='a1'>Admin Please Again Login</a>");
                 con.commit();
            }
            catch(Exception e)
                 {
                   
                 }
         
        %>
    </body>
</html>
