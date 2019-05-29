package com.ms.service;

import com.ms.dao.EmployeeMapper;
import com.ms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dell on 2017/8/1.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Employee getEmployee(String username, String password) {
        return employeeMapper.selectByUsernameAndPassword(username, password);
    }
}
