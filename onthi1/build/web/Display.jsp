<%-- 
    Document   : Display
    Created on : Dec 8, 2024, 2:15:16 PM
    Author     : thang
--%>

<%@page import="Model.Canbo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" cellspacing="0" cellpadding="5">
            <thead>
                <tr>
                    <th>Mã cán bộ</th>
                    <th>Họ tên</th>
                    <th>Giới tính</th>
                    <th>Lương</th>
                    <th colspan="2">Lựa chọn</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Canbo> dscb = (List<Canbo>) session.getAttribute("dscb");
                    for (Canbo canbo : dscb) {
                        out.print("<tr>");
                        out.print("<th>" + canbo.getMacb() + "</th>");
                        out.print("<th>" + canbo.getHoten() + "</th>");
                        out.print("<th>" + canbo.getGioitinh() + "</th>");
                        out.print("<th>" + canbo.getLuong() + "</th>");
                        out.print("<td><a href='SuaServlet?macb=" + canbo.getMacb() + "'>Sửa</a></td>");
                        out.print("<td><a href='XoaServlet?macb=" + canbo.getMacb() + "'>Xoá</a></td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table>
       <br/>
        <button onclick="window.location.href = 'Themcb.jsp';">Thêm Player</button>
        <button onclick="window.location.href = 'Timkiem.jsp';">Tìm Player</button>
    </body>
</html>
