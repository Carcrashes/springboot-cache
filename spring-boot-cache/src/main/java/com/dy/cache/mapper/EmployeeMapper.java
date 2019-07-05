package com.dy.cache.mapper;

import com.dy.cache.entity.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName DepartmentMapper
 * @Description 员工Dao层接口
 * @Author dingyu
 * @Date2019/7/2 11:25
 * @Version V1.0
 **/
public interface EmployeeMapper {

    @Select("select * from employee where id= #{id}")
    public Employee getEmp(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into employee (lastName,email,gender,d_id)values(#{lastName},#{email}.#{gender},#{dId})")
    public Employee addEmp(Employee employee);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId}")
    public Employee updEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public int  delEmp(Integer id);

    @Select("select * from employee where lastName like '%#{lastName}%'")
    public Employee getEmpByName(String lastName);


}
