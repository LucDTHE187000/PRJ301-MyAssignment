<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Danh Sách Đơn</title>
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                background: linear-gradient(135deg, #667eea, #764ba2);
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
                flex-direction: column;
            }
            .container {
                background: rgba(255, 255, 255, 0.9);
                padding: 25px;
                border-radius: 15px;
                box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
                width: 600px;
                text-align: center;
            }
            h2 {
                color: #333;
                margin-bottom: 20px;
                font-size: 24px;
                font-weight: 600;
            }
            .button-group {
                display: flex;
                justify-content: space-between;
                margin: 20px 0;
            }
            .btn {
                flex: 1;
                padding: 12px;
                margin: 0 5px;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                font-size: 14px;
                font-weight: bold;
                color: white;
                transition: 0.3s;
            }
            .btn-primary {
                background: #4facfe;
            }
            .btn-primary:hover {
                background: #3b8bfe;
            }
            .btn-secondary {
                background: #ff7e5f;
            }
            .btn-secondary:hover {
                background: #e86c4f;
            }
            .content {
                display: none;
                background: #f1f1f1;
                padding: 15px;
                margin: 15px 0;
                border-radius: 10px;
                text-align: left;
                font-size: 14px;
                font-weight: 500;
                color: #444;
            }
            .form-group {
                margin-bottom: 10px;
            }
            label {
                font-weight: bold;
            }
            input, textarea {
                width: 100%;
                padding: 8px;
                margin-top: 5px;
                border-radius: 5px;
                border: 1px solid #ccc;
            }
            .btn-group {
                display: flex;
                justify-content: space-between;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 10px;
            }
            th, td {
                border: 1px solid #ccc;
                padding: 8px;
                text-align: center;
            }
            th {
                background-color: #4facfe;
                color: white;
            }
        </style>
    </head>
    <body>
        <div id="list-requests" class="content" style="${not empty listRequests ? 'display:block;' : 'display:none;'}">
            <h3>Danh Sách Đơn</h3>
            <table>
                <tr>
                    <th>Lý Do</th>
                    <th>Đến Ngày</th>
                    <th>Từ Ngày</th>
                    <th>Trạng Thái</th>
                    <th>Người Tạo</th>
                    <th>Action</th>
                </tr>
                <!-- Duyệt qua listRequests đã được setAttribute -->
                <c:forEach var="req" items="${listRequests}">
                    <tr>
                        <td>${req.reason}</td>
                        <td><fmt:formatDate value="${req.getDateFrom()}" pattern="dd/MM/yyyy"/></td>
                    <td><fmt:formatDate value="${req.getDateTo()}" pattern="dd/MM/yyyy"/></td>
                    <td>${req.getStatus()}</td>
                    <td>${req.getEmployeeId()}</td>
                    <td>
                        <button class="btn btn-primary" onclick="window.location.href='http://localhost:8080/MyProject/List?action=List&requestId=${req.id}&employeeId=${req.employeeId}'">Xem</button>
                    </td>
                    
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>