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

/**
 *
 * @author admi
 */
public class RequestDAO extends DBContext{
    public List<Request> getAllRequests() {
    List<Request> requests = new ArrayList<>();
        String sql = "SELECT Id, EmployeeId, DateTo, DateFrom, DateCreate, Reason, Status FROM Request";
        
        try {
             PreparedStatement ps = connection.prepareStatement(sql);
             
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
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requests;
    }
}




