<%-- 
    Document   : create
    Created on : 16 Mar 2025, 11:09:51 pm
    Author     : admi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Tạo Đơn Nghỉ Phép</title>
    <style>
    body {
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #7F7FD5, #86A8E7, #91EAE4);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    position: relative;
}

.content {
    background: #ffffff;
    padding: 25px;
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
    width: 420px;
}

h3 {
    text-align: center;
    color: #333;
    font-weight: bold;
}

.form-group {
    margin-bottom: 15px;
}

label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
    color: #333;
}

input, textarea {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 14px;
    box-sizing: border-box;
}

input:focus, textarea:focus {
    border-color: #2575fc;
    outline: none;
    box-shadow: 0 0 5px rgba(37, 117, 252, 0.5);
}

.btn-group {
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
}

button {
    padding: 10px 15px;
    border: none;
    border-radius: 6px;
    font-size: 16px;
    cursor: pointer;
    transition: 0.3s;
    width: 48%;
}

.btn-secondary {
    background: #ff6b6b;
    color: white;
}

.btn-secondary:hover {
    background: #e63946;
}

.btn-primary {
    background: #2575fc;
    color: white;
}

.btn-primary:hover {
    background: #1a5cc3;
}

a.back-link {
    position: absolute;
    top: 15px;
    left: 20px;
    color: #2575fc;
    text-decoration: none;
    font-weight: bold;
    font-size: 16px;
    transition: 0.3s;
}

a.back-link:hover {
    text-decoration: underline;
}
</style>
</head>
<body>
    
    <div id="create-form" class="content">
                <h3>Tạo Đơn Nghỉ Phép</h3>
                <form action="Request" method="POST">
                    <div class="form-group">
                        <label for="to-date">Ngày Bắt Đầu:</label>
                        <input type="date" id="to-date" name="toDate">
                    </div>
                    <div class="form-group">
                        <label for="from-date">Ngày Kết Thúc:</label>
                        <input type="date" id="from-date" name="fromDate">
                    </div>
                    <div class="form-group">
                        <label for="create-date">Ngày Tạo Đơn:</label>
                        <input type="date" id="create-date" name="createDate">
                    </div>
                    <div class="form-group">
                        <label for="reason">Lý Do Nghỉ Phép:</label>
                        <textarea id="reason" name="reason" rows="3"></textarea>
                    </div>
                    <div class="btn-group">
                        <button type="reset" class="btn btn-secondary">Hủy</button>
                        <button type="submit" class="btn btn-primary">Gửi Đơn</button>
                    </div>
                    <a href="welcome.jsp">Quay Lại</a>
                </form>
            </div>
</body>
</html>
