package com.hermes.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hermes.acl.service.RoleService;
import com.hermes.commom.constant.ResultEnum;
import com.hermes.commom.exception.BusinessException;
import com.hermes.commom.result.Result;
import com.hermes.model.acl.Admin;
import com.hermes.model.acl.Role;
import com.hermes.vo.acl.RoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 角色接口
 *
 * @author fengtingjun
 * @date 2023/7/29 17:12
 */
@Api(tags = "角色接口")
@RestController
@RequestMapping("/admin/acl/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取角色分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "roleQueryVo", value = "查询对象", required = false)
            RoleQueryVo roleQueryVo) {
        Page<Role> pageParam = new Page<>(page, limit);
        IPage<Role> pageModel = roleService.selectPage(pageParam, roleQueryVo);
        return Result.success(pageModel);
    }

    @ApiOperation(value = "根据id查询角色")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        if (Objects.isNull(id)) {
            throw new BusinessException(ResultEnum.ILLEGAL_REQUEST);
        }
        return Result.success(roleService.getById(id));
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("save")
    public Result save(@RequestBody Role role) {
        boolean isSuccess = roleService.save(role);
        if (isSuccess) {
            return Result.success(null);
        }
        return Result.fail(null);
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("update")
    public Result updateById(@RequestBody Role role) {
        roleService.updateById(role);
        return Result.success(null);
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        roleService.removeById(id);
        return Result.success(null);
    }

    @ApiOperation(value = "根据id列表删除角色")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        roleService.removeByIds(idList);
        return Result.success(null);
    }
}
