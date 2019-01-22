package com.doubleriver.springbootgeneral.controller;

import com.doubleriver.springbootgeneral.bean.Department;
import com.doubleriver.springbootgeneral.bean.Employee;
import com.doubleriver.springbootgeneral.mapper.DepartmentMapper;
import com.doubleriver.springbootgeneral.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ronye
 * @Created 2019/1/11 - 12:49 AM
 */

@Controller
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/depts")
    public String getDepartments(Model model){
        List<Department>  list = departmentMapper.getDepartmentsByCondition ();
        model.addAttribute ( "list",list );
        return "/dept/depts";
    }

    @PostMapping("/dept")
    public  String insertDepartment(Department department){
        departmentMapper.insert ( department );
        return "redirect:/depts";
    }
    @PutMapping("/dept")//需要页面表单支持
    public String updateDepartment(Department department){
        departmentMapper.updateById ( department );
        Department department1 = departmentMapper.getDepartmentById ( department.getId () );
        return "redirect:/depts";
    }
    @DeleteMapping("/dept/{id}")
    public String deleteDepartment(@PathVariable("id") Integer id){
        departmentMapper.deleteById ( id );
        return "redirect:/depts";
    }


    @GetMapping("/dept")
    public String toAddPage(Model model){
        //来到增加部门详细信息的页面
        return "/dept/addDept";
    }

    @GetMapping("/dept/{id}")
    //使用mybatis注解完成数据库操作
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Department department = departmentMapper.getDepartmentById ( id );
        model.addAttribute ( "dept",department );
        return "/dept/addDept";
    }


    @Autowired
    EmployeeMapper employeeMapper;
    @GetMapping("/emp2/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") Integer id){
        //使用mybatis配置文件查询
        Employee emp = employeeMapper.getEmpById ( id );
        return emp;
    }
}
