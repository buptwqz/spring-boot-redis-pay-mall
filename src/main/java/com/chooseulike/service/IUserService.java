package com.chooseulike.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chooseulike.dto.LoginFormDTO;
import com.chooseulike.dto.Result;
import com.chooseulike.entity.User;

import javax.servlet.http.HttpSession;

public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);
}
