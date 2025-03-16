<%-- 
    Document   : list
    Created on : 16 Mar 2025, 10:50:02 pm
    Author     : admi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Request" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Đơn Đã Gửi</title>
</head>

<body>
    <h3>Danh Sách Đơn Đã Gửi</h3>
    
    <% 
        List<Request> requestList = (List<Request>) request.getAttribute("requestList");
        if (requestList == null || requestList.isEmpty()) { 
    %>
        <p>Không có đơn nào.</p>
    <% } else { %>
        <table border="1">
            <tr>
                <th>Lý Do</th><th>Từ Ngày</th><th>Đến Ngày</th><th>Trạng Thái</th><th>Ngày Tạo</th>
            </tr>
            <% for (Request req : requestList) { %>
            <tr>
                <td><%= req.getReason() %></td>
                <td><%= req.getDateFrom() %></td>
                <td><%= req.getDateTo() %></td>
                <td><%= req.getStatus() %></td>
                <td><%= req.getDateCreate() %></td>
            </tr>
            <% } %>
        </table>
    <% } %>

    <a href="welcome.jsp">Quay Lại</a>
</body>
</html>

