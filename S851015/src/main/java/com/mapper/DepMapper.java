package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pojo.Dep;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface DepMapper extends BaseMapper<Dep> {

    public IPage findEmp(@Param("depId") int did , Map map);

}
