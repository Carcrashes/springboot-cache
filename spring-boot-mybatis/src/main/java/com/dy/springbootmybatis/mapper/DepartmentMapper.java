package com.dy.springbootmybatis.mapper;

import com.dy.springbootmybatis.entity.Department;
import org.apache.ibatis.annotations.*;

/**
 * 注解标识两种方式
 *  1.在接口类中使用@Mapper
 *  2.在启动类标注@MapperScan("com.dy.springbootmybatis.mapper")
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepa(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDepa(Integer id);

    //options 返回主键注解
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name)values(#{departmentName})")
    public int insertDepa(Department department);

    @Update("update department set department_name=#{departmentName} where id= #{id}")
    public int updDepa(Department department);
}
