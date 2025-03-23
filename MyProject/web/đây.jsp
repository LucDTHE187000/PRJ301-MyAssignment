<%-- 
    Document   : đây
    Created on : 18 Mar 2025, 8:25:21 pm
    Author     : admi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Requestform"%>
<%@page import="model.Account"%>
<%@page import="java.text.SimpleDateFormat"%>

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
        /* CSS cho nút */
        .approve-btn, .reject-btn {
            padding: 5px 10px;
            margin: 0 5px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            color: white;
            font-weight: bold;
        }
        .approve-btn {
            background-color: #28a745; /* Màu xanh cho nút Xét Duyệt */
        }
        .approve-btn:hover {
            background-color: #218838;
        }
        .reject-btn {
            background-color: #dc3545; /* Màu đỏ cho nút Từ Chối */
        }
        .reject-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>

<body>
    <div class="container">
        <h2>Danh Sách Đơn Của Nhân Viên</h2>
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <p style="color: <%= message.contains("thành công") ? "green" : "red" %>;"><%= message %></p>
        <% } %>
        <table>
            <tr>
                <th>ID</th>
                <th>Từ Ngày</th>
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
                <td><%= r.getDateFrom() %></td> <!-- DateFrom is "Từ Ngày" -->
                <td><%= r.getDateTo() %></td>   <!-- DateTo is "Đến Ngày" -->
                <td><%= r.getDateCreate() %></td>
                <td><%= r.getReason() %></td>
                <td><%= r.getStatus() %></td>
                <td><%= r.geteName() %></td>
                <td>
                    <% if ("Inprogress".equals(r.getStatus())) { %>
                        <form style="display:inline;" action="ApproveRequestServlet" method="post">
                            <input type="hidden" name="id" value="<%= r.getId() %>">
                            <input type="hidden" name="action" value="approve">
                            <button type="submit" class="approve-btn">Xét Duyệt</button>
                        </form>
                        <form style="display:inline;" action="ApproveRequestServlet" method="post">
                            <input type="hidden" name="id" value="<%= r.getId() %>">
                            <input type="hidden" name="action" value="reject">
                            <button type="submit" class="reject-btn">Từ Chối</button>
                        </form>
                    <% } else { %>
                        Đã xử lý
                    <% } %>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="8">Không có đơn nào.</td>
            </tr>
            <% } %>
        </table>
        <a href="welcome.jsp">Quay Lại</a>
    </div>
</body>
</html>