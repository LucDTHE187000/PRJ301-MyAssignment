<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Đơn Nghỉ Phép</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            color: white;
            text-align: center;
        }
        .container {
            width: 50%;
            margin: auto;
            background: white;
            color: black;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        td, th {
            padding: 10px;
            border: 1px solid black;
        }
        .button-group {
            margin-top: 20px;
        }
        .back, .update, .delete {
            display: inline-block;
            padding: 10px 20px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-right: 10px;
        }
        .back {
            background: #2575fc; 
        }
        .update {
            background: #4CAF50;
        }
        .delete {
            background: #f44336; 
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Chi Tiết Đơn Nghỉ Phép</h2>
        <table>
            <tr>
                <th>ID</th>
                <td>${requestDetail.getId()}</td>
            </tr>
            <tr>
                <th>Lý Do</th>
                <td>${requestDetail.getReason()}</td>
            </tr>
            <tr>
                <th>Đến Ngày</th>
                <td>${requestDetail.getDateFrom()}</td>
            </tr>
            <tr>
                <th>Từ Ngày</th>
                <td>${requestDetail.getDateTo()}</td>
            </tr>
            <tr>
                <th>Trạng Thái</th>
                <td>${requestDetail.getStatus()}</td>
            </tr>
            <tr>
                <th>Ngày Tạo</th>
                <td>${requestDetail.getDateCreate()}</td>
            </tr>
        </table>
        <div class="button-group">
            <a href="http://localhost:8080/MyProject/RequestList" class="back">Quay Lại</a>
            <a href="UpdateRequest?requestId=${requestDetail.getId()}" class="update">Update</a>
            
            <a href="DeleteRequest?requestId=${requestDetail.getId()}" class="delete" onclick="return confirm('Bạn có chắc chắn muốn xóa đơn này?');">Delete</a>
        </div>
    </div>
</body>
</html>