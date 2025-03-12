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
    private String Name;
    private Date dob;
    private int Parentemployee;

    public Employee() {
    }

    public Employee(int Id, String Name, Date dob, int Parentemployee) {
        this.Id = Id;
        this.Name = Name;
        this.dob = dob;
        this.Parentemployee = Parentemployee;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getParentemployee() {
        return Parentemployee;
    }

    public void setParentemployee(int Parentemployee) {
        this.Parentemployee = Parentemployee;
    }

}