/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author girish_nai
 */
public class changePassword extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //String currentpassword=request.getParameter("password");
           // String newpassword=request.getParameter("new");
            
             try
            {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Carrent", "root", "root");
                   
                   String newpassword=request.getParameter("password");
                   String username=request.getParameter("username");
                   con.setAutoCommit(false);
                   
                   String str="update ROOT.REGISTER set password='?' where username='?'";
                 PreparedStatement pst=con.prepareStatement(str);
                 pst.setString(1, newpassword);
                  pst.setString(2, username);
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
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
