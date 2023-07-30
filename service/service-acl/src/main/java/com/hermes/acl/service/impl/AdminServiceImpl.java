package com.hermes.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hermes.acl.mapper.AdminMapper;
import com.hermes.acl.service.AdminService;
import com.hermes.acl.service.RoleService;
import com.hermes.model.acl.Admin;
import com.hermes.vo.acl.AdminQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author fengtingjun
 * @date 2023/7/30 18:35
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public IPage<Admin> selectPage(Page<Admin> pageParam, AdminQueryVo userQueryVo) {
        //获取用户名称条件值
        String username = userQueryVo.getUsername();
        //创建条件构造器
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(username)) {
            //封装条件
            wrapper.like(Admin::getUsername, username);
        }
        //调用mapper方法
        IPage<Admin> pageModel = adminMapper.selectPage(pageParam, wrapper);
        return pageModel;
    }
}
