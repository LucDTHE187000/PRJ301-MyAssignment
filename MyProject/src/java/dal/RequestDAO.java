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
import model.RequestDTO;
import model.Requestform;

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
    public List<Request> getRequestsByEmployeeId1(int employeeId) {
    List<Request> requests = new ArrayList<>();
    String sql = "SELECT * FROM Request WHERE EmployeeId = ?";
    
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, employeeId); // EmployeeId là int
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) { // Lặp để lấy nhiều đơn
            Request request = new Request();
            request.setId(rs.getInt("Id"));
            request.setEmployeeId(rs.getInt("EmployeeId")); // Giữ nguyên getInt()
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
    
    return requests; // Trả về danh sách đơn
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

    public List<Requestform> getRequestsbyManagerID(int managerId) {
        List<Requestform> list = new ArrayList<>();
        String sql = "SELECT r.Id, r.DateCreate, r.DateFrom, r.DateTo, r.Reason, r.Status, e.Id AS eId, e.Name AS eName " +
                     "FROM Request r " +
                     "INNER JOIN Employee e ON r.EmployeeId = e.Id " +
                     "WHERE r.EmployeeId = ?"; // Lọc theo EmployeeId của Manager
        try (PreparedStatement st = db.connection.prepareStatement(sql)) {
            st.setInt(1, managerId); // Truyền Manager ID (ví dụ: 2)
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Requestform r = new Requestform();
                r.setId(rs.getInt("Id"));
                r.setDateCreate(rs.getDate("DateCreate"));
                r.setDateFrom(rs.getDate("DateFrom"));
                r.setDateTo(rs.getDate("DateTo"));
                r.setReason(rs.getString("Reason"));
                r.setStatus(rs.getString("Status"));
                r.seteId(rs.getInt("eId"));
                r.seteName(rs.getString("eName")); 
                list.add(r);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
 
    public static void main(String[] args) {
        // Tạo đối tượng RequestDAO
        RequestDAO dao = new RequestDAO();

        // Gán managerId cần test (thay đổi theo dữ liệu thực tế của bạn)
        int managerId = 3;

        // Gọi hàm getRequestByManagerID và nhận danh sách request
        List<Requestform> requests = dao.getRequestsbyManagerID(managerId);

        // Kiểm tra và in kết quả
        if (requests.isEmpty()) {
            System.out.println("Không có request nào cho managerId = " + managerId);
        } else {
            System.out.println("Danh sách request cho managerId = " + managerId + ":");
            for (Requestform req : requests) {
                System.out.println(req);
            }
        }
    }

    
 
}
