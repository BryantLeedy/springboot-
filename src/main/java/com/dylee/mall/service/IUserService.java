package com.dylee.mall.service;

import com.dylee.mall.pojo.User;
import com.dylee.mall.vo.ResponseVo;

public interface IUserService {
//    注册
    ResponseVo<User> register(User user);

//    登录
    ResponseVo<User> login(String username,String password);
}
