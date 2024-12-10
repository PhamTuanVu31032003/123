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
public class TimServlet extends HttpServlet {

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
            out.println("<title>Servlet TimServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Timkiem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int timma = Integer.parseInt(request.getParameter("timma"));
        List<Canbo> dscb = new ArrayList<>();

        try {
            KNCSDL kn = new KNCSDL();
            ResultSet rs = kn.Getmacb(timma);
            while (rs.next()) {
                String hoten = rs.getString("Hoten");
                String gt = rs.getString("Gioitinh");
                double luong = rs.getDouble("Luong");
                Canbo cb = new Canbo(timma, hoten, gt, luong);
                dscb.add(cb);
            }
            kn.close(); // Đảm bảo đóng kết nối sau khi sử dụng

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TimServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Gán danh sách cán bộ vào session
        HttpSession ss = request.getSession();
        ss.setAttribute("dscb", dscb);
        // Chuyển hướng lại trang JSP hiển thị kết quả
        response.sendRedirect("Timkiem.jsp");
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
