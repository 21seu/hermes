package com.hermes.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hermes.acl.mapper.AdminRoleMapper;
import com.hermes.acl.service.AdminRoleService;
import com.hermes.model.acl.AdminRole;
import org.springframework.stereotype.Service;

/**
 * @author fengtingjun
 * @date 2023/8/1 08:07
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
}
