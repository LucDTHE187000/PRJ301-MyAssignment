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
public class Requestform {
    private Integer id;
    private Date dateTo;
    private Date DateFrom;
    private Date dateCreate;
    private String reason;
    private String Status;
    private int eId;
    private String eName;

    public Requestform() {
    }

    public Requestform(Integer id, Date dateTo, Date DateFrom, Date dateCreate, String reason, String Status, int eId, String eName) {
        this.id = id;
        this.dateTo = dateTo;
        this.DateFrom = DateFrom;
        this.dateCreate = dateCreate;
        this.reason = reason;
        this.Status = Status;
        this.eId = eId;
        this.eName = eName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(Date DateFrom) {
        this.DateFrom = DateFrom;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    @Override
    public String toString() {
        return "Requestform{" + "id=" + id + ", dateTo=" + dateTo + ", DateFrom=" + DateFrom + ", dateCreate=" + dateCreate + ", reason=" + reason + ", Status=" + Status + ", eId=" + eId + ", eName=" + eName + '}';
    }

}
