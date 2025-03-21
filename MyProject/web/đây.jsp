<%-- 
    Document   : đây
    Created on : 18 Mar 2025, 8:25:21 pm
    Author     : admi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Requestform"%>
<%@page import="model.Account"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Đơn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 900px;
        }
        h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th {
            background-color: #007BFF;
            color: white;
            padding: 10px;
        }
        td {
            padding: 8px;
            background-color: #f9f9f9;
        }
        tr:nth-child(even) {
            background-color: #f1f1f1;
        }
        tr:hover {
            background-color: #ddd;
            transition: 0.3s;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Danh Sách Đơn Của Nhân Viên</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Từ Ngày </th>
                <th>Đến Ngày</th>
                <th>Ngày Tạo</th>
                <th>Lý Do</th>
                <th>Trạng Thái</th>
                <th>Nhân Viên</th>
                <th>Xét Duyệt</th>
            </tr>
            <%
                List<Requestform> requestList = (List<Requestform>) request.getAttribute("listemployee");
                if (requestList != null && !requestList.isEmpty()) {
                    for (Requestform r : requestList) {
            %>
            <tr>
                <td><%= r.getId() %></td>
                <td><%= r.getDateCreate() %></td>
                <td><%= r.getDateFrom() %></td>
                <td><%= r.getDateTo() %></td>
                <td><%= r.getReason() %></td>
                <td><%= r.getStatus() %></td>
                <td><%= r.geteName() %></td>
                <td> . </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="7">Không có đơn nào.</td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
