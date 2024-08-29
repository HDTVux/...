<%-- 
    Document   : login
    Created on : 13 thg 6, 2024, 10:11:37
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="GiaoDienDangNhap.css"/>
</head>
<body>
    <img src="https://i.pinimg.com/564x/a6/92/42/a6924236d995d9f583158c860909b137.jpg" alt="alt"/>
    <div class="container">
        <h2>Đăng nhập</h2>
        <form action="login" method="post">
            <div class="tieude">Username: <input type="text" name="username"></div>
            <div class="tieude">Password: <input type="password" name="password"></div>
            <div class="message">${mess}</div>
            <input type="submit" value="Login" />
        </form>
    </div>
</body>
</html>
