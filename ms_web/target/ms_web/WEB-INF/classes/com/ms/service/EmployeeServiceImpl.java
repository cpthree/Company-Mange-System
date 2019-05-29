package com.ms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.dao.DepartmentMapper;
import com.ms.dao.EmployeeMapper;
import com.ms.dao.RoleMapper;
import com.ms.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2017/8/5.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Employee> selectEmployee() {
        return employeeMapper.selectEmployee();
    }

    @Override
    public List<Department> selectDepartment() {
        return departmentMapper.selectByExample(new DepartmentExample());
    }

    @Override
    public List<Employee> searchByRealName(String realName) {
        return employeeMapper.searchByRealName(realName);
    }

    @Override
    public List<Employee> selectEmployeeByDepartment(Long id) {
        return employeeMapper.selectEmployeeByDepartment(id);
    }

    @Override
    public Employee selectByPrimaryKey(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> selectRole() {
        return roleMapper.selectRole();
    }

    @Override
    public void deleteEmployee(Long id) {
            employeeMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int addEmployee(String loginName, String loginPassword, String realName, Integer sexId, Integer departmentId, Integer roleId, Long telephone, Date birthDate, Date entryDate) {
        return employeeMapper.insertSelective(new Employee(loginName,loginPassword,realName,sexId,departmentId,roleId,telephone,birthDate,entryDate));
    }

    @Override
    public int editEmployee(Long id, String loginName, String loginPassword, String realName, Integer sexId, Integer departmentId, Integer roleId, Long telephone, Date birthDate, Date entryDate) {
        return employeeMapper.updateByPrimaryKeySelective(new Employee(id,loginName,loginPassword,realName,sexId,departmentId,roleId,telephone,birthDate,entryDate));
    }




}
