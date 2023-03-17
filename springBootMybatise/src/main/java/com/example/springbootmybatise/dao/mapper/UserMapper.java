package com.example.springbootmybatise.dao.mapper;

import com.example.springbootmybatise.dao.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserMapper {
    /**
     * insert user
     * @param user
     * @return boolean
     */

    @Insert("insert into user(name,userName,password) values(#{name},#{userName},#{password})")
    public boolean insertUser(User user);

    /**
     *select user
     * @param user
     * @return
     */
    @Select("select * from user where name like '%${name}%'")
    public List<User> selectUser(User user);


    /**
     * login
     * @param user
     * @return
     */
    @Select("select * from user where userName=#{userName} and password=#{password}")
    public User login(User user);
}
