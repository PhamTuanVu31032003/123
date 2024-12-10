<%-- 
    Document   : Timkiem
    Created on : Dec 8, 2024, 6:42:42 PM
    Author     : thang
--%>

<%@page import="java.util.ArrayList"%>
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
        <form action="TimServlet" method="POST">
            <div>
                <input type="number" name="timma" placeholder="Nhap vao ma can bo"/>
                <button type="submit">Tìm kiếm</button>
            </div>
        </form>
        <hr>
        <div>
            <%
                List<Canbo> dscb = (List<Canbo>) session.getAttribute("dscb");
                if (dscb == null || dscb.isEmpty()) {
            %>
            <p style="color: blue;"</strong>Không có cán bộ tương ứng.</p>
            <%
                } else {
            %>
                <table>
                    <thead>
                        <tr>
                            <th>Mã cán bộ</th>
                            <th>Họ tên</th>
                            <th>Giới tính</th>
                            <th>Lương</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Canbo canbo : dscb) {
                        %>
                        <tr>
                            <td><%= canbo.getMacb() %></td>
                            <td><%= canbo.getHoten() %></td>
                            <td><%= canbo.getGioitinh() %></td>
                            <td><%= canbo.getLuong() %></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            <%
                }
            %>
        </div>
    </body>
</html>
