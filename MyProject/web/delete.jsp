<%-- 
    Document   : update
    Created on : 17 Mar 2025, 9:35:01 am
    Author     : admi
--%>


<%@ page import="dal.RequestDAO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String idParam = request.getParameter("id");
    String message = null;
    
    if (idParam != null) {
        int requestId = Integer.parseInt(idParam);
        RequestDAO requestDAO = new RequestDAO();
        
        boolean isDeleted = requestDAO.deleteRequest(requestId);
        if (isDeleted) {
            message = "Xóa đơn thành công!";
        } else {
            message = "Xóa đơn thất bại!";
        }
    }
%>

<html>
<head>
    <title>Xóa Đơn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        button {
            background-color: red;
            color: white;
            border: none;
            cursor: pointer;
            padding: 8px;
            border-radius: 5px;
            margin-top: 10px;
        }
        button:hover {
            background-color: darkred;
        }
        #message {
            color: green;
            margin-top: 10px;
            opacity: 1;
            transition: opacity 1s ease-in-out;
        }
    </style>
    <script>
        function confirmDelete() {
            return confirm("Bạn có chắc chắn muốn xóa không?");
        }
        setTimeout(() => {
            const msg = document.getElementById("message");
            if (msg) msg.style.opacity = "0";
        }, 3000);
    </script>
</head>
<body>
    <div class="container">
        <h2>Xóa Đơn Nghỉ Phép</h2>
        <form method="post" onsubmit="return confirmDelete()">
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
            <button type="submit">Xóa</button>
        </form>

        <% if (message != null) { %>
            <p id="message"><%= message %></p>
            <script>
                setTimeout(() => {
                    window.location.href = "RequestList"; // Chuyển về danh sách đơn
                }, 2000);
            </script>
        <% } %>
    </div>
</body>
</html>