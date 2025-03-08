/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author admi
 */
public class Employee {
    private int Id;
    private String name;
    private Date dob;
    private String Email;
    private String Phone;
    private int DivisionId;
    private int RoleId;

    public Employee() {
    }

    public Employee(int Id, String name, Date dob, String Email, String Phone, int DivisionId, int RoleId) {
        this.Id = Id;
        this.name = name;
        this.dob = dob;
        this.Email = Email;
        this.Phone = Phone;
        this.DivisionId = DivisionId;
        this.RoleId = RoleId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
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
