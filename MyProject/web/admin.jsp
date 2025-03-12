<%-- 
    Document   : admin
    Created on : 11 Mar 2025, 9:29:39 pm
    Author     : admi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Lịch Làm Việc</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body { background-color: #f8f9fa; }
        .container { margin-top: 50px; }
        .form-group label { font-weight: bold; }
        .card { box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }
        .btn-custom { background-color: #007bff; color: white; }
        .btn-custom:hover { background-color: #0056b3; }
    </style>
</head>
<body>

<div class="container">
    <div class="card p-4">
        <h2 class="text-center text-primary">Thêm Lịch Làm Việc</h2>
        
        <form method="post" action="addSchedule.jsp">
            <div class="form-group mb-3">
                <label for="employeeName">Tên Nhân Viên:</label>
                <input type="text" class="form-control" id="employeeName" name="employeeName" required>
            </div>
            
            <div class="form-group mb-3">
                <label for="date">Ngày Làm Việc:</label>
                <input type="date" class="form-control" id="date" name="date" required>
            </div>
            
            <div class="form-group mb-3">
                <label>Trạng Thái:</label>
                <select class="form-control" name="status">
                    <option value="1">Đi Làm</option>
                    <option value="0">Nghỉ Phép</option>
                </select>
            </div>
            
            <button type="submit" class="btn btn-custom w-100">Thêm</button>
        </form>
   
