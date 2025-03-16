<%-- 
    Document   : approve
    Created on : 16 Mar 2025, 11:11:46 pm
    Author     : admi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Xét Duyệt Đơn</title>
</head>
<body>
    <h3>Xét Duyệt Đơn</h3>
    <table border="1">
        <tr>
            <th>Người Duyệt</th><th>Người Tạo</th><th>Từ Ngày</th><th>Đến Ngày</th><th>Lý Do</th><th>Action</th>
        </tr>
        <% 
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LeaveManagement", "sa", "yourpassword");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT approvedBy, createdBy, fromDate, toDate, reason FROM LeaveRequests WHERE status = 'Pending'");
                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("approvedBy") %></td>
            <td><%= rs.getString("createdBy") %></td>
            <td><%= rs.getDate("fromDate") %></td>
            <td><%= rs.getDate("toDate") %></td>
            <td><%= rs.getString("reason") %></td>
            <td>
                <button>Reject</button>
                <button>Approve</button>
            </td>
        </tr>
        <% 
                }
                conn.close();
            } catch (Exception e) {
                out.println("Lỗi: " + e.getMessage());
            }
        %>
    </table>
    <a href="welcome.jsp">Quay Lại</a>
</body>
</html>
