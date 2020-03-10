package com.dylee.mall.service.impl;

import com.dylee.mall.MallApplicationTests;
import com.dylee.mall.enums.ResponseEnum;
import com.dylee.mall.enums.RoleEnum;
import com.dylee.mall.pojo.User;
import com.dylee.mall.service.IUserService;
import com.dylee.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional //单测的时候不会写入数据
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME = "dylee3";
    public static final String PASSWORD = "123456";
    @Autowired
    private IUserService userService;
    @Test

    @Before
    public void register() {
        User user = new User(USERNAME,PASSWORD,"dylee@qq.com", RoleEnum.CUSTUMER.getCode());
        userService.register(user);
    }
    @Test
    public void login(){
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}