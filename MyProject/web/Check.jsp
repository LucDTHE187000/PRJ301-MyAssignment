<%-- 
    Document   : Check
    Created on : 16 Mar 2025, 6:32:14 pm
    Author     : admi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Đơn Nghỉ Phép</title>
    <style>
        body { font-family: Arial, sans-serif; background: linear-gradient(to right, #6a11cb, #2575fc); color: white; text-align: center; }
        .container { width: 50%; margin: auto; background: white; color: black; padding: 20px; border-radius: 10px; box-shadow: 0px 0px 10px gray; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        td, th { padding: 10px; border: 1px solid black; }
        .back { margin-top: 20px; display: inline-block; padding: 10px 20px; background: #2575fc; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Chi Tiết Đơn Nghỉ Phép</h2>
        <table>
            <tr><th>Lý Do</th><td>${requestDetail.reason}</td></tr>
            <tr><th>Từ Ngày</th><td>${requestDetail.startDate}</td></tr>
            <tr><th>Đến Ngày</th><td>${requestDetail.endDate}</td></tr>
            <tr><th>Trạng Thái</th><td>${requestDetail.status}</td></tr>
            <tr><th>Người Tạo</th><td>${requestDetail.creatorId}</td></tr>
        </table>
        <a href="Request?action=listRequests" class="back">Quay Lại</a>
    </div>
</body>
</html>
