package com.djb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.djb.po.Demo;

@Repository
public interface DemoMapper {

	@Select("select * from Demo where name = #{name}")
    public List<Demo> findByName(String name);

    @Select("select * from Demo where id = #{id}")
    public Demo getById(long id);

    @Select("select name from Demo where id = #{id}")
    public String getNameById(long id);
    
    public void insertDemo(Demo demo);
	
}
