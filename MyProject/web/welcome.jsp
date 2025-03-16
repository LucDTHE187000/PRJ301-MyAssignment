<%-- 
    Document   : welcome
    Created on : 16 Mar 2025, 11:09:11 pm
    Author     : admi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Hệ Thống Quản Lý Nghỉ Phép</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #ff7e5f, #feb47b);
            text-align: center;
            margin: 0;
            padding: 0;
            color: white;
        }
        .container {
            margin-top: 100px;
        }
        h2 {
            font-size: 28px;
            margin-bottom: 20px;
        }
        .menu {
            display: flex;
            justify-content: center;
            gap: 30px;
            margin-bottom: 30px;
        }
        .btn {
            padding: 14px 24px;
            text-decoration: none;
            font-size: 18px;
            font-weight: bold;
            color: white;
            border-radius: 10px;
            transition: 0.3s;
            border: none;
            background: rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(5px);
        }
        .btn:hover {
            background: rgba(255, 255, 255, 0.4);
        }
        .view-requests {
            display: inline-block;
            margin-top: 20px;
            padding: 14px 24px;
            background: rgba(255, 255, 255, 0.3);
            color: white;
            border-radius: 10px;
            text-decoration: none;
            font-size: 18px;
            font-weight: bold;
            transition: 0.3s;
        }
        .view-requests:hover {
            background: rgba(255, 255, 255, 0.5);
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Hệ Thống Quản Lý Nghỉ Phép</h2>
        <div class="menu">
            <a href="create.jsp" class="btn">Tạo Đơn</a>
            <a href="list.jsp" class="btn">Xem Đơn</a>
            <a href="approve.jsp" class="btn">Xét Duyệt Đơn Cấp Dưới</a>
        </div>
        <a href="RequestList" class="view-requests">Xem Đơn Đã Gửi</a>
    </div>
</body>
</html>
