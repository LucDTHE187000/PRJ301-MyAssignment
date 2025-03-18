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
public class RequestDTO {
    private int Id;
    private Date DateTo;
    private Date DateFrom;
    private Date DateCreate;
    private String Reason;
    private String Status; 
    private int eId;
    private String eName;

    public RequestDTO() {
    }

    public RequestDTO(int Id, Date DateTo, Date DateFrom, Date DateCreate, String Reason, String Status, int eId, String eName) {
        this.Id = Id;
        this.DateTo = DateTo;
        this.DateFrom = DateFrom;
        this.DateCreate = DateCreate;
        this.Reason = Reason;
        this.Status = Status;
        this.eId = eId;
        this.eName = eName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getDateTo() {
        return DateTo;
    }

    public void setDateTo(Date DateTo) {
        this.DateTo = DateTo;
    }

    public Date getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(Date DateFrom) {
        this.DateFrom = DateFrom;
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

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
}
