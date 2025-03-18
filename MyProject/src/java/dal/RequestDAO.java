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
        String sql = "SELECT * FROM Request WHERE EmployeeId = ?";
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

    public int insert(Request request) {
        String sql = "INSERT INTO Request (EmployeeId, DateTo, DateFrom, DateCreate, Reason, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, request.getEmployeeId());
            ps.setDate(2, request.getDateTo());
            ps.setDate(3, request.getDateFrom());
            ps.setDate(4, request.getDateCreate());
            ps.setString(5, request.getReason());
            ps.setString(6, request.getStatus());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
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
            int employeeId = 2;
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

    public boolean updateRequestStatus(int requestId, String status) {
        String sql = "UPDATE Request SET Status = ? WHERE Id = ?";

        try (Connection conn = connection; PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, requestId);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Request> getInprogressRequestsFromManagers() {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT Id, EmployeeId, DateFrom, DateTo, DateCreate, Reason, Status FROM Request WHERE Status = 'Inprogress'";

        try (Connection conn = connection; PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt("Id"));
                request.setEmployeeId(rs.getInt("EmployeeId"));
                request.setDateFrom(rs.getDate("DateFrom"));
                request.setDateTo(rs.getDate("DateTo"));
                request.setDateCreate(rs.getDate("DateCreate"));
                request.setReason(rs.getString("Reason"));
                request.setStatus(rs.getString("Status"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public boolean updateRequest(int id, String fromDate, String toDate, String reason) {
        String sql = "UPDATE Requests SET fromDate = ?, toDate = ?, reason = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) { // Dùng connection có sẵn từ DBContext
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ps.setString(3, reason);
            ps.setInt(4, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Request getRequestById(int requestId) {
        Request request = null;
        String sql = "SELECT * FROM Request WHERE EmployeeId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, requestId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                request = new Request();
                request.setId(rs.getInt("Id"));
                request.setEmployeeId(rs.getInt("EmployeeId"));
                request.setDateFrom(rs.getDate("DateFrom"));
                request.setDateTo(rs.getDate("DateTo"));
                request.setDateCreate(rs.getDate("DateCreate"));
                request.setReason(rs.getString("Reason"));
                request.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return request;
    }

    public boolean insertRequest(String fromDate, String toDate, String reason) {
        String sql = "INSERT INTO Request (fromDate, toDate, reason, status, dateCreate) VALUES (?, ?, ?, 'Inprogress', GETDATE())";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ps.setString(3, reason);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Request> getAllRequests() {
        List<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM Request ORDER BY dateCreate DESC";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Request req = new Request(
                        rs.getInt("id"),
                        rs.getInt("employeeId"),
                        rs.getDate("dateTo"),
                        rs.getDate("dateFrom"),
                        rs.getDate("dateCreate"),
                        rs.getString("reason"),
                        rs.getString("status")
                );
                list.add(req);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean deleteRequest(int requestId) {
    String sql = "DELETE FROM request WHERE id = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, requestId);
        int affectedRows = ps.executeUpdate();
        return affectedRows > 0; // Trả về true nếu xóa thành công
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public List<Request> getRequestsByManagerId(int managerId) {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT sche.Id, sche.DateTo, sche.DateFrom, sche.Status, sche.DateCreate, sche.Reason, e.Name \n" +
"FROM Request sche \n" +
"INNER JOIN Employee e ON e.Id = sche.EmployeeId \n" +
"WHERE e.Parentemployee = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, managerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt("Id"));
                request.setDateTo(rs.getDate("DateTo"));
                request.setDateFrom(rs.getDate("DateFrom"));
                request.setStatus(rs.getString("Status"));
                request.setDateCreate(rs.getDate("DateCreate"));
                request.setReason(rs.getString("Reason"));
                
                requests.add(request);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return requests;
    }

}

