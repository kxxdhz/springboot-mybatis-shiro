package com.djb.mapper;

import org.springframework.stereotype.Repository;

import com.djb.po.User;

@Repository
public interface UserMapper {

//	@Select("select * from User where username = #{username}")
    public User getByUsername(String  username);
	
}
