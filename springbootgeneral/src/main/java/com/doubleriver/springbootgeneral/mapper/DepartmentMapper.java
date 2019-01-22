package com.doubleriver.springbootgeneral.mapper;

import com.doubleriver.springbootgeneral.bean.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author ronye
 * @Created 2019/1/11 - 12:38 AM
 */

//指定这是一个操作数据库的mapper
@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM department where id = #{id}")
    public Department getDepartmentById(Integer id);

    @Select ( "SELECT * FROM department" )
    public List<Department> getDepartmentsByCondition();

    @Delete("DELETE FROM department where id = #{id}")
    public int deleteById(Integer id);

    @Update ( "UPDATE department SET departmentName = #{departmentName} WHERE id=#{id} ")
    public int updateById(Department department);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert ( "INSERT INTO department (departmentName) VALUES (#{departmentName})" )
    public int insert(Department department);

}
