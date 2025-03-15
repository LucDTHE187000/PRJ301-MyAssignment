/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Request;
import java.sql.Date;
import java.sql.*;

/**
 *
 * @author admi
 */
public class RequestDAO extends DBContext {

    DBContext db = new DBContext();

    public List<Request> getRequestsByEmployeeId(int employeeId) {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM [Request] WHERE EmployeeId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt("Id"));
                request.setEmployeeId(rs.getInt("EmployeeId"));
                request.setDateTo(rs.getDate("DateTo"));
                request.setDateFrom(rs.getDate("DateFrom"));
                request.setDateCreate(rs.getDate("DateCreate"));
                request.setReason(rs.getString("Reason"));
                request.setStatus(rs.getString("Status"));

                requests.add(request);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return requests;
    }

    public void insertRequest(Request request) {
        String sql = "INSERT INTO Request (EmployeeId, DateTo, DateFrom, DateCreate, Reason, Status) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, request.getEmployeeId());
            ps.setDate(2, request.getDateTo());
            ps.setDate(3, request.getDateFrom());
            ps.setDate(4, request.getDateCreate());
            ps.setString(5, request.getReason());
            ps.setString(6, request.getStatus());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean addRequest(Request request) {
        String sql = "INSERT INTO Request (EmployeeId, DateTo, DateFrom, DateCreate, Reason, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, request.getEmployeeId());
            ps.setDate(2, request.getDateTo());
            ps.setDate(3, request.getDateFrom());
            ps.setDate(4, request.getDateCreate());
            ps.setString(5, request.getReason());
            ps.setString(6, request.getStatus());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đơn nghỉ phép đã được gửi thành công!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        RequestDAO requestDAO = new RequestDAO();
        try {
            int employeeId = 6;
            // Gọi phương thức getAllRequests để lấy danh sách đơn nghỉ phép
            List<Request> requests = requestDAO.getRequestsByEmployeeId(employeeId);
            System.out.println("Kết nối đến database thành công!");
            System.out.println("Số đơn nghỉ phép hiện có: " + requests.size());
            // Hiển thị thông tin đơn đầu tiên nếu có
            if (!requests.isEmpty()) {
                Request r = requests.get(0);
                System.out.println("Đơn đầu tiên: ");
                System.out.println("EmployeeId: " + r.getEmployeeId());
                System.out.println("DateFrom: " + r.getDateFrom());
                System.out.println("DateTo: " + r.getDateTo());
                System.out.println("Reason: " + r.getReason());
                System.out.println("Status: " + r.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi kết nối hoặc truy vấn dữ liệu:");
            e.printStackTrace();
        }
    }
}
