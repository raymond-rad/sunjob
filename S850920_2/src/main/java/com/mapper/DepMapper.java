package com.mapper;

import com.pojo.Dep;
import com.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepMapper {

    @Select("select depId,depName from dep")
    public List<Dep> findall();

    @Select("select depId,depName from dep where depId = #{depId}")
    public List<Dep> findId(int depId);

    @Select("select empId , empName from emp where empId =#{empId} and empName = #{empName}")
    public List<Emp> findEmp(@Param("empId") int empId,@Param("empName") String empName);
}
