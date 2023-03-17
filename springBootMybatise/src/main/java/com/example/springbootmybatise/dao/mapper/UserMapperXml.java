package com.example.springbootmybatise.dao.mapper;

import com.example.springbootmybatise.dao.entity.User;

import java.util.List;

public interface UserMapperXml {

    public List<User> selectUserAll(User user);

    public List<User> select2();
}
