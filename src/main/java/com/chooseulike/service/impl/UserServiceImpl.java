package com.chooseulike.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chooseulike.dto.Result;
import com.chooseulike.entity.User;
import com.chooseulike.mapper.UserMapper;
import com.chooseulike.service.IUserService;
import com.chooseulike.utils.RegexUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Result sendCode(String phone, HttpSession session) {
        RegexUtils.isPhoneInvalid(phone);

        return null;
    }
}
