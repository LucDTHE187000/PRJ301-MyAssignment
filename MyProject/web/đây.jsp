<%-- 
    Document   : đây
    Created on : 18 Mar 2025, 8:25:21 pm
    Author     : admi
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh Sách Đơn</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
    <h2>Danh Sách Đơn Của Bạn</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Ngày Tạo</th>
            <th>Từ Ngày</th>
            <th>Đến Ngày</th>
            <th>Lý Do</th>
            <th>Trạng Thái</th>
            <th>Hành Động</th>
        </tr>
        <c:forEach var="req" items="${listRequests}">
            <tr>
                <td>${req.id}</td>
                <td>${req.dateCreate}</td>
                <td>${req.dateFrom}</td>
                <td>${req.dateTo}</td>
                <td>${req.reason}</td>
                <td>${req.status}</td>
                <td>
                    <a href="xem.jsp?id=${req.id}">Xem</a>
                    <a href="update.jsp?id=${req.id}">Cập Nhật</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
