/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

/**
 *
 * @author admi
 */

public class EmployeeDAO extends DBContext{
    DBContext db = new DBContext();
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        String sql = "select * from Employee";
    try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee em = new Employee();
                em.setId(rs.getInt(1));
                em.setTen(rs.getString(2));
                em.setDob(rs.getDate(3));
                em.setDivisionId(rs.getInt(4));
                em.setRoleId(rs.getInt(5));
                list.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Employee getEmployedID(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee ep = new Employee();
                ep.setId(rs.getInt(1));
                ep.setTen(rs.getString(2));
                ep.setDob(rs.getDate(3));
                ep.setDivisionId(rs.getInt(4));
                ep.setRoleId(rs.getInt(5));
                return ep;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   public void addEmployee(Employee employee) {
        String sql = "INSERT INTO [dbo].[Employee]\n"
                + "           ([Ten]\n"
                + "           ,[Dob]\n"
                + "           ,[DivisionId]\n"
                + "           ,[RoleId])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, employee.getTen());
            st.setDate(2, employee.getDob());
            st.setInt(3, employee.getDivisionId());
            st.setInt(4, employee.getRoleId());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateEmployee(Employee employee) {
        String sql = "UPDATE [dbo].[Employee]\n"
                + "   SET [Ten] = ?,[Dob] = ?,[DivisionId] = ?,[RoleId] = ?\n"
                + " WHERE  [Id] = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getTen());
            ps.setDate(2, employee.getDob());
            ps.setInt(3, employee.getDivisionId());
            ps.setInt(4, employee.getRoleId());
            ps.setInt(5, employee.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteEmployee(int id) {
        String sql = "DELETE FROM [dbo].[Employee]\n"
                + "      WHERE Id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
