package com.ms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ms.entity.Department;
import com.ms.entity.Employee;
import com.ms.entity.Role;
import com.ms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 2017/8/4.
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employee_manager")
    public String employee_manager(Model model,@RequestParam(value="pn",defaultValue="1") Integer pn){
        //普通查询
//      List<Employee> employee= employeeService.selectEmployee();
        //升级为分页查询
        PageHelper.startPage(pn, 5);
        List<Employee> employee= employeeService.selectEmployee();
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo page = new PageInfo(employee,5);
        model.addAttribute("pageInfo", page);
        List<Department> department = employeeService.selectDepartment();
        model.addAttribute("departments",department);
        return "employee_manager";
    }


    @RequestMapping("searchEmployee")
    public String searchEmployee(String realName,Model model){
        if(realName==""){
            List<Employee> employee= employeeService.selectEmployee();
            model.addAttribute("employees", employee);
            return "redirect:/employee_manager";
        }
        List<Employee> employee= employeeService.searchByRealName(realName);
        model.addAttribute("employees", employee);
        List<Department> department = employeeService.selectDepartment();
        model.addAttribute("departments",department);
        return "employee_manager";
    }

    @RequestMapping("searchDepartment")
    public String searchDepartment(Model model,Long id){
        List<Employee> employee;
        if(id==-1){
            employee= employeeService.selectEmployee();
        }else{
            employee= employeeService.selectEmployeeByDepartment(id);
        }
        List<Department> department = employeeService.selectDepartment();
        model.addAttribute("departments",department);
        model.addAttribute("employees", employee);
        model.addAttribute("did", id);
        return "employee_manager";
    }

    @RequestMapping("editEmployee")
    public String editEmployee(Model model,Long id){
        Employee employee= employeeService.selectByPrimaryKey(id);
        model.addAttribute("user", employee);
        List<Department> department = employeeService.selectDepartment();
        model.addAttribute("departments",department);
        List<Role> role= employeeService.selectRole();
        model.addAttribute("roleSet",role);
        return "employee_edit";
    }

    @RequestMapping("deleteEmployee")
    @ResponseBody
    public String deleteEmployee(Long id){
        employeeService.deleteEmployee(id);
        return "success";
    }

    @RequestMapping("addEmployee")
    public String addEmployee(Model model){
        List<Department> department = employeeService.selectDepartment();
        model.addAttribute("departments",department);
        List<Role> role= employeeService.selectRole();
        model.addAttribute("roleSet",role);
        return "employee_add";
    }

    @RequestMapping("saveEmployeeAdd")
    public String saveEmployeeAdd(String loginName, String loginPassword, String realName, Integer sexId, Integer departmentId, Integer roleId, Long telephone,  String birthDat, String entryDat){
        DateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Date birthDate = null;
        Date entryDate = null;
        try {
            birthDate = sdf.parse(birthDat);
            entryDate = sdf.parse(entryDat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employeeService.addEmployee(loginName,loginPassword,realName,sexId,departmentId,roleId,telephone,birthDate,entryDate);
        return "forward:/employee_manager";
    }

    @RequestMapping("saveEmployeeEdit")
    public String saveEmployeeEdit(Long id,String loginName, String loginPassword, String realName, Integer sexId, Integer departmentId, Integer roleId, Long telephone, String birthDat, String entryDat){
        DateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Date birthDate = null;
        Date entryDate = null;
        try {
            birthDate = sdf.parse(birthDat);
            entryDate = sdf.parse(entryDat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employeeService.editEmployee(id,loginName,loginPassword,realName,sexId,departmentId,roleId,telephone,birthDate,entryDate);
        return "forward:/employee_manager";
    }

}
