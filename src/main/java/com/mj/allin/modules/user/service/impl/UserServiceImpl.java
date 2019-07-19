package com.mj.allin.modules.user.service.impl;

import com.mj.allin.modules.user.mapper.UserMapper;
import com.mj.allin.modules.user.entity.User;
import com.mj.allin.modules.user.entity.UserParam;
import com.mj.allin.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserList(UserParam userParam) {
        Map<String,Object> map = new HashMap<>();
        List<User> list = userMapper.getUserList(map);
        return list;
    }
}
