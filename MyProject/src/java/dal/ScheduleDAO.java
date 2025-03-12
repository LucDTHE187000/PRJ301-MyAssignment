/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.Schedule;
import java.time.LocalDate;


/**
 *
 * @author admi
 */
public class ScheduleDAO extends DBContext {

    public List<Schedule> getSchedulesByParentEmployee(int parentEmployeeId) {
        List<Schedule> schedules = new ArrayList<>();
        String sql = "SELECT sche.Id, sche.Date, sche.Status, e.Name "
                + "FROM Schedule sche "
                + "INNER JOIN Employee e ON e.Id = sche.EmployeeId "
                + "WHERE e.Parentemployee = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, parentEmployeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getInt("Id"));
                schedule.setDate(rs.getDate("Date").toLocalDate());
                schedule.setStatus(rs.getBoolean("Status"));
                schedules.add(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schedules;
    }
    
}
