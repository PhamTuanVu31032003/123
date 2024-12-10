<%-- 
    Document   : Suacb
    Created on : Dec 8, 2024, 4:08:49 PM
    Author     : thang
--%>

<%@page import="Model.Canbo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
     Canbo canbo = (Canbo) session.getAttribute("canbo");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sửa Thông Tin Cán Bộ</h1>
        <form action="SuaServlet" method="POST">
            <input type="hidden" name="Macb" value="<%= canbo.getMacb()%>">
            <div>
                <label>Họ tên:</label>
                <input type="text" name="Hoten" value="<%= canbo.getHoten()%>">
            </div>
            <div>
                <label>Giới tính:</label>
                <input type="text" name="Gioitinh" value="<%= canbo.getGioitinh()%>">
            </div>
            <div>
                <label>Lương:</label>
                <input type="text" name="Luong" value="<%= canbo.getLuong()%>">
            </div>
            <div>
                <button type="submit">Cập Nhật</button>
                <a href="/Display.jsp">Quay Lại</a>
            </div>
        </form>
    </body>
</html>
