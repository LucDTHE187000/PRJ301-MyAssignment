<%-- 
    Document   : admin.jsp
    Created on : 15 Mar 2025, 4:06:29 pm
    Author     : admi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Màn hình Quản Lý</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background: linear-gradient(135deg, #74ebd5, #acb6e5);
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .container {
                text-align: center;
                background: white;
                padding: 30px;
                border-radius: 15px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            }
            .button-container {
                display: flex;
                justify-content: center;
                gap: 20px;
            }
            .custom-button {
                width: 200px;
                padding: 15px;
                border: none;
                border-radius: 10px;
                font-size: 16px;
                cursor: pointer;
                transition: 0.3s;
            }
            .custom-button:nth-child(1) {
                background: #ff7eb3;
                color: white;
            }
            .custom-button:nth-child(2) {
                background: #67d7cc;
                color: white;
            }
            .custom-button:hover {
                transform: scale(1.05);
                opacity: 0.9;
            }
            .logout-btn {
                position: absolute;
                top: 20px;
                right: 20px;
                background: #ff4d4d;
                color: white;
                padding: 10px 15px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: 0.3s;
            }
            .logout-btn:hover {
                background: #cc0000;
            }
        </style>
    </head>
    <body>
        <button class="logout-btn" onclick="logout()">Logout</button>
        <script>
            function logout() {
                window.location.href = 'login.jsp';
            }
        </script>
        <div class="container">
            <div class="button-container">
                <button class="custom-button" onclick="window.location.href = 'Accept.jsp'">Xét Duyệt Đơn ➝</button>
                <button class="custom-button" onclick="window.location.href = 'Agenda.jsp'">View Agenda ➝</button>
            </div>
        </div>
    </body>
</html>
