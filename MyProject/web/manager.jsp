<%-- 
    Document   : welcome
    Created on : 8 Mar 2025, 1:35:41 am
    Author     : admi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hệ Thống Quản Lý Nghỉ Phép</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #ff9a9e, #fad0c4);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            flex-direction: column;
        }
        .container {
            background: rgba(255, 255, 255, 0.95);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
            width: 600px;
            text-align: center;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
            font-size: 26px;
            font-weight: 700;
        }
        .menu {
            display: flex;
            justify-content: space-around;
            margin: 20px 0;
        }
        .btn {
            flex: 1;
            padding: 14px 20px;
            margin: 0 10px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
            color: white;
            transition: 0.3s;
        }
        .btn-primary { background: #ff7e5f; }
        .btn-primary:hover { background: #e86c4f; }
        .btn-secondary { background: #6a11cb; }
        .btn-secondary:hover { background: #5209a3; }
        .btn-approve { background: #11998e; }
        .btn-approve:hover { background: #0e7b6c; }
        .view-requests {
            display: inline-block;
            margin-top: 20px;
            padding: 14px 20px;
            background: #f76b1c;
            color: white;
            border-radius: 10px;
            text-decoration: none;
            font-size: 16px;
            font-weight: bold;
            transition: 0.3s;
        }
        .view-requests:hover {
            background: #d65a14;
        }
    </style>
    <script>
        function logout() {
            window.location.href = 'login.jsp';
        }
    </script>
</head>
<body>
    <div class="container">
        <button class="btn btn-secondary" style="position: absolute; top: 20px; right: 20px;" onclick="logout()">Logout</button>
        <h2>Hệ Thống Quản Lý Nghỉ Phép</h2>
        <div class="menu">
            <button class="btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/create.jsp'">Tạo Đơn</button>
            <button class="btn btn-secondary" onclick="window.location.href = '${pageContext.request.contextPath}/RequestList'">Xem Đơn</button>
        </div>
        <a href="Requestservlet" class="view-requests">Xem Đơn Cấp Dưới</a>
    </div>
</body>
</html>
