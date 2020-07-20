package cn.me.edge.service.impl;

import cn.me.edge.mapper.AuthUserRoleMapper;
import cn.me.edge.model.po.AuthUserRolePo;
import cn.me.edge.service.IAuthUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
@Service
public class AuthUserRoleServiceImpl extends ServiceImpl<AuthUserRoleMapper, AuthUserRolePo> implements IAuthUserRoleService {

}
