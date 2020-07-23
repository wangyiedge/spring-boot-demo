package cn.me.edge.service.impl;

import cn.me.edge.mapper.AuthUserMapper;
import cn.me.edge.model.po.AuthRolePo;
import cn.me.edge.model.po.AuthUserPo;
import cn.me.edge.service.IAuthUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUserPo> implements IAuthUserService {

    /**
     * 通过用户名获取用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    @Override
    public AuthUserPo getUserByUserName(String userName) {
        QueryWrapper<AuthUserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AuthUserPo::getUserName,userName);
        return this.baseMapper.selectOne(queryWrapper);
    }

}
