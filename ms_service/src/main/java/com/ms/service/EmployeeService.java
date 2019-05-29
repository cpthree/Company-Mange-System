package com.ms.service;

import com.ms.entity.Department;
import com.ms.entity.Employee;
import com.ms.entity.Role;

import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2017/8/5.
 */
public interface EmployeeService {
    List<Employee> selectEmployee();
    List<Department> selectDepartment();
    List<Employee> searchByRealName(String realName);
    List<Employee> selectEmployeeByDepartment(Long id);
    Employee selectByPrimaryKey(Long id);
    List<Role> selectRole();
    void deleteEmployee(Long id);
    int addEmployee(String loginName, String loginPassword, String realName, Integer sexId, Integer departmentId, Integer roleId, Long telephone, Date birthDate, Date entryDate);
    int editEmployee(Long id, String loginName, String loginPassword, String realName, Integer sexId, Integer departmentId, Integer roleId, Long telephone, Date birthDate, Date entryDate);

}
