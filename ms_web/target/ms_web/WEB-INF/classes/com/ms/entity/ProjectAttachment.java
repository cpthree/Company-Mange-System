package com.ms.entity;

import java.util.Date;

public class ProjectAttachment {
    private Long id;

    private Long projectId;

    private String fileName;

    private String filePath;

    private Long createby;

    private Date createDate;

    public ProjectAttachment(Long id, Long projectId, String fileName, String filePath, Long createby, Date createDate) {
        this.id = id;
        this.projectId = projectId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.createby = createby;
        this.createDate = createDate;
    }

    public ProjectAttachment() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Long getCreateby() {
        return createby;
    }

    public void setCreateby(Long createby) {
        this.createby = createby;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}