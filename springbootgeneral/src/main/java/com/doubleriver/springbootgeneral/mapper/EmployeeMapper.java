package com.doubleriver.springbootgeneral.mapper;

import com.doubleriver.springbootgeneral.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ronye
 * @Created 2019/1/11 - 12:38 AM
 */

@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
}
