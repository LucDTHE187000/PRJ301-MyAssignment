<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            .update {
                background: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
                border-radius: 5px;
            }
            .delete {
                background: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
                border-radius: 5px;
            }
            .hidden {
                display: none;
            }
        </style>
        <script>
            function showEditForm() {
                document.getElementById("viewTable").classList.add("hidden");
                document.getElementById("editForm").classList.remove("hidden");
                document.getElementById("buttons").classList.add("hidden"); // Ẩn các nút ban đầu
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h2>Chi Tiết Đơn Nghỉ Phép</h2>

            <!-- Bảng hiển thị thông tin -->
            <table id="viewTable">
                <tr>
                    <th>ID</th>
                    <td>${requestDetail.id}</td>
                </tr>
                <tr>
                    <th>Lý Do</th>
                    <td>${requestDetail.reason}</td>
                </tr>
                <tr>
                    <th>Đến Ngày</th>
                    <td>${requestDetail.dateFrom}</td>
                </tr>
                <tr>
                    <th>Từ Ngày</th>
                    <td>${requestDetail.dateTo}</td>
                </tr>
                <tr>
                    <th>Trạng Thái</th>
                    <td>${requestDetail.status}</td>
                </tr>
                <tr>
                    <th>Ngày Tạo</th>
                    <td>${requestDetail.dateCreate}</td>
                </tr>
            </table>

            <!-- Form chỉnh sửa (mặc định ẩn) -->
            <form id="editForm" class="hidden" action="Update" method="post">
                <input type="hidden" name="id" value="${requestDetail.id}">
                <table>
                    <tr>
                        <th>Lý Do</th>
                        <td><input type="text" name="reason" value="${requestDetail.reason}" required></td>
                    </tr>
                    <tr>
                        <th>Đến Ngày</th>
                        <td><input type="date" name="dateFrom" value="${requestDetail.dateFrom}" required></td>
                    </tr>
                    <tr>
                        <th>Từ Ngày</th>
                        <td><input type="date" name="dateTo" value="${requestDetail.dateTo}" required></td>
                    </tr>
                </table>
                <div class="button-group">
                    <button type="submit" class="update">Cập Nhật</button>
                </div>
            </form>

            <div id="buttons" class="button-group">
                <button class="update" onclick="showEditForm()">Update</button>
                <form action="Delete" method="post" style="display: inline;" onsubmit="return confirm('Bạn có chắc chắn muốn xóa đơn này?');">
                    <input type="hidden" name="id" value="${requestDetail.id}">
                    <button type="submit" class="delete">Delete</button>
                </form>
            </div>

        </div>
    </body>
</html>
