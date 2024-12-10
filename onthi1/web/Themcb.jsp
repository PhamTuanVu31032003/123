<%-- 
    Document   : Themcb
    Created on : Dec 8, 2024, 3:34:09 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ThemServlet" method="POST">
            <div>
                <label for="Hoten">
                <input type="text" name="Hoten" placeholder="Nhap ho ten">
            </div>
             <div>
                <label for="Gioitinh">
                <input type="text" name="Gioitinh" placeholder="Nhap gioi tinh">
            </div>
             <div>
                <label for="Luong">
                <input type="text" name="Luong" placeholder="Nhap luong">
            </div>
             <div>
                 <button type="submit" >Thêm</button>
                 <a href="Display.jsp">Quay lại</a>
            </div>
        </form>
    </body>
</html>
