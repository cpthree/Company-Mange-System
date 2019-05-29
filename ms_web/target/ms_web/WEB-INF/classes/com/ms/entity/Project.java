package com.ms.entity;

import java.util.Date;

public class Project {
    private Long id;

    private String projectName;

    private String location;

    private Long landArea;

    private Long buildArea;

    private Integer floor;

    private String eiaPeople;

    private String permit;

    private Integer auditFlag;

    private Date successDate;

    public Project(Long id, String projectName, String location, Long landArea, Long buildArea, Integer floor, String eiaPeople, String permit, Integer auditFlag, Date successDate) {
        this.id = id;
        this.projectName = projectName;
        this.location = location;
        this.landArea = landArea;
        this.buildArea = buildArea;
        this.floor = floor;
        this.eiaPeople = eiaPeople;
        this.permit = permit;
        this.auditFlag = auditFlag;
        this.successDate = successDate;
    }

    public Project(String projectName, String location, Long landArea, Long buildArea, Integer floor, String eiaPeople, String permit, Integer auditFlag, Date successDate) {
        this.projectName = projectName;
        this.location = location;
        this.landArea = landArea;
        this.buildArea = buildArea;
        this.floor = floor;
        this.eiaPeople = eiaPeople;
        this.permit = permit;
        this.auditFlag = auditFlag;
        this.successDate = successDate;
    }

    public Project() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Long getLandArea() {
        return landArea;
    }

    public void setLandArea(Long landArea) {
        this.landArea = landArea;
    }

    public Long getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(Long buildArea) {
        this.buildArea = buildArea;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getEiaPeople() {
        return eiaPeople;
    }

    public void setEiaPeople(String eiaPeople) {
        this.eiaPeople = eiaPeople == null ? null : eiaPeople.trim();
    }

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit == null ? null : permit.trim();
    }

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Date getSuccessDate() {
        return successDate;
    }

    public void setSuccessDate(Date successDate) {
        this.successDate = successDate;
    }
}