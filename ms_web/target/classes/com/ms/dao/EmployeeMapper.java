package com.ms.dao;

import com.ms.entity.Employee;
import com.ms.entity.EmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    //登录验证
    Employee selectByUsernameAndPassword(String username, String password);

    //人事部管理主页，查询用户表+角色表+部门表
    List<Employee> selectEmployee();
    //人事部管理主页，搜索员工
    List<Employee> searchByRealName(@Param("realName") String realName);
    //人事部管理主页，搜索某部门员工
    List<Employee> selectEmployeeByDepartment(Long id);



    //old
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}