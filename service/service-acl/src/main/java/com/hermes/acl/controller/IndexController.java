package com.hermes.acl.controller;

import com.google.common.collect.Maps;
import com.hermes.commom.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author fengtingjun
 * @date 2023/7/29 16:42
 */
@Api(tags = "登陆接口")
@RestController
@RequestMapping("/admin/acl/index")
@CrossOrigin
public class IndexController {

    /**
     * 登录
     *
     * @return {@link Result }
     * @author fengtingjun
     * @date 2023/07/29
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login() {
        //返回token值
        Map<String, String> res = Maps.newHashMap();
        res.put("token", "token-admin");
        return Result.success(res);
    }

    /**
     * 获取信息
     *
     * @return {@link Result }
     * @author fengtingjun
     * @date 2023/07/29
     */
    @ApiOperation("获取信息")
    @GetMapping("/info")
    public Result info() {
        //返回token值
        Map<String, String> res = Maps.newHashMap();
        res.put("name", "admin");
        res.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.success(res);
    }

    /**
     * 注销
     *
     * @return {@link Result }
     * @author fengtingjun
     * @date 2023/07/29
     */
    @ApiOperation("退出")
    @PostMapping("/logout")
    public Result logout() {
        //返回token值
        Map<String, String> res = Maps.newHashMap();
        return Result.success(null);
    }
}
