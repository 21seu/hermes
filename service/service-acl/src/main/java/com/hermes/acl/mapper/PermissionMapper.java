package com.hermes.acl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hermes.model.acl.Permission;
import org.mapstruct.Mapper;

/**
 * @author fengtingjun
 * @date 2023/8/1 23:23
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
