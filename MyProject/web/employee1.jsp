<%-- 
    Document   : welcome
    Created on : 11 Mar 2025, 8:56:12 pm
    Author     : admi
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hệ Thống Quản Lý Nghỉ Phép</title>
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
        <script>
            function showSection(sectionId) {
                document.getElementById('create-form').style.display = 'none';
                document.getElementById('list-requests').style.display = 'none';
                document.getElementById('approval-section').style.display = 'none';
                document.getElementById(sectionId).style.display = 'block';
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div style="position: absolute; top: 20px; right: 20px;">
                <button class="btn btn-secondary" onclick="logout()">Logout</button>
            </div>
            <script>
                function logout() {
                    window.location.href = 'login.jsp'; // Điều hướng đến trang logout
                }
            </script>

            <h2>Hệ Thống Quản Lý Nghỉ Phép</h2>
            <div class="button-group">
                <button class="btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/create.jsp'">Tạo Đơn</button>
                <button class="btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/RequestList'"> Xem Danh Sách Đơn </button>

            </div>
            

            <!-- Thông báo -->
            <div id="message" style="display: none; padding: 10px; margin-top: 10px; border-radius: 5px;"></div>

            <script>
                function showDetails(id, reason, dateFrom, dateTo, status, employeeId) {
                    document.getElementById('detail-section').style.display = 'block';
                    document.getElementById('detail-id').value = id;
                    document.getElementById('detail-reason').value = reason;
                    document.getElementById('detail-from').value = dateFrom;
                    document.getElementById('detail-to').value = dateTo;
                    document.getElementById('detail-status').value = status;
                    document.getElementById('detail-employee').value = employeeId;

                    document.getElementById('edit-btn').style.display = 'inline-block';
                    document.getElementById('save-btn').style.display = 'none';

                    disableInputs();
                }

                function enableEdit() {
                    document.getElementById('detail-reason').disabled = false;
                    document.getElementById('detail-from').disabled = false;
                    document.getElementById('detail-to').disabled = false;
                    document.getElementById('edit-btn').style.display = 'none';
                    document.getElementById('save-btn').style.display = 'inline-block';
                }

                function disableInputs() {
                    document.getElementById('detail-reason').disabled = true;
                    document.getElementById('detail-from').disabled = true;
                    document.getElementById('detail-to').disabled = true;
                }

                document.getElementById("update-form").onsubmit = function (e) {
                    e.preventDefault();

                    fetch("Request", {
                        method: "POST",
                        body: new FormData(document.getElementById("update-form"))
                    })
                            .then(response => response.text())
                            .then(data => {
                                showMessage("Cập nhật thành công!", "green");
                                disableInputs();
                                document.getElementById('edit-btn').style.display = 'inline-block';
                                document.getElementById('save-btn').style.display = 'none';
                            })
                            .catch(error => showMessage("Cập nhật thất bại!", "red"));
                };

                function showMessage(msg, color) {
                    let messageBox = document.getElementById("message");
                    messageBox.innerText = msg;
                    messageBox.style.display = "block";
                    messageBox.style.backgroundColor = color;
                    messageBox.style.color = "white";

                    setTimeout(() => {
                        messageBox.style.opacity = "0";
                        setTimeout(() => {
                            messageBox.style.display = "none";
                            messageBox.style.opacity = "1";
                        }, 1000);
                    }, 3000);
                }
            </script>
            <script>
                document.addEventListener("DOMContentLoaded", function () {
                    formatDateField("detail-from");
                    formatDateField("detail-to");
                });

                function formatDateField(fieldId) {
                    let field = document.getElementById(fieldId);
                    if (field && field.value) {
                        let date = new Date(field.value);
                        let formattedDate = ("0" + date.getDate()).slice(-2) + "/" +
                                ("0" + (date.getMonth() + 1)).slice(-2) + "/" +
                                date.getFullYear();
                        field.value = formattedDate;
                    }
                }
            </script>
        </div>
        <div id="approval-section" class="content">
            <h3>Xét Duyệt Đơn</h3>
            <table>
                <tr>
                    <th>Người Duyệt</th>
                    <th>Người Tạo</th>
                    <th>Từ Ngày</th>
                    <th>Đến Ngày</th>
                    <th>Lý Do</th>
                    <th>Action</th>
                </tr>
                <tr>
                    <td>Đặng Minh G</td>
                    <td>Nguyễn A</td>
                    <td>01/01/2026</td>
                    <td>03/01/2026</td>
                    <td>Nghỉ phép cá nhân</td>
                    <td>
                        <button class="btn btn-secondary">Reject</button>
                        <button class="btn btn-primary">Approve</button>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>