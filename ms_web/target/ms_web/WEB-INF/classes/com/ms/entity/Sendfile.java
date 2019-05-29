package com.ms.entity;

import java.util.Date;

public class Sendfile {

    //一对多
    private Department department;


    private Long id;

    private String fileName;

    private String sender;

    private Long departmentId;

    private Date sendDate;

    private Date editDate;

    public Sendfile(Long id, String fileName, String sender, Long departmentId, Date sendDate, Date editDate) {
        this.id = id;
        this.fileName = fileName;
        this.sender = sender;
        this.departmentId = departmentId;
        this.sendDate = sendDate;
        this.editDate = editDate;
    }

    public Sendfile() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}