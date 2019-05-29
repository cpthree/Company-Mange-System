package com.ms.controller;

import com.ms.entity.Employee;
import com.ms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String toLogin(String username,String password,HttpSession session){
        Employee employee=loginService.getEmployee(username,password);
        if(employee==null){
            return "redirect:/login.jsp";
        }
        else{
            session.setAttribute("employee", employee);
            if(employee.getDepartment().getDepartmentName().equals("人事部")){
                return "forward:/employee_manager";
            }
            if(employee.getDepartment().getDepartmentName().equals("项目部")){
                return "forward:/project_manager";
            }
            if(employee.getDepartment().getDepartmentName().equals("财务部")){
                return "forward:/finance_manager";
            }
            else{
//                可以放最后那个部门代替管理员部门
//                return "forward:/finance_manager";
                return "admin_manager";
            }
        }
    }

    @RequestMapping("/login_out")
    public String logout(HttpSession session){
        session.removeAttribute("employee");
        return "redirect:login.jsp";
    }


}
