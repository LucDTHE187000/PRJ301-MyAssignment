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

    public int updateRequest(Request request) {
        int result = -1;
        String sql = "UPDATE Request SET DateFrom = ?, DateTo = ?, Reason = ? WHERE Id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, request.getDateFrom());
            ps.setDate(2, request.getDateTo());
            ps.setString(3, request.getReason());
            ps.setInt(4, request.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
//    Hàm main để test updateRequest của Employee
//    public static void main(String[] args) {
//        // Bước 1: Tạo đối tượng RequestDAO
//        RequestDAO dao = new RequestDAO();
//
//        // Bước 2: Tạo đối tượng Request với thông tin cập nhật
//        Request requestToUpdate = new Request();
//        requestToUpdate.setId(1051); // Giả sử cập nhật bản ghi có Id = 1
//        requestToUpdate.setDateFrom(new Date(System.currentTimeMillis())); // Ngày hiện tại
//        requestToUpdate.setDateTo(new Date(System.currentTimeMillis() + 86400000)); // Ngày mai
//        requestToUpdate.setReason("Lý do cập nhật để test"); // Lý do mới
//
//        // Bước 3: Gọi hàm updateRequest
//        int result = dao.updateRequest(requestToUpdate);
//
//        // Bước 4 và 5: Kiểm tra và in kết quả
//        if (result > 0) {
//            System.out.println("Cập nhật thành công! Số hàng ảnh hưởng: " + result);
//        } else {
//            System.out.println("Cập nhật thất bại! Kiểm tra Id hoặc kết nối cơ sở dữ liệu.");
//        }
//    }

    public Request getRequestById(int requestId) {
        Request request = null;
        String sql = "SELECT * FROM Request WHERE Id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, requestId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                request = new Request();
                request.setId(rs.getInt("Id"));
                request.setEmployeeId(rs.getInt("EmployeeId"));
                request.setDateTo(rs.getDate("DateTo"));
                request.setDateFrom(rs.getDate("DateFrom"));
                request.setDateCreate(rs.getDate("DateCreate"));
                request.setReason(rs.getString("Reason"));
                request.setStatus(rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return request;
    }
    public Request getRequests(int employeeId, int IdRequest) {
        Request request = null;
        String sql = "select rq.Id, rq.DateCreate, rq.DateFrom, rq.DateTo, rq.Reason, rq.Status from Request rq where rq.Id = ? AND rq.EmployeeId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, IdRequest);
            ps.setInt(2, employeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                request = new Request();
                request.setId(rs.getInt("Id"));
                request.setDateCreate(rs.getDate("DateCreate"));
                request.setDateFrom(rs.getDate("DateFrom"));
                request.setDateTo(rs.getDate("DateTo"));
                request.setReason(rs.getString("Reason"));
                request.setStatus(rs.getString("Status"));
            }
        } catch (Exception e) {
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
        String sql = "DELETE FROM Request WHERE Id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, requestId);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Requestform> getRequestsByManagerID(int managerId) {
        List<Requestform> list = new ArrayList<>();
        String sql = "SELECT r.Id, r.DateCreate, r.DateFrom, r.DateTo, r.Reason, r.Status, "
                + "e.Id AS eId, e.Name AS eName "
                + "FROM Request r "
                + "JOIN Employee e ON r.EmployeeId = e.Id "
                + "WHERE e.Parentemployee = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, managerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Requestform r = new Requestform(
                        rs.getInt("Id"),
                        rs.getDate("DateCreate"),
                        rs.getDate("DateFrom"),
                        rs.getDate("DateTo"),
                        rs.getString("Reason"),
                        rs.getString("Status"),
                        rs.getInt("eId"),
                        rs.getString("eName")
                );
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
