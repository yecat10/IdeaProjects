package com.doubleriver.springbootgeneral.controller;

import com.doubleriver.springbootgeneral.bean.Department;
import com.doubleriver.springbootgeneral.bean.Employee;
import com.doubleriver.springbootgeneral.dao.DepartmentDao;
import com.doubleriver.springbootgeneral.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @Author ronye
 * @Created 2018/12/17 - 4:13 AM
 */
@Controller
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Map<String,Collection<Employee>> map){
        Collection<Employee> list = employeeDao.getAll();
        map.put("emps",list);
        return "/emp/list";

    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到增加员工信息的页面
        Collection depts = departmentDao.getDepartments();
        logger.trace("departmentDao取得depts集合："+ depts.toString());
        model.addAttribute("depts",depts);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee emp){
        logger.trace("新增的员工信息："+ emp.toString());
        employeeDao.save(emp);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        logger.trace(id.toString());
        Employee emp = employeeDao.get(id) ;
        Department dept = emp.getDepartment();
        Collection<Department> departments = departmentDao.getDepartments();
        logger.trace(dept.toString());
        model.addAttribute("emp", emp).addAttribute("departments",departments);
        return "/emp/add";
    }

    @PutMapping("/emp")
    public String editEmp(Employee emp){
        logger.trace(emp.toString());
        employeeDao.save(emp);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        logger.trace(id.toString());
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
