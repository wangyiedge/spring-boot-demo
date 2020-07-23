package cn.me.edge.service.impl;

import cn.me.edge.mapper.AuthResourceMapper;
import cn.me.edge.model.po.AuthResourcePo;
import cn.me.edge.service.IAuthResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 资源数据表 服务实现类
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
@Service
public class AuthResourceServiceImpl extends ServiceImpl<AuthResourceMapper, AuthResourcePo> implements IAuthResourceService {

    /**
     * 根据用户id获取用户所有资源权限
     *
     * @param userId 用户id
     * @return 资源列表
     */
    @Override
    @Cacheable(value = "authResource", key = "#userId")
    public List<AuthResourcePo> listResourceByUserId(Long userId) {
        return this.baseMapper.listResourceByUserId(userId);
    }

}
