package com.hermes.acl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hermes.model.acl.Permission;

import java.util.List;

/**
 * @author fengtingjun
 * @date 2023/8/2 07:58
 */
public interface PermissionService extends IService<Permission> {
    /**
     * 查询所有菜单
     *
     * @return {@link List }<{@link Permission }>
     * @author fengtingjun
     * @date 2023/08/02
     */
    List<Permission> queryAllMenu();

    /**
     * 递归删除菜单
     *
     * @param id
     * @return boolean
     * @author fengtingjun
     * @date 2023/08/02
     */
    boolean removeChildById(Long id);
}
