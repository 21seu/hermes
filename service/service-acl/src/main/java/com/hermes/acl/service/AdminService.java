package com.hermes.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hermes.model.acl.Admin;
import com.hermes.vo.acl.AdminQueryVo;

/**
 * @author fengtingjun
 * @date 2023/7/30 18:32
 */
public interface AdminService extends IService<Admin> {
    IPage<Admin> selectPage(Page<Admin> pageParam, AdminQueryVo userQueryVo);

}
