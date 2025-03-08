/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;



/**
 *
 * @author admi
 */
public class Schedule {
    private int Id;
    private int EmployeeId;
    private LocalDate Date;
    private boolean Status;

    public Schedule() {
    }

    public Schedule(int Id, int EmployeeId, LocalDate Date, boolean Status) {
        this.Id = Id;
        this.EmployeeId = EmployeeId;
        this.Date = Date;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
}
