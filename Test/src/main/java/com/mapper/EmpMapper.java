package com.mapper;


import com.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper  {

    @Select("select empId ,empName from emp ")
    public List<Emp> findAll();
}
