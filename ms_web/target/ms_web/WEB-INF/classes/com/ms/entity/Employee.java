package com.ms.entity;

import java.util.Date;

public class Employee {
    //一对多
    private Department department;
    private Role role;

    //old

    private Long id;

    private String loginName;

    private String loginPassword;

    private String realName;

    private Integer sexId;

    private Integer departmentId;

    private Integer roleId;

    private Long telephone;

    private Date birthDate;

    private Date entryDate;

    public Employee(Long id, String loginName, String loginPassword, String realName, Integer sexId, Integer departmentId, Integer roleId, Long telephone, Date birthDate, Date entryDate) {
        this.id = id;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.realName = realName;
        this.sexId = sexId;
        this.departmentId = departmentId;
        this.roleId = roleId;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.entryDate = entryDate;
    }

    public Employee(String loginName, String loginPassword, String realName, Integer sexId, Integer departmentId, Integer roleId, Long telephone, Date birthDate, Date entryDate) {
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.realName = realName;
        this.sexId = sexId;
        this.departmentId = departmentId;
        this.roleId = roleId;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.entryDate = entryDate;
    }

    public Employee() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



}