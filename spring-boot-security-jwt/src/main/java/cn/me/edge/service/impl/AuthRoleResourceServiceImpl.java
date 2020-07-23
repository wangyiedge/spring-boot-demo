package cn.me.edge.service.impl;

import cn.me.edge.mapper.AuthRoleResourceMapper;
import cn.me.edge.model.po.AuthRoleResourcePo;
import cn.me.edge.service.IAuthRoleResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色资源关联表 服务实现类
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
@Service
public class AuthRoleResourceServiceImpl extends ServiceImpl<AuthRoleResourceMapper, AuthRoleResourcePo> implements IAuthRoleResourceService {

}
