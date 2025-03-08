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
public class Request {
    private int Id;
    private int EmployeeId;
    private Date DateFrom;
    private Date DateTo;
    private Date DateCreate;
    private String Reason;
    private String Status;

    public Request() {
    }

    public Request(int Id, int EmployeeId, Date DateFrom, Date DateTo, Date DateCreate, String Reason, String Status) {
        this.Id = Id;
        this.EmployeeId = EmployeeId;
        this.DateFrom = DateFrom;
        this.DateTo = DateTo;
        this.DateCreate = DateCreate;
        this.Reason = Reason;
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

    public Date getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(Date DateFrom) {
        this.DateFrom = DateFrom;
    }

    public Date getDateTo() {
        return DateTo;
    }

    public void setDateTo(Date DateTo) {
        this.DateTo = DateTo;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date DateCreate) {
        this.DateCreate = DateCreate;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
