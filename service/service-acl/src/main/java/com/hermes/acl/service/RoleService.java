package com.hermes.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hermes.model.acl.Role;
import com.hermes.vo.acl.RoleQueryVo;

import java.util.Map;

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

    /**
     * 根据用户获取角色数据
     *
     * @param adminId
     * @return {@link Map }<{@link String }, {@link Object }>
     * @author fengtingjun
     * @date 2023/08/01
     */
    Map<String, Object> findRoleByUserId(Long adminId);

    /**
     * 根据用户id分配角色id
     *
     * @param adminId 用户id
     * @param roleIds  角色id列表
     * @author fengtingjun
     * @date 2023/08/01
     */
    void saveUserRoleRelationShip(Long adminId, Long[] roleIds);
}
