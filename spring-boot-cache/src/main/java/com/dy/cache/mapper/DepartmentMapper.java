package com.dy.cache.mapper;

import com.dy.cache.entity.Department;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName DepartmentMapper
 * @Description 部门Dao层接口
 * @Author dingyu
 * @Date2019/7/2 11:25
 * @Version V1.0
 **/
public interface DepartmentMapper {

    @Select("select * from department where id =#{id}")
    public Department queryDepa(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department (department_name)values(#{departmentName})")
    public int insertDepa(Department department);

    @Update("update department set department_name=#{departmentName}")
    public int updDepa(Department department);

    @Delete("delete from department where id=#{id}")
    public int deleteDepa(Integer id);
}
