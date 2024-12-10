
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Đăng nhập</h1>
        <form action="LoginServlet" method="POST">
            <div>
                <label for="email">
                <input type="email" name="email" placeholder="Nhập email">
            </div>
            <div>
                <label for="pass">
                <input type="password" name="pass" placeholder="Nhập password">
            </div>
            <div>
                <button type="submit">Đăng nhập</button>
                <button type="reset">Làm mói</button>
            </div>
            <div>
               <%
                    Integer status = (Integer) session.getAttribute("status");
                    if (status != null) { 
                        if (status == 0) {
                            out.print("<p style='color:red;'>Sai tài khoản hoặc mật khẩu!!!</p>");
                        } else if (status == 1) {
                            out.print("<p style='color:green;'>Đăng nhập thành công!</p>");
                        }
                        session.removeAttribute("status"); // Xóa trạng thái sau khi hiển thị
                    }
                %>
            </div>
        </form>
    </body>
</html>
