/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Canbo;
import Model.KNCSDL;
import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thang
 */
public class SuaServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SuaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SuaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        int macb = Integer.parseInt(request.getParameter("macb"));
        if (macb >0) {
            try {
                KNCSDL kn = new KNCSDL();
                List<Canbo> dscb = new ArrayList<>();
                ResultSet rs = kn.Getmacb(macb);
                while (rs.next()) {
                    String hoten = rs.getString("Hoten");
                    String gt = rs.getString("Gioitinh");
                    double luong = rs.getDouble("Luong");

                    Canbo cb = new Canbo(macb, hoten, gt, luong);
                    HttpSession ss = request.getSession();
                    ss.setAttribute("canbo", cb);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SuaServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SuaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.getRequestDispatcher("/Suacb.jsp").forward(request, response);
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
        int macb = Integer.parseInt(request.getParameter("Macb"));
        String hoten = request.getParameter("Hoten");
        String gt = request.getParameter("Gioitinh");
        double luong = Double.parseDouble(request.getParameter("Luong"));
        try {
            KNCSDL kn = new KNCSDL();
            List<Canbo> dscb = new ArrayList<>();
            kn.Sua(macb, hoten, gt, luong);
            response.sendRedirect("DisplayServlet");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SuaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
