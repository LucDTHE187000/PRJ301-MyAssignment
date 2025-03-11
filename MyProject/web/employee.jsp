<%-- 
    Document   : welcome
    Created on : 11 Mar 2025, 8:56:12 pm
    Author     : admi
--%>

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
        .btn-primary { background: #4facfe; }
        .btn-primary:hover { background: #3b8bfe; }
        .btn-secondary { background: #ff7e5f; }
        .btn-secondary:hover { background: #e86c4f; }
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
        <h2>Hệ Thống Quản Lý Nghỉ Phép</h2>
        <div class="button-group">
            <button class="btn btn-primary" onclick="showSection('create-form')">Tạo Đơn</button>
            <button class="btn btn-primary" onclick="showSection('list-requests')">Danh Sách Đơn</button>
            
        </div>
        <div id="create-form" class="content">
            <h3>Tạo Đơn Nghỉ Phép</h3>
            <form>
                <div class="form-group">
                    <label for="start-date">Ngày Bắt Đầu:</label>
                    <input type="date" id="start-date" name="start-date">
                </div>
                <div class="form-group">
                    <label for="end-date">Ngày Kết Thúc:</label>
                    <input type="date" id="end-date" name="end-date">
                </div>
                <div class="form-group">
                    <label for="reason">Lý Do Nghỉ Phép:</label>
                    <textarea id="reason" name="reason" rows="3"></textarea>
                </div>
                <div class="btn-group">
                    <button type="reset" class="btn btn-secondary">Hủy</button>
                    <button type="submit" class="btn btn-primary">Gửi Đơn</button>
                </div>
            </form>
        </div>
        <div id="list-requests" class="content">
            <h3>Danh Sách Đơn</h3>
            <table>
                <tr>
                    <th>Lý Do</th>
                    <th>Từ Ngày</th>
                    <th>Đến Ngày</th>
                    <th>Trạng Thái</th>
                    <th>Người Tạo</th>
                    <th>Action</th>
                </tr>
                <tr>
                    <td>Nghỉ phép cá nhân</td>
                    <td>01/01/2026</td>
                    <td>03/01/2026</td>
                    <td>In Progress</td>
                    <td>Nguyễn A</td>
                    
                    <td><button class="btn btn-primary">Xem</button>
                        <button class="btn btn-primary">Xét Duyệt</button>
                    </td>
                </tr>
            </table>
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
    </div>
</body>
</html>