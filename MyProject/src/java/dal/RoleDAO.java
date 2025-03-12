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
import model.Role;

/**
 *
 * @author admi
 */
public class RoleDAO extends DBContext{
    
   public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT Id, Name, Description FROM Role";
        
        try {PreparedStatement ps = connection.prepareStatement(sql);
           // ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role(
                    rs.getInt("Id"),
                    rs.getString("Name"),
                    rs.getString("Description")
                );
                roles.add(role);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }
   public class Main {
    public static void main(String[] args) {
        RoleDAO roleDAO = new RoleDAO();
        List<Role> roles = roleDAO.getAllRoles();
        
        for (Role role : roles) {
            System.out.println("ID: " + role.getId());
            System.out.println("Name: " + role.getName());
            System.out.println("Description: " + role.getDescription());
            System.out.println("----------------------");
        }
    }
  }
} 

