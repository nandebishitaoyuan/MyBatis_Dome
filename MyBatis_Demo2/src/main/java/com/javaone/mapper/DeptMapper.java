package com.javaone.mapper;

import com.javaone.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    Dept getDeptAndEmp(@Param("did") Integer did);
}
