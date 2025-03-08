/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import java.sql.*;
/**
 *
 * @author admi
 */
public class AccountDAO extends DBContext{
    DBContext db = new DBContext();

    public Account validateUser(String username, String password) {
        String sql = "select * from Account "
                + "where Username = ? AND Password = ? ";
        try {
            PreparedStatement ps = db.connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmployeeId(rs.getInt(4));
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> getAllAccount() {
        List<Account> acc = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmployeeId(rs.getInt(4));
                acc.add(account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }

    public void AddAccount(Account account) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([Id]\n"
                + "           ,[Username]\n"
                + "           ,[Password]\n"
                + "           ,[EmployeeId])\n"
                + "     VALUES\n"
                + "           (? ,?,?,?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getEmployeeId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateAccount(Account account) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [Username] = ?\n"
                + "      ,[Password] = ?\n"
                + "      ,[EmployeeId] = ?\n"
                + " WHERE [Id] = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getEmployeeId());
            ps.setInt(4, account.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int id) {
        String sql = "DELETE FROM [dbo].[Account]\n"
                + "      WHERE Id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

