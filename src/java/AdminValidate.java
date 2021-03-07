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
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author girish_nai
 */
public class AdminValidate extends HttpServlet {
// static boolean status=false;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
              
            //try{
              //  Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/HttpSession", "girish", "girish123");
                //PreparedStatement ps = con.prepareStatement("select * from GIRISH.HTTPSESSION where uname=? and pword=?");
                
                String username=request.getParameter("username");
                String password=request.getParameter("password");
                
                //ps.setString(1,username);
                //ps.setString(2, password);
                //ResultSet rs=ps.executeQuery();
                //status=rs.next();
                if(AdminLogin.validate(username, password)) //&& (username.equals(username)))
                  {
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        RequestDispatcher rd = request.getRequestDispatcher("AdminWelcome");
                        rd.forward(request, response);
                   }
                else
                  {
                     out.println("<font color='red'><b>invalid password</b></font>");
                     RequestDispatcher rd=request.getRequestDispatcher("admin-login.html");
                     rd.include(request, response);
                  }
          //     }
        //    catch(Exception e){}
            
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
