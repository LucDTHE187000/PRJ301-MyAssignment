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
                em.setName(rs.getString(2));
                em.setDob(rs.getDate(3));
                em.setParentemployee(rs.getInt(4));
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
                ep.setName(rs.getString(2));
                ep.setDob(rs.getDate(3));
                ep.setParentemployee(rs.getInt(4));
                
                return ep;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   public void addEmployee(Employee employee) {
        String sql = "INSERT INTO [dbo].[Employee]\n"
                + "           ([Name]\n"
                + "           ,[Dob]\n"
                + "           ,[Parentemployee]\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, employee.getName());
            st.setDate(2, employee.getDob());
            st.setInt(3, employee.getParentemployee());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateEmployee(Employee employee) {
        String sql = "UPDATE [dbo].[Employee]\n"
                + "   SET [Name] = ?,[Dob] = ?,[Parentemployee] = ?\n"
                + " WHERE  [Id] = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setDate(2, employee.getDob());
            ps.setInt(3, employee.getParentemployee());
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
