package com.hermes.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hermes.acl.helper.PermissionHelper;
import com.hermes.acl.mapper.PermissionMapper;
import com.hermes.acl.service.PermissionService;
import com.hermes.model.acl.Permission;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengtingjun
 * @date 2023/8/2 07:58
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    /**
     * 查询所有菜单
     *
     * @return {@link List }<{@link Permission }>
     * @author fengtingjun
     * @date 2023/08/02
     */
    @Override
    public List<Permission> queryAllMenu() {
        //获取全部权限数据
        List<Permission> allPermissionList = baseMapper.selectList(
                new QueryWrapper<Permission>().orderByAsc("CAST(id AS SIGNED)"));
        //把权限数据构建成树形结构数据
        List<Permission> result = PermissionHelper.bulid(allPermissionList);
        return result;
    }

    /**
     * 递归删除菜单
     *
     * @param id
     * @return boolean
     * @author fengtingjun
     * @date 2023/08/02
     */
    @Override
    public boolean removeChildById(Long id) {
        List<Long> idList = new ArrayList<>();
        this.selectChildListById(id, idList);
        idList.add(id);
        baseMapper.deleteBatchIds(idList);
        return true;
    }

    /**
     * 递归获取子节点
     *
     * @param id
     * @param idList
     * @author fengtingjun
     * @date 2023/08/02
     */
    private void selectChildListById(Long id, List<Long> idList) {
        List<Permission> childList = baseMapper.selectList(
                new QueryWrapper<Permission>().eq("pid", id).select("id"));
        childList.forEach(item -> {
            idList.add(item.getId());
            this.selectChildListById(item.getId(), idList);
        });
    }
}
