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
public class XoaServlet extends HttpServlet {

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
            out.println("<title>Servlet XoaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet XoaServlet at " + request.getContextPath() + "</h1>");
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
            // Chuyển yêu cầu từ GET sang POST
            doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy mã cán bộ từ URL
        String macbStr = request.getParameter("macb");
        if (macbStr != null) {
            try {
                int macb = Integer.parseInt(macbStr); // Chuyển mã cán bộ sang kiểu int
                KNCSDL kncsdl = new KNCSDL();        // Kết nối cơ sở dữ liệu
                kncsdl.Xoa(macb);                   // Gọi hàm xoá

                // Sau khi xoá, chuyển hướng về trang "Display.jsp"
                response.sendRedirect("DisplayServlet");
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                // Xử lý lỗi (hiển thị thông báo lỗi hoặc ghi log)
                e.printStackTrace();
                response.getWriter().println("Lỗi xảy ra khi xoá cán bộ: " + e.getMessage());
            }
        } else {
            response.getWriter().println("Mã cán bộ không hợp lệ.");
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
