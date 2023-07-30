package com.hermes.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hermes.acl.service.AdminService;
import com.hermes.acl.service.RoleService;
import com.hermes.commom.result.Result;
import com.hermes.model.acl.Admin;
import com.hermes.utils.MD5Utils;
import com.hermes.vo.acl.AdminQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fengtingjun
 * @date 2023/7/30 18:31
 */
@RestController
@RequestMapping("/admin/acl/user")
@Api(tags = "用户管理")
@CrossOrigin //跨域
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取管理用户分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "userQueryVo", value = "查询对象", required = false)
            AdminQueryVo userQueryVo) {
        Page<Admin> pageParam = new Page<>(page, limit);
        IPage<Admin> pageModel = adminService.selectPage(pageParam, userQueryVo);
        return Result.success(pageModel);
    }

    @ApiOperation(value = "获取管理用户")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Admin user = adminService.getById(id);
        return Result.success(user);
    }

    @ApiOperation(value = "新增管理用户")
    @PostMapping("save")
    public Result save(@RequestBody Admin user) {
        //对密码进行MD5处理
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        adminService.save(user);
        return Result.success(null);
    }

    @ApiOperation(value = "修改管理用户")
    @PutMapping("update")
    public Result updateById(@RequestBody Admin user) {
        adminService.updateById(user);
        return Result.success(null);
    }

    @ApiOperation(value = "删除管理用户")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        adminService.removeById(id);
        return Result.success(null);
    }

    @ApiOperation(value = "根据id列表删除管理用户")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        adminService.removeByIds(idList);
        return Result.success(null);
    }
}
