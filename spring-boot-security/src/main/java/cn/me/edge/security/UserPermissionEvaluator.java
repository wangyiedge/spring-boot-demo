package cn.me.edge.security;

import cn.me.edge.model.po.AuthResourcePo;
import cn.me.edge.model.security.SysUserEntity;
import cn.me.edge.service.IAuthResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义用户权限校验逻辑。
 * 用于{@link PreAuthorize}注解中 hasPermission()方法
 *
 * @author edge
 * @date 2020/7/17
 */
@Component
public class UserPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private IAuthResourceService authResourceService;


    @Override
    public boolean hasPermission(Authentication authentication, Object uri, Object permission) {
        // 获取用户信息
        SysUserEntity sysUserEntity =(SysUserEntity) authentication.getPrincipal();
        Set<String> resourceList = new HashSet<>();
        // TODO 查询用户权限，方法开启了缓存. 后期需要替换成redis缓存并设置过期逻辑
        List<AuthResourcePo> authResourceList = authResourceService.listResourceByUserId(sysUserEntity.getUserId());
        for (AuthResourcePo po:authResourceList) {
            resourceList.add(po.getCode());
        }
        return resourceList.contains(uri.toString());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String targetType, Object o) {
        return false;
    }
}
