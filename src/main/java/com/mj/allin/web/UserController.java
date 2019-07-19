package com.mj.allin.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mj.allin.modules.user.entity.User;
import com.mj.allin.modules.user.entity.UserParam;
import com.mj.allin.modules.user.service.UserService;
import com.mj.allin.modules.core.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(position = 1,basePath = "ncSensor",description = "用户", value = "用户列表",tags = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ApiOperation(value="按条件获取user列表", notes="按条件获取user列表")
    @ApiImplicitParam(name = "userParam", value = "user蚕食", dataType = "UserParam", paramType = "path")
    public Result<PageInfo<User>> getUserList(Page<User> page, UserParam userParam){
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<User> list = userService.getUserList(userParam);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return new Result<PageInfo<User>>().success(pageInfo);
    }
}
