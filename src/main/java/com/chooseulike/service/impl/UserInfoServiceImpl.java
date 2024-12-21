package com.chooseulike.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chooseulike.entity.UserInfo;
import com.chooseulike.mapper.UserInfoMapper;
import com.chooseulike.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-24
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
