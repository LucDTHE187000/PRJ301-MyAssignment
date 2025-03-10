/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author admi
 */
public class Employee {
    private int Id;
    private String Ten;
    private Date dob;
    private int DivisionId;
    private int RoleId;

    public Employee() {
    }

    public Employee(int Id, String Ten, Date dob, int DivisionId, int RoleId) {
        this.Id = Id;
        this.Ten = Ten;
        this.dob = dob;
        this.DivisionId = DivisionId;
        this.RoleId = RoleId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getDivisionId() {
        return DivisionId;
    }

    public void setDivisionId(int DivisionId) {
        this.DivisionId = DivisionId;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int RoleId) {
        this.RoleId = RoleId;
    }
    
}
