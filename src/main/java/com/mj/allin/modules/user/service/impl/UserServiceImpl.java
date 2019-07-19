package com.mj.allin.modules.user.service.impl;

import com.mj.allin.modules.user.mapper.UserMapper;
import com.mj.allin.modules.user.entity.User;
import com.mj.allin.modules.user.entity.UserParam;
import com.mj.allin.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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
    @Scheduled(fixedRate = 5000) // 表示 每隔 5000 毫秒执行一次
    //@Scheduled(cron = "0/5 * * * * *")  // 表示 在指定时间执行
    public void reportCurrentTime() {
        System.out.println("每隔五秒钟执行一次： " + new Date().getTime());
    }
}
