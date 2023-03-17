package com.example.springbootmybatise.Controller;

import com.example.springbootmybatise.dao.entity.User;
import com.example.springbootmybatise.dao.mapper.UserMapper;

import com.example.springbootmybatise.dao.mapper.UserMapperXml;
import com.example.springbootmybatise.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControllerTest {
    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    UserMapperXml userMapperXml;


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public void addUser() {
        User user = new User("linny", "linnyyz", "lz123456");
        System.out.println(userMapper.insertUser(user));
    }

    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    public List<User> selectUser(@RequestParam("name")String name){
        User user = new User();
        user.setName(name);
        List<User> users = new ArrayList<>();
        users = userMapper.selectUser(user);
        for(User user1:users){
            System.out.println(user1);
        }
        return users;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestParam("userName")String userName, @RequestParam("password")String password){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User returnUser = userMapper.login(user);
        Map<String,Object> returnMap = new HashMap<>();
        String token = "";
        if(returnUser==null){
            returnMap.put("message","fail");
        }
        else {
            token = TokenUtil.getToken(userName,password);
            returnMap.put("message","success");
        }
        returnMap.put("user",returnUser);
        returnMap.put("token",token);
        returnMap.put("status",200);
        return returnMap;
    }

    @RequestMapping(value = "/tokenTest")
    public String testToken(){
        return "成功进来啦!";
    }
}
