package com.hermes.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hermes.model.acl.Role;
import com.hermes.vo.acl.RoleQueryVo;

/**
 * @author fengtingjun
 * @date 2023/7/29 17:13
 */
public interface RoleService extends IService<Role> {

    /**
     * 角色分页列表
     *
     * @param pageParam
     * @param roleQueryVo
     * @return {@link IPage }<{@link Role }>
     * @author fengtingjun
     * @date 2023/07/29
     */
    IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo);
}
