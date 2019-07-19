package com.mj.allin.modules.user.service;

import com.mj.allin.modules.user.entity.User;
import com.mj.allin.modules.user.entity.UserParam;

import java.util.List;

public interface UserService {
    List<User> getUserList(UserParam userParam);
}
