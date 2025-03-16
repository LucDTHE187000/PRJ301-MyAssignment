<%-- 
    Document   : Accept
    Created on : 16 Mar 2025, 4:53:02 pm
    Author     : admi
--%>

<%@page import="java.util.List"%>
<%@page import="model.Request"%>
<%@page import="dal.RequestDAO"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Account admin = (Account) session.getAttribute("account");
    if (admin == null || admin.getRoleId() != 1) {
        response.sendRedirect("login.jsp");
        return;
    }
    
    RequestDAO requestDAO = new RequestDAO();
    List<Request> InprogressRequests = requestDAO.getInprogressRequestsFromManagers();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xét Duyệt Đơn</title>
    <script>
        function processRequest(requestId, action) {
            fetch('ProcessRequest', {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: `id=${requestId}&action=${action}`
            }).then(response => response.text())
              .then(data => {
                  alert(data);
                  location.reload();
              });
        }
    </script>
</head>
<body>
    <h2>Danh sách đơn cần xét duyệt</h2>
    <table border="1">
        <tr>
            <th>Người tạo</th>
            <th>Ngày bắt đầu</th>
            <th>Ngày kết thúc</th>
            <th>Lý do</th>
            <th>Hành động</th>
        </tr>
        <% for (Request req : InprogressRequests) { %>
        <tr>
            <td><%= req.getEmployeeId() %></td>
            <td><%= req.getDateFrom() %></td>
            <td><%= req.getDateTo() %></td>
            <td><%= req.getReason() %></td>
            <td>
                <button onclick="processRequest(<%= req.getId() %>, 'approve')">Duyệt</button>
                <button onclick="processRequest(<%= req.getId() %>, 'reject')">Từ chối</button>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>