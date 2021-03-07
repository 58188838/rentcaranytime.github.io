<%-- 
    Document   : bookcar
    Created on : Sep 28, 2020, 5:21:03 PM
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
                   String cname=request.getParameter("carname");
                   String cmodel=request.getParameter("carmodel");
                   String date=request.getParameter("date");
                   String dname=request.getParameter("documentname");
                   String addhar=request.getParameter("addharno");
                   String phoneno=request.getParameter("phoneno");
                   con.setAutoCommit(false);
                  
                 String str="insert into ROOT.BOOKCAR (carname,modelno,issuedate,documentname,addharno,phoneno) values (?,?,?,?,?,?)";
                 PreparedStatement pst=con.prepareStatement(str);
                  pst.setString(1, cname);
                  pst.setString(2, cmodel);
                  pst.setString(3, date);
                  pst.setString(4, dname);
                  pst.setString(5, addhar);
                  pst.setString(6, phoneno);
                   pst.executeUpdate();
                 
                 out.println("<img src='Images/done.png' height=500 weight=100 style='margin-left:500px;'>");
                 
                 out.println("<br/>");
                 out.println("<a href='http://localhost:8080/CarRent/Validate' class='a1'>BACK TO HOME PAGE</a>");
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
