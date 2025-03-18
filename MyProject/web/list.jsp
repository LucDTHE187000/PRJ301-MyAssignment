<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Đơn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #6b5b95, #8e44ad);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 80%;
        }

        h2 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .btn {
            display: inline-block;
            padding: 5px 10px;
            color: white;
            border-radius: 5px;
            text-decoration: none;
            margin: 2px;
        }

        .btn-view {
            background-color: #3498db;
        }

        .btn-update {
            background-color: #2ecc71;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Danh Sách Đơn</h2>
        <table>
            <tr>
                <th>Lý Do</th>
                <th>Từ Ngày</th>
                <th>Đến Ngày</th>
                <th>Trạng Thái</th>
                <th>Người Tạo</th>
                <th>Action</th>
            </tr>
            <c:forEach var="req" items="${requestList}">
                <tr>
                    <td>${req.getReason()}</td>
                    <td>${req.getDateFrom()}</td>
                    <td>${req.getDateTo()}</td>
                    <td>${req.getStatus()}</td>
                    <td>${req.getDateCreate()}</td>
                    <td>
                        <a href="xem.jsp?id=${req.getId()}" class="btn btn-view">Xem</a>
                        <a href="delete.jsp?id=${req.getId()}" class="btn btn-update">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty requestList}">
                <tr>
                    <td colspan="6">Không có đơn nào</td>
                </tr>
            </c:if>
        </table>
    </div>
</body>
</html>