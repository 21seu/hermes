package com.hermes.acl.helper;

import com.google.common.collect.Lists;
import com.hermes.model.acl.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据权限数据构建菜单数据
 *
 * @author fengtingjun
 * @date 2023/8/2 08:07
 */
public class PermissionHelper {

    /**
     * 使用递归方法建菜单
     *
     * @param treeNodes
     * @return {@link List }<{@link Permission }>
     * @author fengtingjun
     * @date 2023/08/02
     */
    public static List<Permission> bulid(List<Permission> treeNodes) {
        List<Permission> trees = Lists.newArrayList();
        for (Permission treeNode : treeNodes) {
            if (treeNode.getPid() == 0) {
                treeNode.setLevel(1);
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNode
     * @param treeNodes
     * @return {@link Permission }
     * @author fengtingjun
     * @date 2023/08/02
     */
    public static Permission findChildren(Permission treeNode, List<Permission> treeNodes) {
        treeNode.setChildren(new ArrayList<Permission>());

        for (Permission it : treeNodes) {
            if (treeNode.getId().longValue() == it.getPid().longValue()) {
                int level = treeNode.getLevel() + 1;
                it.setLevel(level);
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
