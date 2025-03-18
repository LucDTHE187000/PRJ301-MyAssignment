<%@ page import="dal.RequestDAO, model.Request" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String idParam = request.getParameter("id");
    if (idParam == null || idParam.trim().isEmpty()) {
%>
    <p style="color:red;">Lỗi: Không tìm thấy ID đơn nghỉ phép.</p>
    <a href="employee1.jsp">Quay lại</a>
<%
        return;
    }
    
    int requestId = Integer.parseInt(idParam);
    RequestDAO requestDAO = new RequestDAO();
    Request requestDetail = requestDAO.getRequestById(requestId);
    
    if (requestDetail == null) {
%>
    <p style="color:red;">Lỗi: Đơn nghỉ phép không tồn tại.</p>
    <a href="employee1.jsp">Quay lại</a>
<%
        return;
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết đơn</title>
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
            background: #e0ecff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }
        h2 {
            margin-bottom: 10px;
            color: #333;
        }
        p {
            text-align: left;
            font-size: 16px;
        }
        input[type="text"], input[type="date"] {
            width: 90%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .btn {
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin: 5px;
            width: 45%;
        }
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        .btn-danger {
            background-color: #dc3545;
            color: white;
        }
        .btn:hover {
            opacity: 0.8;
        }
        a {
            display: block;
            margin-top: 10px;
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Chi tiết đơn nghỉ phép</h2>
        <form action="updateRequest.jsp" method="post">
            <input type="hidden" name="id" value="<%= requestDetail.getId() %>">
            <p>Từ ngày: <input type="date" name="dateFrom" value="<%= requestDetail.getDateFrom() %>"></p>
            <p>Đến ngày: <input type="date" name="dateTo" value="<%= requestDetail.getDateTo() %>"></p>
            <p>Lý do: <input type="text" name="reason" value="<%= requestDetail.getReason() %>"></p>
            <p>Trạng thái: <input type="text" name="status" value="<%= requestDetail.getStatus() %>"></p>
            <button type="submit" class="btn btn-primary">Cập nhật</button>
        </form>
        <form action="approve.jsp" method="post">
            <input type="hidden" name="id" value="<%= requestDetail.getId() %>">
            <button type="submit" name="action" value="approve" class="btn btn-primary">Approve</button>
            <button type="submit" name="action" value="reject" class="btn btn-danger">Reject</button>
        </form>
        <a href="delete.jsp">Quay lại</a>
    </div>
</body>
</html>

