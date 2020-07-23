package cn.me.edge.service.impl;

import cn.me.edge.mapper.AuthRoleMapper;
import cn.me.edge.model.po.AuthRolePo;
import cn.me.edge.service.IAuthRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
@Service
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRolePo> implements IAuthRoleService {

    @Override
    public List<AuthRolePo> listRoleByUserId(Long userId) {
       return this.baseMapper.listRoleByUserId(userId);
    }
}
