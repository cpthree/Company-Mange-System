package com.ms.service;

import com.ms.entity.Employee;

/**
 * Created by Dell on 2017/8/1.
 */
public interface LoginService {
    Employee getEmployee(String username, String password);
}
