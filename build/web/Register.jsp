<%-- 
    Document   : Register
    Created on : Sep 22, 2020, 11:54:21 AM
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
        <style>
            .a1{
                  color: white;
                  text-decoration: none;
                  margin-left: 600px;
                  font-size: 50px;
               }
        </style>
    </head>
    <body background='Images/pic1.jpg'>
        <%
           
            try
               {
                  
                  Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Carrent", "root", "root");
                   String fname=request.getParameter("firstname");
                   String lname=request.getParameter("lastname");
                   String address=request.getParameter("address");
                   String username=request.getParameter("username");
                   String pass=request.getParameter("password");
                   String phoneno=request.getParameter("phoneno");
                   con.setAutoCommit(false);
                  
                 String str="insert into   ROOT.REGISTER (firstname,lastname,address,username,password,phoneno) values (?,?,?,?,?,?)";
                 PreparedStatement pst=con.prepareStatement(str);
                  pst.setString(1, fname);
                  pst.setString(2, lname);
                  pst.setString(3, address);
                  pst.setString(4, username);
                  pst.setString(5, pass);
                  pst.setString(6, phoneno);
                   pst.executeUpdate();
                 
                 out.println("<img src='Images/done.png' height=500 weight=100 style='margin-left:500px;'>");
                 
                 out.println("<br/>");
                 out.println("<a href='login.html' class='a1'>Login</a>");
                 con.commit();
               }
                catch(Exception e)
                 {
                   System.out.print(e);
                   e.printStackTrace();
                 }
        %>

    </body>
</html>
