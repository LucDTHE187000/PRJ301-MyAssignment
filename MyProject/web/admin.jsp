<%-- 
    Document   : admin
    Created on : 11 Mar 2025, 9:29:39 pm
    Author     : admi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agenda</title>
    
    <style>
        body {
            background-color: #f0f8ff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .table-container {
            background-color: white;
            border-radius: 15px;
            padding: 20px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }
        .table th {
            background-color: #007bff;
            color: white;
        }
        .table td {
            text-align: center;
            vertical-align: middle;
        }
        .working {
            background-color: #90ee90;
        }
        .leave {
            background-color: #ff6961;
        }
    </style>
</head>
<body>
<div class="table-container">
    <h2 class="text-center mb-4">Agenda - Tình hình lao động của phòng ban</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Nhân sự</th>
            <th>1/1</th>
            <th>2/1</th>
            <th>3/1</th>
            <th>4/1</th>
            <th>5/1</th>
            <th>6/1</th>
            <th>7/1</th>
            <th>8/1</th>
            <th>9/1</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Mr A</td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
        </tr>
        <tr>
            <td>Mr B</td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="leave"></td>
            <td class="leave"></td>
            <td class="leave"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
        </tr>
        <tr>
            <td>Mr C</td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="leave"></td>
            <td class="leave"></td>
            <td class="working"></td>
        </tr>
        <tr>
            <td>Mr D</td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="working"></td>
            <td class="leave"></td>
     <td class="working"></td>
            <td class="working"></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
