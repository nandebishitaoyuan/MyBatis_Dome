package com.javaone.mapper;

import com.javaone.pojo.Emp;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询所有员工
     * @return
     */
    List<Emp> gatAllEmp();
}
